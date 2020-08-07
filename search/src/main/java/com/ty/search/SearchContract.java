package com.ty.search;

import android.app.Activity;

import com.ty.search.bean.HotKey;

import java.util.List;

public interface SearchContract {
    interface SearchModel{
        void getHotkey(Activity activity, String tag, SearchModelImpl.IHotBack iHotBack);
    }
    interface SearchPresenter{
        void init(Activity activity, String tag);
    }
    interface SearchtView{
         void backHotKeys(List<HotKey> hotKeyList);
    }
}
