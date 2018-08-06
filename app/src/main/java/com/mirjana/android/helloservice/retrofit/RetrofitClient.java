package com.mirjana.android.helloservice.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mirjana.android.helloservice.bean.Adresa;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://192.168.100.2:8082/";
    //private static final String BASE_URL = "http://192.168.209.1:8082/";
    private static RetrofitClient mInstance;
    private static Retrofit sRetrofit;

    private RetrofitClient(){
        sRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (mInstance == null)
            mInstance = new RetrofitClient();
        return mInstance;
    }

    public Api getApi(){
        return sRetrofit.create(Api.class);
    }

}
