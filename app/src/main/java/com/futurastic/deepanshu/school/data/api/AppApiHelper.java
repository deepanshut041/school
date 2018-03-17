package com.futurastic.deepanshu.school.data.api;

/**
 * Created by deepanshu on 17/3/18.
 */

public final class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public void setApiHeader(ApiHeader apiHeader) {
//        mApiHeader.copy(apiHeader);
    }

}
