package com.futurastic.deepanshu.school.ui.splash;

import com.futurastic.deepanshu.school.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by deepanshu on 17/3/18.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

}
