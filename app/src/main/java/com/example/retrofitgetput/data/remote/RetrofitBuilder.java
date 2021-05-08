package com.example.retrofitgetput.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static TestApi instance;

    private RetrofitBuilder(){}

    public static TestApi getInstance(){
        if(instance==null){
            instance=createRetrofit();
        }
        return instance;
    }

    private static TestApi createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://android-3-mocker.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TestApi.class);
    }
}
