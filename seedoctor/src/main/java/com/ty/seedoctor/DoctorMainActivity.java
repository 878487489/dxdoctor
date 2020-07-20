package com.ty.seedoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

public class DoctorMainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    private FragmentTransaction mTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        SeeDoctorFragment seeDoctorFragment = new SeeDoctorFragment();
        mTransaction.replace(R.id.frame_seedoctor, seeDoctorFragment);
        mTransaction.commit();
    }
}