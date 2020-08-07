package com.ty.find.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.ty.common.BaseActivity;
import com.ty.find.R;

/**
 * @author 檀煜
 * 快速提问Activity 界面
 */
@Route(path = "/find/QuickQuestionActivity")
public class QuickQuestionActivity extends BaseActivity {

    private QMUITopBarLayout quickQusetionTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_question);
        initView();
    }

    private void initView(){
        quickQusetionTopBar = findViewById(R.id.quick_question_topbar);
        initBar();
    }

    private void initBar(){
        quickQusetionTopBar.setTitle(getString(R.string.quick_question_title));
        quickQusetionTopBar.addLeftTextButton(R.string.cancel,0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        quickQusetionTopBar.addRightTextButton(R.string.define,1);
    }
}