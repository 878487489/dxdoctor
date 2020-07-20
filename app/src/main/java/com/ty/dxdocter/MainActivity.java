package com.ty.dxdocter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ty.dxdocter.arouter.MianRouter;
import com.ty.dxdocter.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private FragmentManager mFragmentManager;
    private BottomNavigationView mBottomNavigationView;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化底部导航栏
    public void initView(){
        mBottomNavigationView = findViewById(R.id.nav_view);
        mFragmentManager = getSupportFragmentManager();
        initFragment();
        mBottomNavigationView.setOnNavigationItemSelectedListener(NavigationItemSelectedListener);
        //设置默认选中item
        mBottomNavigationView.getMenu().getItem(0).setChecked(true);
        mFragmentManager.beginTransaction().replace(R.id.container, fragmentList.get(0)).commit();
    }

    //初始化fragmentList
    public void initFragment(){
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(MianRouter.HOME_ROUTER).navigation();
        Fragment fragment = (Fragment) ARouter.getInstance().build(MianRouter.CONSULTATION_ROUTER).navigation();
        Fragment mineFragment = (Fragment) ARouter.getInstance().build(MianRouter.MINE_ROUTER).navigation();
        fragmentList.add(homeFragment);
        fragmentList.add(fragment);
        fragmentList.add(mineFragment);
    }

    //底部导航item监听器
    private BottomNavigationView.OnNavigationItemSelectedListener NavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mFragmentManager.beginTransaction().replace(R.id.container, fragmentList.get(0)).commit();
                    break;
                case R.id.navigation_consultation:
                    mFragmentManager.beginTransaction().replace(R.id.container, fragmentList.get(1)).commit();
                    break;
                case R.id.navigation_mine:
                    mFragmentManager.beginTransaction().replace(R.id.container, fragmentList.get(2)).commit();
                    break;
            }
            return  true;
        }
    };




}