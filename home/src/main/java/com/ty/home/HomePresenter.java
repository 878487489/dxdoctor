package com.ty.home;

import android.app.Activity;
import android.renderscript.Type;

import com.google.gson.reflect.TypeToken;
import com.ty.common.bean.BaseBean;
import com.ty.common.utils.GsonUtil;
import com.ty.home.bean.FormListBean;
import com.ty.home.bean.HealListBean;

import org.json.JSONObject;

import java.util.List;

public class HomePresenter implements IHomeContract.HomePresenter {

    private HomeModel mHomeModel = new HomeModel();
    private IHomeContract.HomeView  mHomeView ;

    public HomePresenter(IHomeContract.HomeView homeView) {
        this.mHomeView = homeView;
    }

    @Override
    public void initRequest(Activity activity, String tag) {
        initFormList(activity,tag);
        initHealList(activity,tag);
    }

    private void initFormList(Activity activity,String tag){
        mHomeModel.getFormList(activity, tag, new HomeModel.IVolleyBack() {
            @Override
            public void formBack(JSONObject formListObj) {
            BaseBean<List<FormListBean>> beanBaseBean = GsonUtil.getInstance().fromJson(formListObj.toString(),
                    new TypeToken<BaseBean<List<FormListBean>>>() {}.getType());
        mHomeView.formListSuccess(beanBaseBean.getData());
            }
        });
    }

    private void initHealList(Activity activity,String tag){
        mHomeModel.getHealth(activity, tag, new HomeModel.IVolleyHealBack() {
            @Override
            public void healBack(JSONObject healListObj) {
                BaseBean<List<HealListBean>> beanBaseBean = GsonUtil.getInstance().fromJson(healListObj.toString(),
                        new TypeToken<BaseBean<List<HealListBean>>>() {}.getType());
                mHomeView.formHealSuccess(beanBaseBean.getData());
            }
        });
    }
}
