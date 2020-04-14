package com.test.breweries.ui.main;

import com.test.breweries.base.BaseView;
import com.test.breweries.model.Brewery;

import java.util.List;

public interface MainView extends BaseView
{
    void initView();
    void showLoading();
    void hideLoading();
    void showData(List<Brewery> breweries);
    void showError(Throwable throwable);
}
