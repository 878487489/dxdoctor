package com.ty.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ty.common.R;

public class TitleBar extends LinearLayout {
    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.titlebar_layout,this);

        LinearLayout gotoSearch = findViewById(R.id.input_search);
        gotoSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/activity/SearchActivity").navigation();
            }
        });
    }

    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
