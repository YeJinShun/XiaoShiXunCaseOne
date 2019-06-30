package com.example.dell.xiaoshixuncaseone.api;

import com.example.dell.xiaoshixuncaseone.bean.MaBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WanService {

    //http://172.16.56.56:8080/jiexi/first_page.json
    String MaUrl = "http://172.16.56.56:8080/jiexi/";
    @GET("first_page.json")
    Call<RequestBody> MaData();

}
