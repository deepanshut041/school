package com.futurastic.deepanshu.school.ui.base;

/**
 * Created by deepanshu on 17/3/18.
 */

public interface SubMvpView extends MvpView {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentMvpView(MvpView mvpView);
}
