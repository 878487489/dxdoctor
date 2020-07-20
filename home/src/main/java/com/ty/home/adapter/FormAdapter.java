package com.ty.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.ty.home.R;
import com.ty.home.bean.FormListBean;

import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.FormVholder> {

    List<FormListBean> formListBeanList;
    private Context context;

    public FormAdapter(List<FormListBean> formListBeanList) {
        this.formListBeanList = formListBeanList;
    }

    @NonNull
    @Override
    public FormVholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        return new FormVholder(mLayoutInflater.inflate(R.layout.recycleview_item_form, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FormVholder holder, int position) {
        holder.formName.setText(formListBeanList.get(position).getTitle());
        holder.formContent.setText(formListBeanList.get(position).getContent());
        holder.formPrice.setText("¥ "+formListBeanList.get(position).getPrice());
        holder.formPerson.setText(formListBeanList.get(position).getPerson()+"人参与");
        Glide.with(context).load(formListBeanList.get(position).getImgurl()).into(holder.formImg);
    }

    @Override
    public int getItemCount() {
        return this.formListBeanList.size()==0?0:this.formListBeanList.size();
    }

    class FormVholder extends RecyclerView.ViewHolder{
       private TextView formName;
       private TextView formContent;
       private TextView formPrice;
       private TextView formPerson;
       private QMUIRadiusImageView formImg;
        public FormVholder(@NonNull View itemView) {
            super(itemView);
            formName = itemView.findViewById(R.id.form_name);
            formContent = itemView.findViewById(R.id.form_content);
            formPrice = itemView.findViewById(R.id.form_price);
            formPerson = itemView.findViewById(R.id.form_person);
            formImg = itemView.findViewById(R.id.form_img);
            formImg.setCornerRadius(QMUIDisplayHelper.dp2px(itemView.getContext(), 5));
            formImg.setBorderWidth(QMUIDisplayHelper.dp2px(itemView.getContext(), 0));
        }
    }
}
