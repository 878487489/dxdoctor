package com.ty.seedoctor;

import android.app.Activity;

import com.ty.common.interfaces.Iresponse;
import com.ty.common.utils.RequestUtil;

import org.json.JSONObject;

public class DoctorModel implements DoctorContract.DoctorModel {

    @Override
    public void getNewsAnser(Activity activity, String tag, final INewsAnserBack iNewsAnserBack) {
        RequestUtil.getInstance().get(activity, "https://www.fastmock.site/mock/12c9ed2e156e7a145aed9f3e36d11cd3/appApi/newestanswer", new JSONObject(), new Iresponse() {
            @Override
            public void success(JSONObject data) {
                iNewsAnserBack.backData(data);
            }

            @Override
            public void fail(String error) {
            }
        },tag);
    }

    interface INewsAnserBack{
        void backData(JSONObject data);
    }

}
