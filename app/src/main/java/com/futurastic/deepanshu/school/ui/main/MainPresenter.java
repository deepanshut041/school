package com.futurastic.deepanshu.school.ui.main;

import com.futurastic.deepanshu.school.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by deepanshu on 17/3/18.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    private static final String TAG = MainPresenter.class.getSimpleName();

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onDrawerOptionSettingsClick() {
        getMvpView().showSettingFragment();
    }

    @Override
    public void onDrawerOptionLogoutClick() {
    }

    @Override
    public String getUser() {
        return null;
    }
}
