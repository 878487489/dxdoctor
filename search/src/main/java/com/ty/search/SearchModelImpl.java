package com.ty.search;

import android.app.Activity;

import com.ty.common.interfaces.Iresponse;
import com.ty.common.utils.RequestUtil;
import com.ty.search.api.SearApi;

import org.json.JSONObject;

public class SearchModelImpl implements SearchContract.SearchModel {


    @Override
    public void getHotkey(Activity activity, String tag, final IHotBack iHotBack) {
        RequestUtil.getInstance().get(activity, SearApi.hotApi, new JSONObject(), new Iresponse() {
            @Override
            public void success(JSONObject data) {
                iHotBack.backData(data);
            }

            @Override
            public void fail(String error) {

            }
        },tag);
    }

    interface IHotBack{
        void backData(JSONObject object);
    }
}
