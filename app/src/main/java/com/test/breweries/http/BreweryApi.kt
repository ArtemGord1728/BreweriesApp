package com.test.breweries.http

import com.test.breweries.model.Brewery
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface BreweryApi
{
    @GET("/breweries")
    fun getBreweryList() : Single<List<Brewery>>

    @GET("/search")
    fun searchBreweryByName(@Query("query") nameBrewery: String) : Flowable<Brewery>
}