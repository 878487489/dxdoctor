package com.ty.home.api;

import com.ty.common.config.RequestConfig;

import static com.ty.common.config.RequestConfig.baseUrl;

public class HomeApi {
    //首页获取问答请求地址
    public static String formApi = baseUrl +"/forum/list";
    //更多医生讲堂数据
    public static String formMoreApi = baseUrl +"/form/list/more";
    //首页获取健康数据请求地址
    public static String tabHealApi = baseUrl+"/tab/healthydiet";
}
