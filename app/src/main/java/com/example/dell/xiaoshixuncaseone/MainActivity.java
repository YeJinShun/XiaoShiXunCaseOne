package com.example.dell.xiaoshixuncaseone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.xiaoshixuncaseone.adapter.OneAdapter;
import com.example.dell.xiaoshixuncaseone.adapter.ThreeAdapter;
import com.example.dell.xiaoshixuncaseone.adapter.TwoAdapter;
import com.example.dell.xiaoshixuncaseone.bean.MaBean;
import com.example.dell.xiaoshixuncaseone.model.MaModelimpel;
import com.example.dell.xiaoshixuncaseone.presenter.MaPresenterimpel;
import com.example.dell.xiaoshixuncaseone.view.MaView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MaView {

    private RecyclerView ontRv;
    private RecyclerView twoRv;
    private RecyclerView threeRv;
    private ArrayList<MaBean.ResultBean.DataBean> list;
    private OneAdapter adapter;
    private TwoAdapter twoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaPresenterimpel presenterimpel = new MaPresenterimpel(new MaModelimpel(), this);
        presenterimpel.MaData();
        ontRv = (RecyclerView) findViewById(R.id.ont_rv);
        twoRv = (RecyclerView) findViewById(R.id.two_rv);
        threeRv = (RecyclerView) findViewById(R.id.three_rv);
        list = new ArrayList<>();
        initOne();
        initTwo();
        initThree();
    }

    private void initThree() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        threeRv.setLayoutManager(layoutManager);
        ThreeAdapter threeAdapter = new ThreeAdapter(list, this);
        threeAdapter.setClick(new ThreeAdapter.Click() {
            @Override
            public void click(int i) {
                startActivity(new Intent(MainActivity.this,TwoActivity.class));
            }
        });
        threeRv.setAdapter(twoAdapter);
    }

    private void initTwo() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        twoRv.setLayoutManager(layoutManager);
        twoAdapter = new TwoAdapter(list, this);
        twoAdapter.setClick(new TwoAdapter.Click() {
            @Override
            public void click(int i) {
                startActivity(new Intent(MainActivity.this,TwoActivity.class));
            }
        });
        twoRv.setAdapter(twoAdapter);

    }

    private void initOne() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.canScrollVertically();
        manager.setReverseLayout(true);
        ontRv.setLayoutManager(manager);
        adapter = new OneAdapter(list, this);
       adapter.setClick(new OneAdapter.Click() {
           @Override
           public void click(int i) {
               startActivity(new Intent(MainActivity.this,TwoActivity.class));
           }
       });
        ontRv.setAdapter(adapter);
    }

    @Override
    public void Sueecss(MaBean maBean) {
        List<MaBean.ResultBean.DataBean> data = maBean.getResult().getData();
        list.addAll(data);

    }

    @Override
    public void Fail(String s) {

    }
}
