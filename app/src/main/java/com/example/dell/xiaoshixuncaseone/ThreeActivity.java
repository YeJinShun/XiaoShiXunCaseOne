package com.example.dell.xiaoshixuncaseone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.xiaoshixuncaseone.adapter.ThreetAdapter;
import com.example.dell.xiaoshixuncaseone.bean.Bean;
import com.example.dell.xiaoshixuncaseone.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ThreeActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Bean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        rv = (RecyclerView) findViewById(R.id.threet_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ThreetAdapter adapter = new ThreetAdapter(list, this);
        rv.setAdapter(adapter);
        List<Bean> query = Utils.getUtils().query();
        list.addAll(query);
        adapter.notifyDataSetChanged();

    }
}
