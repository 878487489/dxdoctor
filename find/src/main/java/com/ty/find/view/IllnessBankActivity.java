package com.ty.find.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.ty.common.BaseActivity;
import com.ty.find.R;
import com.ty.find.adapter.DrugsItemAdapter;
import com.ty.find.adapter.ItemAdapter;
import com.ty.find.bean.DrugsTtem;
import com.ty.find.widget.ItemGradview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Route(path = "/find/IllnessBankActivity")
public class IllnessBankActivity extends BaseActivity {

    private static String TAG = "IllnessBankActivity";
    private QMUITopBarLayout illnessTabar;
    private ItemGradview illnessGradview;
    private ItemGradview illnessCommon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illness_bank);
        initView();
    }

    private void initView(){
        illnessTabar = findViewById(R.id.illness_bank_tobar);
        illnessGradview = findViewById(R.id.illness_bank_gradview);
        illnessCommon = findViewById(R.id.illness_bank_common);
        initBar();
        initItem();
        initCommon();
    }

    private void initBar(){
        illnessTabar.setTitle(getString(R.string.illness_bank_title));
        illnessTabar.addLeftImageButton(R.drawable.ic_back_24,0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        illnessTabar.addRightImageButton(R.drawable.ic_scanle,1);
    }

    private void initItem(){
        List<DrugsTtem> drugsTtemList = new ArrayList<>();
        drugsTtemList.add(new DrugsTtem(R.drawable.drugs_item1,"儿科疾病","黄疸、贫血、哮喘"));
        drugsTtemList.add(new DrugsTtem(R.drawable.drugs_item2,"男性常见","早泄、前列腺炎、阳痿"));
        drugsTtemList.add(new DrugsTtem(R.drawable.drugs_item3,"女性常见","痛经、阴道炎、孕吐"));
        drugsTtemList.add(new DrugsTtem(R.drawable.drugs_item4,"老年疾病","中风、高血压、糖尿病"));
        DrugsItemAdapter adapter = new DrugsItemAdapter(drugsTtemList);
        illnessGradview.setAdapter(adapter);
    }

    private void initCommon(){
        String[] itemTitle = {"早泄","咳嗽","湿疹","鼻炎","口腔溃疡","高血压","糖尿病","痔疮","荨麻疹","脱发","阴道炎","前列腺炎"};
        ItemAdapter adapter = new ItemAdapter(Arrays.asList(itemTitle));
        illnessCommon.setAdapter(adapter);
    }
}