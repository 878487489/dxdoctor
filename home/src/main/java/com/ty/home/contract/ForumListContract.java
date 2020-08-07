package com.ty.home.contract;

import android.app.Activity;

import com.ty.home.bean.FormListBean;
import com.ty.home.model.ForumListModel;

import java.util.List;

public interface ForumListContract {

    interface ForumListModel{
        void getFormList(Activity activity, String tag, com.ty.home.model.ForumListModel.ICallBack iCallBack);
    }

    interface ForumListPresenter{
        void init(Activity activity, String tag);
    }

    interface ForumListView{
        void backFormList(List<FormListBean> formListBeanList);
    }
}
