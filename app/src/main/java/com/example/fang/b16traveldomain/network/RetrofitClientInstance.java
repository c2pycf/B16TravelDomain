package com.example.fang.b16traveldomain.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit mRetrofit;
    private static final String BASE_URL = "http://rjtmobile.com/aamir/otr/android-app/";


    public static Retrofit getInstance(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
