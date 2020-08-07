package com.ty.home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.ty.common.BaseActivity;
import com.ty.home.R;
import com.ty.home.adapter.FormAdapter;
import com.ty.home.bean.FormListBean;
import com.ty.home.contract.ForumListContract;
import com.ty.home.presenter.ForumListPresenter;

import java.util.List;

/**
 * @author 檀煜
 * 医生讲堂列表
 */
@Route(path = "/more/ForumListActivity")
public class ForumListActivity extends BaseActivity implements ForumListContract.ForumListView {

    private static String TAG = "ForumListActivity";
    private QMUITopBarLayout forumListTopBar;
    private RecyclerView formMoreListRe;
    private ForumListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_list);
        initView();
    }

    private void initView(){
        forumListTopBar = findViewById(R.id.forum_list_topbar);
        formMoreListRe = findViewById(R.id.form_more_list);
        formMoreListRe.addItemDecoration(new DividerItemDecoration(this,1));
        formMoreListRe.setLayoutManager(new LinearLayoutManager(this));
        presenter  = new ForumListPresenter(this);
        presenter.init(this,TAG);
        initBar();
    }

    private void initBar(){
        forumListTopBar.setTitle(getString(R.string.forum_list_title));
        forumListTopBar.addLeftImageButton(R.drawable.ic_back_24,0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void backFormList(List<FormListBean> formListBeanList) {
        FormAdapter adapter = new FormAdapter(formListBeanList);
        formMoreListRe.setAdapter(adapter);
    }

}