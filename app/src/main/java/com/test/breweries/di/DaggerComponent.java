package com.test.breweries.di;


import com.test.breweries.di.module.AppModule;
import com.test.breweries.di.module.DbModule;
import com.test.breweries.di.module.NetworkModule;
import com.test.breweries.ui.main.MainActivity;
import com.test.breweries.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {
        AppModule.class,
        DbModule.class,
        NetworkModule.class
})
public interface DaggerComponent
{
    //void inject(MainPresenter mainPresenter);

    void inject(MainActivity mainActivity);
}
