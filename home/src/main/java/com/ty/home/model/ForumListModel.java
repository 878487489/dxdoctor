package com.ty.home.model;

import android.app.Activity;

import com.ty.common.interfaces.Iresponse;
import com.ty.common.utils.RequestUtil;
import com.ty.home.api.HomeApi;
import com.ty.home.contract.ForumListContract;

import org.json.JSONObject;

public class ForumListModel implements ForumListContract.ForumListModel {


    @Override
    public void getFormList(Activity activity, String tag, final ICallBack iCallBack) {
        RequestUtil.getInstance().get(activity, HomeApi.formMoreApi, new JSONObject(), new Iresponse() {
            @Override
            public void success(JSONObject data) {
                iCallBack.back(data);
            }
            @Override
            public void fail(String error) {
            }
        },tag);
    }

    public interface ICallBack{
        void back(JSONObject object);
    }
}
