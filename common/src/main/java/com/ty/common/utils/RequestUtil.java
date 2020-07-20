package com.ty.common.utils;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ty.common.BaseApplication;
import com.ty.common.interfaces.Iresponse;
import org.json.JSONObject;
public class RequestUtil {
    //获取请求队列
    private RequestQueue mRequestQueue = BaseApplication.sRequestQueue;

    private static RequestUtil instance;

    //单例获取工具类
    public static RequestUtil getInstance() {
        if (instance == null) {
            synchronized (RequestUtil.class) {
                if (instance == null) {
                    instance = new RequestUtil();
                }
            }
        }
        return instance;
    }

    public void get(Activity activity, String url, final JSONObject object, final Iresponse iresponse,String TAG){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                iresponse.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iresponse.fail(error.toString());
            }
        });
        request.setTag(TAG);
        mRequestQueue.add(request);
    }

    public void post(Activity activity, String url, final JSONObject object, final Iresponse iresponse,String TAG){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                iresponse.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iresponse.fail(error.toString());
            }
        });
        request.setTag(TAG);
        mRequestQueue.add(request);
    }

}
