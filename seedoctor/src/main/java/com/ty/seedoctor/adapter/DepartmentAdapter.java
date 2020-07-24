package com.ty.seedoctor.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ty.seedoctor.R;
import com.ty.seedoctor.bean.Department;

import java.util.List;

public class DepartmentAdapter extends BaseAdapter {

    private List<Department> departmentList;

    public DepartmentAdapter(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public int getCount() {
        return departmentList.size();
    }

    @Override
    public Object getItem(int position) {
        return departmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grideview_item_department, null);
        ImageView img = view.findViewById(R.id.department_img);
        TextView name = view.findViewById(R.id.department_name);
        img.setBackgroundResource(departmentList.get(position).getDeptartmentImg());
        name.setText(departmentList.get(position).getDepartName());
        return view;
    }
}
