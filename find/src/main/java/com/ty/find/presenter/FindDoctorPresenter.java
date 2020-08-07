package com.ty.find.presenter;

import android.app.Activity;

import com.google.gson.reflect.TypeToken;
import com.ty.common.bean.BaseBean;
import com.ty.common.utils.GsonUtil;
import com.ty.find.bean.DeptItem;
import com.ty.find.contract.FindDoctorContract;
import com.ty.find.model.FindDoctorModel;

import org.json.JSONObject;

import java.util.List;

public class FindDoctorPresenter implements FindDoctorContract.IFindDoctorPresenter {

    private FindDoctorContract.IFindDoctorView view;
    private FindDoctorContract.IFindDoctorModel model = new FindDoctorModel();

    public FindDoctorPresenter(FindDoctorContract.IFindDoctorView view) {
        this.view = view;
    }

    @Override
    public void init(Activity activity, String tag) {
        model.getDeptList(activity, tag, new FindDoctorModel.IBackDeptList() {
            @Override
            public void listBack(JSONObject jsonObject) {
                BaseBean<List<DeptItem>> beanBaseBean = GsonUtil.getInstance().fromJson(jsonObject.toString(),
                        new TypeToken<BaseBean<List<DeptItem>>>() {}.getType());
                view.deptListBck(beanBaseBean.getData());
            }
        });
    }
}
