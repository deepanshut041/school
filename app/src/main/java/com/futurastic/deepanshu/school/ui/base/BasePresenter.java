package com.futurastic.deepanshu.school.ui.base;

import com.futurastic.deepanshu.school.R;
import com.futurastic.deepanshu.school.utils.AppConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;

/**
 * Created by deepanshu on 17/3/18.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final DataManager dataManager;

    private V mMvpView;

    @Inject
    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    @Override
    public void handleApiError(ApiError error) {

        final GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        ApiError apiError;
        try {
            if (error == null || error.getMessage() == null) {
                getMvpView().onError(R.string.api_default_error);
                return;
            }
            switch (error.getErrorCode()) {
                case AppConstants.API_STATUS_CODE_BAD_REQUEST:
                    setUserAsLoggedOut();
                    getMvpView().openActivityOnTokenExpire();
                case AppConstants.API_STATUS_CODE_INTERNAL_SERVER_ERROR:
                case AppConstants.API_STATUS_CODE_NOT_FOUND:
                default:
                    getMvpView().onError(error.getMessage());
            }
        } catch (JsonSyntaxException | NullPointerException e) {
            e.printStackTrace();
            getMvpView().onError(R.string.api_default_error);
        }
    }

    @Override
    public void setUserAsLoggedOut() {
        getDataManager().setAccessToken(null);
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
