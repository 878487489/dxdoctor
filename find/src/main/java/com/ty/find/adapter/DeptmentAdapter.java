package com.ty.find.adapter;

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
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.ty.find.R;
import com.ty.find.bean.DeptItem;
import com.ty.find.utils.UrlToDrawable;

import java.util.List;

public class DeptmentAdapter extends RecyclerView.Adapter<DeptmentAdapter.DeptmentVH>  {


    private List<DeptItem> deptItemList;
    private Context mContext;

    public DeptmentAdapter(List<DeptItem> deptItemList) {
        this.deptItemList = deptItemList;
    }

    @NonNull
    @Override
    public DeptmentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        return new DeptmentVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.find_doctor_deptment_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DeptmentVH holder, int position) {
        Glide.with(mContext).load(deptItemList.get(position).getIcon()).into(holder.deptImg);
        holder.deptTitle.setText(deptItemList.get(position).getIcontitle());
        holder.deptDesc.setText(deptItemList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return deptItemList.size();
    }

    class DeptmentVH extends RecyclerView.ViewHolder{
        private ImageView deptImg;
        private TextView deptTitle;
        private TextView deptDesc;

        public DeptmentVH(@NonNull View itemView) {
            super(itemView);
            this.deptImg = itemView.findViewById(R.id.dept_img);
            this.deptTitle = itemView.findViewById(R.id.dept_title);
            this.deptDesc = itemView.findViewById(R.id.dept_desc);
        }
    }
}
