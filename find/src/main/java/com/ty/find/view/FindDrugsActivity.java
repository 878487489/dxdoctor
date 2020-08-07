package com.ty.find.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

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

@Route(path = "/find/FindDrugsActivity")
public class FindDrugsActivity extends BaseActivity {

    private QMUITopBarLayout findDrgsBar;
    private ItemGradview drougsGradview;
    private ItemGradview drugsCommon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_drugs);
        initView();
    }

    private void initView(){
        findDrgsBar = findViewById(R.id.find_drugs_tobar);
        drougsGradview = findViewById(R.id.drougs_gradview);
        drugsCommon = findViewById(R.id.drugs_common);
        initBar();
        initItem();
        initCommon();
    }

    private void initBar(){
        findDrgsBar.setTitle("找药品");
        findDrgsBar.addLeftImageButton(R.drawable.ic_back_24,0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        findDrgsBar.addRightImageButton(R.drawable.ic_scanle,1);

    }

    private void initItem(){
        List<DrugsTtem> drugsTtemList = new ArrayList<>();
        drugsTtemList.add(new DrugsTtem(R.drawable.drugs_item1,"儿童安全用药","感冒、退热止痛、止咳"));
        drugsTtemList.add(new DrugsTtem(R.drawable.drugs_item2,"跌打损伤用药","伤口消毒、伤口抗感染"));
        drugsTtemList.add(new DrugsTtem(R.drawable.drugs_item3,"两性妇科用药","痛经、阳痿、避孕药"));
        drugsTtemList.add(new DrugsTtem(R.drawable.drugs_item4,"老人常用药","高血压、糖尿病"));
        DrugsItemAdapter adapter = new DrugsItemAdapter(drugsTtemList);
        drougsGradview.setAdapter(adapter);
    }

    private void initCommon(){
        String[] itemTitle = {"布洛芬","泰诺林","百服宁","必理通","芬必得","思密达","口服液盐","妈咪爱","新泰康克","溶菌酶含片","宜诺斯","开塞特"};
        ItemAdapter adapter = new ItemAdapter(Arrays.asList(itemTitle));
        drugsCommon.setAdapter(adapter);
    }
}