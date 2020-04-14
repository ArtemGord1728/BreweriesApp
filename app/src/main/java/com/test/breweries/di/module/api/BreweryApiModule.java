package com.test.breweries.di.module.api;

import com.google.gson.Gson;
import com.test.breweries.http.BreweryApi;
import com.test.breweries.util.SetupUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class BreweryApiModule
{
    @Provides
    @Singleton
    BreweryApi provideBreweryApi(String apiAddress) {
        return SetupUtil.setupRetrofit(apiAddress)
                .create(BreweryApi.class);
    }
}
