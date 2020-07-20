package com.ty.common.interfaces;

import org.json.JSONObject;

/**
 * @author 檀煜
 * 回调请求数据
 */
public interface Iresponse {
    void success(JSONObject data);
    void fail(String error);
}
