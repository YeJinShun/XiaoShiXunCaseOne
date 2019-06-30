package com.example.dell.xiaoshixuncaseone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.xiaoshixuncaseone.adapter.TwoTAdapter;
import com.example.dell.xiaoshixuncaseone.bean.Bean;
import com.example.dell.xiaoshixuncaseone.bean.TwoBeam;
import com.example.dell.xiaoshixuncaseone.utils.Utils;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TwoActivity extends AppCompatActivity {
    private int index;
    private RecyclerView TwoTRv;
    private ArrayList<TwoBeam.ResultBean.DataBean> list;
    private TwoTAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TwoTRv = (RecyclerView) findViewById(R.id.TwoTRv);
        TwoTRv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new TwoTAdapter(list, this);
        TwoTRv.setAdapter(adapter);
        adapter.setClick(new TwoTAdapter.Click() {


            @Override
            public void click(int i) {
                index = i;
                startActivity(new Intent(TwoActivity.this,ThreeActivity.class));
            }
        });
        initDa();
        initData();
    }

    private void initDa() {
        View view = LayoutInflater.from(this).inflate(R.layout.tow_titem, null);
        Button btn = view.findViewById(R.id.two_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwoBeam.ResultBean.DataBean be = list.get(index);
                Bean bean = new Bean();
                bean.setImg(be.getUrl());
                bean.setName(be.getUpdatetime());
                bean.setTitle(be.getContent());
                long insert = Utils.getUtils().insert(bean);
                if (insert>=0){
                    Toast.makeText(TwoActivity.this, "储存成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(TwoActivity.this, "储存失败", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url("http://172.16.56.56:8080/jiexi/second_page.json")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final TwoBeam twoBeam = new GsonBuilder().serializeNulls().create().fromJson(string, TwoBeam.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<TwoBeam.ResultBean.DataBean> data = twoBeam.getResult().getData();
                        list.addAll(data);
                        adapter.notifyDataSetChanged();
                    }
                });

            }
        });

    }
}
