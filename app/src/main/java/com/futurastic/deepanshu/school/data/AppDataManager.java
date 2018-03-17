package com.futurastic.deepanshu.school.data;

import io.reactivex.Observable;

/**
 * Created by deepanshu on 17/3/18.
 */

public class AppDataManager implements DataManager {

    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    public AppDataManager(DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public void setApiHeader(ApiHeader apiHeader) {
        mApiHelper.setApiHeader(apiHeader);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().setAccessToken(accessToken);
    }

    @Override
    public Observable<Long> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }
}
