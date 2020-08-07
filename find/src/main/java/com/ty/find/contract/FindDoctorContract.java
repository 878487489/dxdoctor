package com.ty.find.contract;

import android.app.Activity;

import com.ty.find.bean.DeptItem;
import com.ty.find.model.FindDoctorModel;

import java.util.List;

public interface FindDoctorContract {

    interface IFindDoctorPresenter{
        void init(Activity activity, String tag);
    }

    interface IFindDoctorModel{
        void getDeptList(Activity activity, String tag, FindDoctorModel.IBackDeptList backDeptList);
    }

    interface IFindDoctorView{
        void deptListBck(List<DeptItem> deptItemList);
    }
}
