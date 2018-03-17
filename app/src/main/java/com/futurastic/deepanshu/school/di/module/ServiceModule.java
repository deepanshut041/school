package com.futurastic.deepanshu.school.di.module;

import android.app.Service;

import dagger.Module;

/**
 * Created by deepanshu on 17/3/18.
 */

@Module
public class ServiceModule {

    private final Service service;

    public ServiceModule(Service service) {
        this.service = service;
    }

}
