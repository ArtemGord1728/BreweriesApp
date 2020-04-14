package com.test.breweries.base

import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update


interface BaseDao<T>
{
    @Insert(onConflict = IGNORE)
    fun insert(items : List<T>) : LongArray

    @Update(onConflict = REPLACE)
    fun update(items : List<T>)

    fun deleteAll() : Int

    fun getAll() : List<T>
}