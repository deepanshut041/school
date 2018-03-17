package com.futurastic.deepanshu.school.utils;

/**
 * Created by deepanshu on 17/3/18.
 */

public final class AppConstants {
    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_OK = 200;
    public static final int API_STATUS_CODE_BAD_REQUEST = 403;
    public static final int API_STATUS_CODE_NOT_FOUND = 404;
    public static final int API_STATUS_CODE_INTERNAL_SERVER_ERROR = 500;

    public static final String DB_NAME = "school.db";
    public static final String PREF_NAME = "school_pref";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
