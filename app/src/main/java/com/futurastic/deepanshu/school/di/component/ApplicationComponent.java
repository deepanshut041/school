package com.futurastic.deepanshu.school.di.component;

import com.futurastic.deepanshu.school.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by deepanshu on 17/3/18.
 */


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {


}
