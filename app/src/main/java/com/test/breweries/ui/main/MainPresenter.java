package com.test.breweries.ui.main;

import com.test.breweries.base.BasePresenter;
import com.test.breweries.dao.BreweryDao;
import com.test.breweries.http.BreweryApi;
import com.test.breweries.model.Brewery;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainView>
{
    private MainActivity mainActivity;

    @Inject
    BreweryApi breweryApi;

    @Inject
    BreweryDao breweryDao;


    @Inject
    public MainPresenter() {
    }

    public void setView(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void showAllBreweries() {
        compositeDisposables.add(
                breweryApi.getBreweryList()
                        .subscribeOn(Schedulers.io())
                        .doOnSuccess(breweries -> breweryDao.insert(breweries))
                        .onErrorReturn(throwable -> breweryDao.getAll())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(mainActivity::showData, mainActivity::showError)
        );
    }

    public void searchBrewery(String nameBrewery) {
        compositeDisposables.add(breweryApi.searchBreweryByName(nameBrewery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .switchMap(brewery -> null)
                .subscribe());
    }
}
