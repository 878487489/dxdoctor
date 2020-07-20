package com.ty.home;

import android.app.Activity;

import com.ty.home.bean.FormListBean;
import com.ty.home.bean.HealListBean;

import java.util.List;

public interface IHomeContract {

    interface HomeModel{
        //获取医师讲堂数据
       void getFormList(Activity activity, String tag, com.ty.home.HomeModel.IVolleyBack volleyBack);
       //获取饮食健康数据
       void getHealth(Activity activity, String tag, com.ty.home.HomeModel.IVolleyHealBack volleyHealBack);
    }

    interface HomePresenter{
        //初始化所有请求
       void initRequest(Activity activity, String tag);
    }

    interface HomeView{
        void formListSuccess(List<FormListBean> formListBeanList);
        void formHealSuccess(List<HealListBean> healListBeanList);
    }
}
