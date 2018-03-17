package com.futurastic.deepanshu.school.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by deepanshu on 17/3/18.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    boolean isNetworkConnected();

    void hideKeyboard();

}
