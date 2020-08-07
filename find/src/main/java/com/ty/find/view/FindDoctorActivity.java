package com.ty.find.view;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.ty.common.BaseActivity;
import com.ty.find.R;
import com.ty.find.adapter.DeptmentAdapter;
import com.ty.find.adapter.ItemAdapter;
import com.ty.find.bean.DeptItem;
import com.ty.find.contract.FindDoctorContract;
import com.ty.find.presenter.FindDoctorPresenter;
import com.ty.find.widget.ItemGradview;

import java.util.Arrays;
import java.util.List;

@Route(path = "/find/FindDoctorActivity")
public class FindDoctorActivity extends BaseActivity implements FindDoctorContract.IFindDoctorView {
    private static String TAG = "FindDoctorActivity";
    private QMUITopBarLayout mQMUITopBarLayout;
    private ItemGradview mGridView;
    private RecyclerView deptmentRecycleview;
    private FindDoctorPresenter findDoctorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        initView();
    }

    private void initView(){
        mQMUITopBarLayout = findViewById(R.id.find_doctor_tobar);
        mGridView = findViewById(R.id.find_doctor_mygrideview);

        deptmentRecycleview = findViewById(R.id.deptment_recycleview);
        findDoctorPresenter = new FindDoctorPresenter(this);
        findDoctorPresenter.init(this,TAG);
        initBar();
        initFloatItem();
    }

    private void initBar(){
        mQMUITopBarLayout.setTitle(getString(R.string.tab_title));
        mQMUITopBarLayout.addLeftImageButton(R.drawable.ic_back_24,0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initFloatItem(){
        String[] itemTitle = {"流感","用药咨询","疫苗咨询","宝宝健康","护肤","美容整形","肥胖","月经不调","支气管炎","鼻炎","焦虑","失眠"};
        ItemAdapter adapter = new ItemAdapter(Arrays.asList(itemTitle));
        mGridView.setAdapter(adapter);
    }


    @Override
    public void deptListBck(List<DeptItem> deptItemList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        deptmentRecycleview.addItemDecoration(new DividerItemDecoration(this,1));
        deptmentRecycleview.setLayoutManager(linearLayoutManager);
        DeptmentAdapter adapter = new DeptmentAdapter(deptItemList);
        deptmentRecycleview.setAdapter(adapter);
    }

}