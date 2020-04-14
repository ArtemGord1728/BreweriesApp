package com.test.breweries.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    private static RetrofitClient instance;
    private static Retrofit client;

    public static RetrofitClient getInstance() {
        if (instance == null)
        {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static Retrofit getRetrofit() {
        if(client == null)
        {
            client = new Retrofit.Builder()
                    .baseUrl("https://api.openbrewerydb.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return client;
    }
}
