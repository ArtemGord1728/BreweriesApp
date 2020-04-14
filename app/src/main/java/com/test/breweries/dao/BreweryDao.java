package com.test.breweries.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.test.breweries.base.BaseDao;
import com.test.breweries.model.Brewery;

import org.jetbrains.annotations.NotNull;

import java.util.List;


@Dao
public abstract class BreweryDao
        implements BaseDao<Brewery>
{
    @Override
    @Query("DELETE FROM brewery_table;")
    public abstract int deleteAll ();



    @NotNull
    @Override
    @Query("SELECT * FROM brewery_table;")
    public abstract List<Brewery> getAll();


    @Transaction
    public void update (@NotNull List<? extends Brewery> breweryList) {
        deleteAll();
        insert(breweryList);
    }
}
