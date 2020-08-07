package com.ty.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.volley.RequestQueue;
import com.qmuiteam.qmui.widget.QMUIFloatLayout;
import com.ty.common.BaseActivity;
import com.ty.common.utils.RequestQueueUtil;
import com.ty.search.bean.HotKey;
import com.ty.search.widget.SearBar;

import java.util.List;

@Route(path = "/activity/SearchActivity")
public class SearchActivity extends BaseActivity implements SearchContract.SearchtView {
    private static String TAG = "SearchActivity";
    private SearBar mSearBar;
    private QMUIFloatLayout mQMUIFloatLayout;
    private SearchContract.SearchPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }
    public void initView(){
        mSearBar = findViewById(R.id.searbar);
        mQMUIFloatLayout = findViewById(R.id.float_layout);
        presenter = new SearchPresenter(this);
        presenter.init(this,TAG);
        mSearBar.setiTitleinterface(new SearBar.ITitleinterface() {
            @Override
            public void onClickBack(View view) {
                finish();
            }
            @Override
            public void getContent(String txt) {

            }
        });


    }

    private TextView creatTextView(String title){
        TextView textView = new TextView(this);
        textView.setWidth(150);
        textView.setHeight(80);
        textView.setTextSize(12);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundResource(R.drawable.hot_kuy_border);
        textView.setText(title);
        return textView;
    }

    @Override
    public void backHotKeys(List<HotKey> hotKeyList) {
        mQMUIFloatLayout.setChildHorizontalSpacing(20);
        mQMUIFloatLayout.setChildVerticalSpacing(10);
        for(HotKey key:hotKeyList){
            mQMUIFloatLayout.addView(creatTextView(key.getWord()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RequestQueueUtil.getRequestQueue(this).cancelAll(TAG);
    }
}