package com.futurastic.deepanshu.school.ui.main;

import com.futurastic.deepanshu.school.di.PerActivity;
import com.futurastic.deepanshu.school.ui.base.MvpPresenter;

/**
 * Created by deepanshu on 17/3/18.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onDrawerOptionSettingsClick();

    void onDrawerOptionLogoutClick();

    String getUser();

}