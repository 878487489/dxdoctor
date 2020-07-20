package com.ty.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;


public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    private FragmentTransaction mTransaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        mTransaction.replace(R.id.container, homeFragment);
        mTransaction.commit();
    }
}