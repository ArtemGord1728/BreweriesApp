package com.test.breweries.base;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends BaseView>
{
    protected CompositeDisposable compositeDisposables = new CompositeDisposable();
    private V view;

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public void disposeAll() {
        if(compositeDisposables != null) {
            compositeDisposables.clear();
        }
    }
}
