package com.ty.seedoctor;

import android.app.Activity;

import com.ty.seedoctor.bean.AnswerItme;

import java.util.List;

public interface DoctorContract {

     interface DoctorModel{
        void getNewsAnser(Activity activity, String tag, com.ty.seedoctor.DoctorModel.INewsAnserBack back);
    }

    interface DoctorPresenter{
        void initView(Activity activity,String tag);
    }

    interface DoctorView{
        void newsAnserSuccess(List<AnswerItme> answerItmeList);
    }
}
