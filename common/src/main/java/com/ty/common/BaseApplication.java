package com.ty.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.android.volley.RequestQueue;
import com.ty.common.utils.RequestQueueUtil;

public class BaseApplication extends Application {
    private boolean isDebugARouter = true;

    public static RequestQueue sRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        sRequestQueue = RequestQueueUtil.getRequestQueue(this);

    }
}
