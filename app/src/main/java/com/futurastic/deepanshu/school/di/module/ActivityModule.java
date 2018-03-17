package com.futurastic.deepanshu.school.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;

import com.futurastic.deepanshu.school.di.ActivityContext;
import com.futurastic.deepanshu.school.di.PerActivity;
import com.futurastic.deepanshu.school.ui.login.LoginMvpPresenter;
import com.futurastic.deepanshu.school.ui.login.LoginMvpView;
import com.futurastic.deepanshu.school.ui.login.LoginPresenter;
import com.futurastic.deepanshu.school.ui.main.MainMvpPresenter;
import com.futurastic.deepanshu.school.ui.main.MainMvpView;
import com.futurastic.deepanshu.school.ui.main.MainPresenter;
import com.futurastic.deepanshu.school.ui.setting.SettingMvpPresenter;
import com.futurastic.deepanshu.school.ui.setting.SettingMvpView;
import com.futurastic.deepanshu.school.ui.setting.SettingPresenter;
import com.futurastic.deepanshu.school.ui.splash.SplashMvpPresenter;
import com.futurastic.deepanshu.school.ui.splash.SplashMvpView;
import com.futurastic.deepanshu.school.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by deepanshu on 17/3/18.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(activity);
    }

    @Provides
    LinearLayoutManager provideLayoutManager() {
        return new LinearLayoutManager(activity);
    }

    /**
     * We are providing the SplashMvpPresenter by constructing it, because we want the Dependency
     * graph to provide the interfaces for these classes for loose binding to its implementation.
     */
    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(DataManager dataManager) {
        return new SplashPresenter<>(dataManager);
    }

    @Provides
    @PerActivity
    SettingMvpPresenter<SettingMvpView> provideSettingPresenter(DataManager dataManager) {
        return new SettingPresenter<>(dataManager);
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(DataManager dataManager) {
        return new LoginPresenter<>(dataManager);
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(DataManager dataManager) {
        return new MainPresenter<>(dataManager);
    }
}



