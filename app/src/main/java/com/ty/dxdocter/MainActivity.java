package com.ty.dxdocter;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.ty.dxdocter.arouter.MianRouter;
import com.ty.dxdocter.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private FragmentManager mFragmentManager;
    private BottomNavigationView mBottomNavigationView;
    private List<Fragment> fragmentList = new ArrayList<>();
    private ConstraintLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        setContentView(R.layout.activity_main);

        initView();
    }

    //初始化底部导航栏
    public void initView(){
        mBottomNavigationView = findViewById(R.id.nav_view);
        mFragmentManager = getSupportFragmentManager();
        mainLayout = findViewById(R.id.main_layout);
        getWindow().setNavigationBarColor(Color.WHITE);
        mainLayout.setPadding(0,QMUIStatusBarHelper.getStatusbarHeight(this),0,0);
        initFragment();
        mBottomNavigationView.setOnNavigationItemSelectedListener(NavigationItemSelectedListener);
        //设置默认选中item
        mBottomNavigationView.getMenu().getItem(0).setChecked(true);
        showFragment(0);
    }

    //初始化fragmentList
    public void initFragment(){
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(MianRouter.HOME_ROUTER).navigation();
        Fragment fragment = (Fragment) ARouter.getInstance().build(MianRouter.CONSULTATION_ROUTER).navigation();
        Fragment mineFragment = (Fragment) ARouter.getInstance().build(MianRouter.MINE_ROUTER).navigation();
        fragmentList.add(homeFragment);
        fragmentList.add(fragment);
        fragmentList.add(mineFragment);
        mFragmentManager.beginTransaction().add(R.id.container,fragmentList.get(0)).commit();
        mFragmentManager.beginTransaction().add(R.id.container,fragmentList.get(1)).commit();
        mFragmentManager.beginTransaction().add(R.id.container,fragmentList.get(2)).commit();
    }

    //底部导航item监听器
    private BottomNavigationView.OnNavigationItemSelectedListener NavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(0);
                    break;
                case R.id.navigation_consultation:
                    showFragment(1);
                    break;
                case R.id.navigation_mine:
                    showFragment(2);
                    break;
            }
            return  true;
        }
    };

    public void showFragment(int index){
        int size = fragmentList.size();
        for (int i=0;i<size;i++){
            if (index==i){
                mFragmentManager.beginTransaction().show(fragmentList.get(i)).commit();
            }else {
                mFragmentManager.beginTransaction().hide(fragmentList.get(i)).commit();
            }
        }
    }




}