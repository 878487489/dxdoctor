package com.ty.mine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MineMainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    private FragmentTransaction mTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        MineFragment mineFragment = new MineFragment();
        mTransaction.replace(R.id.frame_mine, mineFragment);
        mTransaction.commit();
    }
}