package com.futurastic.deepanshu.school.di.component;

import com.futurastic.deepanshu.school.di.PerActivity;
import com.futurastic.deepanshu.school.di.module.ActivityModule;
import com.futurastic.deepanshu.school.ui.login.LoginActivity;
import com.futurastic.deepanshu.school.ui.main.MainActivity;
import com.futurastic.deepanshu.school.ui.setting.SettingFragment;
import com.futurastic.deepanshu.school.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by deepanshu on 17/3/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(SettingFragment fragment);
}
