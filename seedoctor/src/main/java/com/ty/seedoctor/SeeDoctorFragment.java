package com.ty.seedoctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.ty.seedoctor.adapter.AnserAdapter;
import com.ty.seedoctor.adapter.DepartmentAdapter;
import com.ty.seedoctor.bean.AnswerItme;
import com.ty.seedoctor.bean.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 檀煜
 */
@Route(path = "/doctor/fragment")
public class SeeDoctorFragment extends Fragment implements DoctorContract.DoctorView {

    private View docView;

    private QMUIGroupListView doctorGruopListview;
    private QMUIGroupListView answerGroup;
    private GridView deptPartGride;
    private DoctorPresenter doctorPresenter;
    private static String TAG = "DoctorFragment";

    private RecyclerView answerRecycleview;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seedoctor, container, false);
        this.docView = view;
        initView();
        return view;
    }

    public void initView(){
        doctorGruopListview = docView.findViewById(R.id.doc_group);
        deptPartGride = docView.findViewById(R.id.department_gridview);
        answerRecycleview = docView.findViewById(R.id.answer_recycleview);
        answerGroup = docView.findViewById(R.id.answer_group);
        doctorPresenter = new DoctorPresenter(this);
        doctorPresenter.initView(getActivity(),TAG);
        initMore();
        initMenuDepartMent();
    }

    public void initMore(){
        QMUICommonListItemView itemWithChevron = doctorGruopListview.createItemView(getString(R.string.departments));
        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron.setDetailText(getString(R.string.more));
        doctorGruopListview.addView(itemWithChevron);

        QMUICommonListItemView itemWithCustom = answerGroup.createItemView("最新问答");
        itemWithCustom.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CUSTOM);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.ic_baseline_cached_24);
        itemWithCustom.addAccessoryCustomView(imageView);
        itemWithCustom.setDetailText("换一批");
        answerGroup.addView(itemWithCustom);
    }

    private void initMenuDepartMent(){
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department(R.drawable.menu1,"皮肤性病科"));
        departmentList.add(new Department(R.drawable.menu2,"儿科"));
        departmentList.add(new Department(R.drawable.menu3,"妇产科"));
        departmentList.add(new Department(R.drawable.menu4,"泌尿外科"));
        departmentList.add(new Department(R.drawable.menu5,"骨科"));
        departmentList.add(new Department(R.drawable.menu6,"内分泌科"));
        departmentList.add(new Department(R.drawable.menu7,"心血管内科"));
        departmentList.add(new Department(R.drawable.menu8,"神经科"));

        DepartmentAdapter adapter = new DepartmentAdapter(departmentList);
        deptPartGride.setAdapter(adapter);
    }

    @Override
    public void newsAnserSuccess(List<AnswerItme> answerItmeList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        answerRecycleview.setLayoutManager(linearLayoutManager);
        answerRecycleview.addItemDecoration(new DividerItemDecoration(getContext(),1));
        AnserAdapter anserAdapter = new AnserAdapter(answerItmeList);
        answerRecycleview.setAdapter(anserAdapter);
    }
}