package com.ty.home.presenter;

import android.app.Activity;

import com.google.gson.reflect.TypeToken;
import com.ty.common.bean.BaseBean;
import com.ty.common.utils.GsonUtil;
import com.ty.home.bean.FormListBean;
import com.ty.home.contract.ForumListContract;
import com.ty.home.model.ForumListModel;

import org.json.JSONObject;

import java.util.List;

public class ForumListPresenter implements ForumListContract.ForumListPresenter {

    private ForumListContract.ForumListView forumListView;
    private ForumListModel model = new ForumListModel();


    public ForumListPresenter(ForumListContract.ForumListView forumListView) {
        this.forumListView = forumListView;
    }

    @Override
    public void init(Activity activity, String tag) {
        model.getFormList(activity, tag, new ForumListModel.ICallBack() {
            @Override
            public void back(JSONObject object) {
                BaseBean<List<FormListBean>> beanBaseBean = GsonUtil.getInstance().fromJson(object.toString(),
                        new TypeToken<BaseBean<List<FormListBean>>>() {}.getType());
                forumListView.backFormList(beanBaseBean.getData());
            }
        });
    }


}
