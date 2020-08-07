package com.ty.find.model;

import android.app.Activity;

import com.ty.common.interfaces.Iresponse;
import com.ty.common.utils.RequestUtil;
import com.ty.find.api.FindDoctorApi;
import com.ty.find.contract.FindDoctorContract;

import org.json.JSONObject;

public class FindDoctorModel implements FindDoctorContract.IFindDoctorModel {

    @Override
    public void getDeptList(Activity activity, String tag, final IBackDeptList backDeptList) {
        RequestUtil.getInstance().get(activity, FindDoctorApi.DEPTMENTAPI, new JSONObject(), new Iresponse() {
            @Override
            public void success(JSONObject data) {
                backDeptList.listBack(data);
            }

            @Override
            public void fail(String error) {

            }
        },tag);
    }

    public interface IBackDeptList{
        void listBack(JSONObject jsonObject);
    }

}
