package com.ty.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.ty.home.adapter.FormAdapter;
import com.ty.home.bean.FormListBean;
import com.ty.home.bean.HealListBean;

import org.json.JSONObject;

import java.util.List;

/**
 * @author 檀煜
 */
@Route(path = "/home/fragment")
public class HomeFragment extends Fragment implements IHomeContract.HomeView {
    private View mView;
    private static String TAG = "HomeFragment";
    private HomePresenter homePresenter;

    //广告控件
    private QMUIRadiusImageView AD1;
    private QMUIRadiusImageView AD2;

    private RecyclerView mRecyclerView;
    private QMUIGroupListView moreForm;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homePresenter = new HomePresenter(this);
        homePresenter.initRequest(getActivity(),TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the titlebar_layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return mView;
    }

    public void initView(){
        mRecyclerView = mView.findViewById(R.id.home_recycleview);
        moreForm = mView.findViewById(R.id.more_form);
        AD1 = mView.findViewById(R.id.ad_1);
        AD2 = mView.findViewById(R.id.ad_2);
        AD1.setCornerRadius(QMUIDisplayHelper.dp2px(getContext(), 5));
        AD1.setBorderWidth(QMUIDisplayHelper.dp2px(getContext(), 0));
        AD2.setCornerRadius(QMUIDisplayHelper.dp2px(getContext(), 5));
        AD2.setBorderWidth(QMUIDisplayHelper.dp2px(getContext(), 0));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),1));
        QMUICommonListItemView itemWithChevron = moreForm.createItemView("医师讲堂");
        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron.setDetailText("更多");
        moreForm.addView(itemWithChevron);
        // 设置布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerView.setLayoutManager(linearLayoutManager);

    }


    @Override
    public void formListSuccess(List<FormListBean> formListBeanList) {
        Log.d(TAG,formListBeanList.toString());
         FormAdapter adapter = new FormAdapter(formListBeanList);
         mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void formHealSuccess(List<HealListBean> healListBeanList) {
        Log.d(TAG,healListBeanList.toString());
    }
}