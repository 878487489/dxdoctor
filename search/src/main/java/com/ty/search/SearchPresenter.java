package com.ty.search;

import android.app.Activity;

import com.google.gson.reflect.TypeToken;
import com.ty.common.bean.BaseBean;
import com.ty.common.utils.GsonUtil;
import com.ty.search.bean.HotKey;

import org.json.JSONObject;

import java.util.List;

public class SearchPresenter implements SearchContract.SearchPresenter {

    private SearchContract.SearchModel model= new SearchModelImpl();
    private SearchContract.SearchtView searchtView;

    public SearchPresenter(SearchContract.SearchtView searchtView) {
        this.searchtView = searchtView;
    }

    @Override
    public void init(Activity activity, String tag) {
        initHot(activity,tag);
    }

    private void initHot(Activity activity, String tag){
        model.getHotkey(activity, tag, new SearchModelImpl.IHotBack() {
            @Override
            public void backData(JSONObject object) {
                BaseBean<List<HotKey>> beanBaseBean = GsonUtil.getInstance().fromJson(object.toString(),
                        new TypeToken<BaseBean<List<HotKey>>>() {}.getType());
                searchtView.backHotKeys(beanBaseBean.getData());
            }
        });
    }
}
