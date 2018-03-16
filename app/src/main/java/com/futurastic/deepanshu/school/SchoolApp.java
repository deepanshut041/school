package com.futurastic.deepanshu.school;

import android.app.Application;

/**
 * Created by deepanshu on 17/3/18.
 */

public class SchoolApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent(){
        DaggerApplicationComponent.builder().create();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
