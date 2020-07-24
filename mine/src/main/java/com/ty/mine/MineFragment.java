package com.ty.mine;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.lang.reflect.Field;

/**
 * @author 檀煜
 */
@Route(path = "/mine/fragment")
public class MineFragment extends Fragment {

    private QMUITopBarLayout toolbar;
    private View mineView;

    private QMUIGroupListView mGroupListView;
    private QMUIGroupListView section1GroupListView;
    private QMUIGroupListView section2GroupListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mineView = inflater.inflate(R.layout.fragment_mine, container, false);
        initView();
        init();
        return mineView;
    }

    public void initView(){
        toolbar = mineView.findViewById(R.id.toolbar);
        mGroupListView = mineView.findViewById(R.id.mine_group);
        section1GroupListView = mineView.findViewById(R.id.mine_section1);
        section2GroupListView = mineView.findViewById(R.id.mine_section2);
    }

    public void init(){
        initBar();
        initList();
    }

    public void initBar(){
        toolbar.setTitle("我的");
        toolbar.setBackgroundColor(Color.WHITE);
        toolbar.addRightImageButton(R.drawable.ic_notifications_24,0);
    }

    public void initList(){
        int size = QMUIDisplayHelper.dp2px(getContext(), 20);
        QMUIGroupListView.newSection(getContext())
                .setLeftIconSize(size, ViewGroup.LayoutParams.WRAP_CONTENT)
                .addItemView(createItem(R.drawable.mine7,"我的问诊"), null)
                .addItemView(createItem(R.drawable.mine4,"购买的讲堂"), null)
                .addItemView(createItem(R.drawable.mine6,"购买的药品"), null)
                .setMiddleSeparatorInset(QMUIDisplayHelper.dp2px(getContext(), 16), 0)
                .addTo(mGroupListView);

        QMUIGroupListView.newSection(getContext())
                .setLeftIconSize(size, ViewGroup.LayoutParams.WRAP_CONTENT)
                .addItemView(createItem(R.drawable.mine9,"工具箱"), null)
                .addItemView(createItem(R.drawable.mine5,"我的优惠"), null)
                .setMiddleSeparatorInset(QMUIDisplayHelper.dp2px(getContext(), 16), 0)
                .addTo(section1GroupListView);

        QMUIGroupListView.newSection(getContext())
                .setLeftIconSize(size, ViewGroup.LayoutParams.WRAP_CONTENT)
                .addItemView(createItem(R.drawable.mine3,"家庭成员"), null)
                .addItemView(createItem(R.drawable.mine2,"关注的医生"), null)
                .addItemView(createItem(R.drawable.mine1,"家庭成员"), null)
                .addItemView(createItem(R.drawable.mine8,"用户反馈"), null)
                .setMiddleSeparatorInset(QMUIDisplayHelper.dp2px(getContext(), 16), 0)
                .addTo(section1GroupListView);


    }

    public QMUICommonListItemView createItem(int img,String titleName){
        QMUICommonListItemView itemWithChevron = mGroupListView.createItemView(titleName);
        itemWithChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), img));
        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        return itemWithChevron;
    }

    public int  getResource(String imageName){
        Class mipmap = R.drawable.class;
        try {
            Field field = mipmap.getField(imageName);
            int resId = field.getInt(imageName);
            return resId;
        } catch (NoSuchFieldException e) {
            return 0;
        } catch (IllegalAccessException e) {
            return 0;
        }

    }


}