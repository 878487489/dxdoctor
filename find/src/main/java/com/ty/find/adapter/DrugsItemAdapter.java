package com.ty.find.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ty.find.R;
import com.ty.find.bean.DrugsTtem;

import java.util.List;

public class DrugsItemAdapter extends BaseAdapter {

    private List<DrugsTtem> drugsTtemList ;

    public DrugsItemAdapter(List<DrugsTtem> drugsTtemList) {
        this.drugsTtemList = drugsTtemList;
    }

    @Override
    public int getCount() {
        return drugsTtemList.size();
    }

    @Override
    public Object getItem(int position) {
        return drugsTtemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_drugs_gridview_item, null);;
        ImageView drugsImg = view.findViewById(R.id.drugs_img);
        TextView drugsTitle = view.findViewById(R.id.drugs_title);
        TextView drugsSubtitle = view.findViewById(R.id.drugs_subtitle);

        drugsImg.setImageResource(drugsTtemList.get(position).getImg());
        drugsTitle.setText(drugsTtemList.get(position).getTitle());
        drugsSubtitle.setText(drugsTtemList.get(position).getSubtitle());
        return view;
    }
}
