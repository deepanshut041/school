package com.futurastic.deepanshu.school;

import android.app.Application;
import android.content.Context;

import com.futurastic.deepanshu.school.di.component.ApplicationComponent;
import com.futurastic.deepanshu.school.di.module.ApplicationModule;

/**
 * Created by deepanshu on 17/3/18.
 */

public class SchoolApp extends Application{

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    public static SchoolApp get(Context context) {
        return (SchoolApp) context.getApplicationContext();
    }

    private void initializeApplicationComponent(){
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
