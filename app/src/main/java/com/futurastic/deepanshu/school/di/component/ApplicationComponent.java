package com.futurastic.deepanshu.school.di.component;

import android.app.Application;
import android.content.Context;

import com.futurastic.deepanshu.school.SchoolApp;
import com.futurastic.deepanshu.school.data.DataManager;
import com.futurastic.deepanshu.school.di.ApplicationContext;
import com.futurastic.deepanshu.school.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by deepanshu on 17/3/18.
 */


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SchoolApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
