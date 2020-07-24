package com.ty.seedoctor;

import android.app.Activity;

import com.google.gson.reflect.TypeToken;
import com.ty.common.bean.BaseBean;
import com.ty.common.utils.GsonUtil;
import com.ty.seedoctor.bean.AnswerItme;

import org.json.JSONObject;

import java.util.List;

public class DoctorPresenter implements DoctorContract.DoctorPresenter {

    private DoctorContract.DoctorView doctorView;
    private DoctorContract.DoctorModel doctorModel = new DoctorModel();

    public DoctorPresenter(DoctorContract.DoctorView doctorView) {
        this.doctorView = doctorView;
    }

    @Override
    public void initView(Activity activity, String tag) {
        doctorModel.getNewsAnser(activity, tag, new DoctorModel.INewsAnserBack() {
            @Override
            public void backData(JSONObject data) {
                BaseBean<List<AnswerItme>> beanBaseBean = GsonUtil.getInstance().fromJson(data.toString(),
                        new TypeToken<BaseBean<List<AnswerItme>>>() {}.getType());
                doctorView.newsAnserSuccess(beanBaseBean.getData());
            }
        });
    }
}
