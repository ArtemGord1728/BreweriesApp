package com.test.breweries.repo;


import com.test.breweries.http.BreweryApi;

import javax.inject.Inject;


/**
 * Provide methods that use the DAO to insert, delete and query product records
 */

public class BreweryRepo {
    BreweryApi breweryApi;

    @Inject
    BreweryRepo(BreweryApi breweryApi)
    {
        this.breweryApi = breweryApi;
    }
}
