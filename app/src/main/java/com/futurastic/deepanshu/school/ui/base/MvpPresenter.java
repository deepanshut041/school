package com.futurastic.deepanshu.school.ui.base;

import com.futurastic.deepanshu.school.data.api.models.ApiError;

/**
 * Created by deepanshu on 17/3/18.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ApiError error);

    void setUserAsLoggedOut();
}