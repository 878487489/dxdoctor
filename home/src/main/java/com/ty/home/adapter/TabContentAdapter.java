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
import com.ty.home.bean.HealListBean;

import java.util.List;

public class TabContentAdapter extends RecyclerView.Adapter<TabContentAdapter.TabContentViewHolder> {

    private Context context;
     List<HealListBean> healListBeanList ;


    public TabContentAdapter(List<HealListBean> healListBeanList) {
        this.healListBeanList = healListBeanList;
    }


    @NonNull
    @Override
    public TabContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       this.context = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        View view = mLayoutInflater.inflate(R.layout.recycleview_tab_content_item,parent,false);
        return new TabContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabContentViewHolder holder, int position) {
        holder.contentTitle.setText(healListBeanList.get(position).getTitle());
        holder.contentAuther.setText(healListBeanList.get(position).getAuthor());
        Glide.with(context).load(healListBeanList.get(position).getImgurl()).into(holder.contentUrl);
    }

    @Override
    public int getItemCount() {
        return healListBeanList.size();
    }

    class TabContentViewHolder extends RecyclerView.ViewHolder{

        private TextView contentTitle;
        private TextView contentAuther;
        private QMUIRadiusImageView contentUrl;

        public TabContentViewHolder(@NonNull View itemView) {
            super(itemView);
            contentTitle = itemView.findViewById(R.id.content_title);
            contentAuther = itemView.findViewById(R.id.content_auther);
            contentUrl = itemView.findViewById(R.id.content_url);
            contentUrl.setCornerRadius(QMUIDisplayHelper.dp2px(itemView.getContext(), 5));
            contentUrl.setBorderWidth(QMUIDisplayHelper.dp2px(itemView.getContext(), 0));
        }
    }
}
