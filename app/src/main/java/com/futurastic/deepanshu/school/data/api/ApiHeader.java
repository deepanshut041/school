package com.futurastic.deepanshu.school.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

/**
 * Created by deepanshu on 17/3/18.
 */

public class ApiHeader {

    @Expose
    @SerializedName("api_key")
    private String mApiKey;

    @Expose
    @SerializedName("user_id")
    private Long mUserId;

    @Expose
    @SerializedName("access_token")
    private String mAccessToken;

    @Inject
    public ApiHeader(String apiKey, DbHelper dbHelper, PreferencesHelper preferencesHelper) {
        mApiKey = apiKey;
        mAccessToken = preferencesHelper.getAccessToken();
    }


    public String getApiKey() {
        return mApiKey;
    }

    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }
}
