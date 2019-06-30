package com.example.dell.xiaoshixuncaseone.model;

import com.example.dell.xiaoshixuncaseone.api.WanService;
import com.example.dell.xiaoshixuncaseone.bean.MaBean;
import com.example.dell.xiaoshixuncaseone.callback.MaCallback;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MaModelimpel implements MaModel {


    @Override
    public void MaData(final MaCallback maCallback) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        final Request request = new Request.Builder()
                .url("http://172.16.56.56:8080/jiexi/first_page.json")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                MaBean maBean = new GsonBuilder().serializeNulls().create().fromJson(string, MaBean.class);
                maCallback.Sueecss(maBean);
            }
        });

    }
}
