package com.ty.home;

import android.app.Activity;
import android.util.Log;

import com.ty.common.config.RequestConfig;
import com.ty.common.interfaces.Iresponse;
import com.ty.common.utils.RequestUtil;
import com.ty.home.api.HomeApi;

import org.json.JSONObject;

public class HomeModel implements IHomeContract.HomeModel {

    @Override
    public void getFormList(Activity activity, final String tag, final IVolleyBack volleyBack) {
        RequestUtil.getInstance().get(activity, HomeApi.formApi, new JSONObject(), new Iresponse() {
            @Override
            public void success(JSONObject data) {
                volleyBack.formBack(data);
            }

            @Override
            public void fail(String error) {
            }
        },tag);
    }

    @Override
    public void getHealth(Activity activity, final String tag, final IVolleyHealBack volleyHealBack) {
        RequestUtil.getInstance().get(activity, HomeApi.tabHealApi, new JSONObject(), new Iresponse() {
            @Override
            public void success(JSONObject data) {
                volleyHealBack.healBack(data);
            }

            @Override
            public void fail(String error) {
            }
        },tag);
    }

    public interface IVolleyBack{
        void formBack(JSONObject formListObj);
    }

    public interface IVolleyHealBack{
        void healBack(JSONObject healListObj);
    }
}
