package com.test.breweries.di.module;

import android.app.Application;

import androidx.room.Room;

import com.test.breweries.common.AppConstants;
import com.test.breweries.dao.BreweryDao;
import com.test.breweries.dao.DataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DbModule
{
    @Singleton
    @Provides
    static DataBase provideDataBase(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(),
                DataBase.class,
                AppConstants.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    static BreweryDao provideBreweryDao(DataBase db) {
        return db.breweryDao();
    }
}
