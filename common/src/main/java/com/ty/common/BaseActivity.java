package com.ty.common;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.WHITE);
    }
}
