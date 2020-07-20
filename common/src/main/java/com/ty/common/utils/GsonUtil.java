package com.ty.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ty.common.bean.BaseBean;

public class GsonUtil {
    private static Gson instance;

    public static Gson getInstance() {
        if (null==instance){
            synchronized (Gson.class) {
                if (instance == null) {
                    instance = new Gson();
                }
            }
        }
        return instance;
    }



}
