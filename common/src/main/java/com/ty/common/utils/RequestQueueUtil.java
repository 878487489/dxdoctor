package com.ty.common.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author 檀煜
 * volley请求队列单例工具类
 */
public class RequestQueueUtil {

    private static RequestQueue sRequestQueue;

    public static RequestQueue getRequestQueue(Context context) {
        if (sRequestQueue == null) {
            synchronized (RequestQueue.class) {
                if (sRequestQueue == null) {
                    sRequestQueue = Volley.newRequestQueue(context);
                }
            }
        }
        return sRequestQueue;
    }

}
