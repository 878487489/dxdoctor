package com.ty.home;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment;
import com.qmuiteam.qmui.widget.tab.QMUITabBuilder;
import com.qmuiteam.qmui.widget.tab.QMUITabIndicator;
import com.qmuiteam.qmui.widget.tab.QMUITabSegment;
import com.ty.home.adapter.FormAdapter;
import com.ty.home.adapter.TabContentAdapter;
import com.ty.home.bean.FormListBean;
import com.ty.home.bean.HealListBean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //底部切换
    private QMUITabSegment mTabSegment;
    private ViewPager mViewPager;
    List<View> recyclerViewList = new ArrayList<>();
    private RecyclerView contentRecycleView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePresenter = new HomePresenter(this);
        homePresenter.initRequest(getActivity(),TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return mView;
    }

    public void initView(){
        mRecyclerView = mView.findViewById(R.id.home_recycleview);
        moreForm = mView.findViewById(R.id.more_form);
        mTabSegment = mView.findViewById(R.id.home_tab);
        mViewPager = mView.findViewById(R.id.tab_viewpage);
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

    public void initTabRecycleview(){
        //创建RecyclerView
        contentRecycleView = new RecyclerView(getContext());
        contentRecycleView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 400));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        contentRecycleView.setLayoutManager(linearLayoutManager);
        contentRecycleView.addItemDecoration(new DividerItemDecoration(getContext(),1));
        recyclerViewList.add(contentRecycleView);
        //初始化tab
        QMUITabBuilder builder = mTabSegment.tabBuilder();
        builder.setSelectColor(Color.parseColor("#00baad"));
        mTabSegment.addTab(builder.setText("饮食健康").build(getContext()));
        mTabSegment.addTab(builder.setText("两性健康").build(getContext()));
        mTabSegment.addTab(builder.setText("孕产育儿").build(getContext()));
        mTabSegment.addTab(builder.setText("常见疾病").build(getContext()));
        mTabSegment.setupWithViewPager(mViewPager,false);
        mTabSegment.setMode(QMUITabSegment.MODE_FIXED);

        mTabSegment.setIndicator(new QMUITabIndicator(
                QMUIDisplayHelper.dp2px(getContext(), 2), false, true));
        mTabSegment.addOnTabSelectedListener(new QMUIBasicTabSegment.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int index) {

            }

            @Override
            public void onTabUnselected(int index) {

            }

            @Override
            public void onTabReselected(int index) {

            }

            @Override
            public void onDoubleTap(int index) {
                mTabSegment.clearSignCountView(index);
            }
        });
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void formListSuccess(List<FormListBean> formListBeanList) {
         FormAdapter adapter = new FormAdapter(formListBeanList);
         mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void formHealSuccess(List<HealListBean> healListBeanList) {
        initTabRecycleview();
        TabContentAdapter adapter = new TabContentAdapter(healListBeanList);
        contentRecycleView.setAdapter(adapter);
    }

    private PagerAdapter mPagerAdapter = new PagerAdapter() {
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return recyclerViewList.size();
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {
            View view = recyclerViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    };


}