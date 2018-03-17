package com.futurastic.deepanshu.school.ui.login;

import com.futurastic.deepanshu.school.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by deepanshu on 17/3/18.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

}