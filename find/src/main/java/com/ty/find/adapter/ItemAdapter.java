package com.ty.find.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ty.find.R;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private List<String> stringList ;

    public ItemAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_doctor_gridview_item, null);;
        TextView textView = view.findViewById(R.id.gridview_item);
        textView.setText(stringList.get(position));
        return view;
    }
}
