package com.test.breweries;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.room.Room;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.test.breweries.common.AppConstants;
import com.test.breweries.dao.DataBase;
import com.test.breweries.di.DaggerComponent;
import com.test.breweries.di.DaggerDaggerComponent;
import com.test.breweries.di.module.AppModule;
import com.test.breweries.di.module.DbModule;
import com.test.breweries.di.module.NetworkModule;


public class App extends Application
{
    private static DaggerComponent mDaggerComponent;
    private static DataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidThreeTen.init(this);

        mDaggerComponent = DaggerDaggerComponent.builder()
                .appModule(new AppModule(this))
                .dbModule(new DbModule())
                .networkModule(new NetworkModule())
                .build();

        dataBase = Room.databaseBuilder(getApplicationContext(),
                DataBase.class, AppConstants.DATABASE_NAME)
                .fallbackToDestructiveMigrationFrom()
                .build();
    }

    @Override
    protected void attachBaseContext (Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static DataBase getDataBase() {
        return dataBase;
    }

    public static DaggerComponent getDaggerComponent() {
        return mDaggerComponent;
    }
}
