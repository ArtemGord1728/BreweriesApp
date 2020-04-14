package com.test.breweries.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.test.breweries.common.AppConstants;
import com.test.breweries.model.Brewery;


@Database(entities = {Brewery.class},
        version = AppConstants.ROOM_VERSION)

//@TypeConverters(value = {
//        JsonConverter.class})
public abstract class DataBase extends RoomDatabase
{
    public abstract BreweryDao breweryDao();
}
