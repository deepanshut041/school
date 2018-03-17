package com.futurastic.deepanshu.school.di.component;

import com.futurastic.deepanshu.school.di.PerService;

import dagger.Component;

/**
 * Created by deepanshu on 17/3/18.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

//    void inject(GoogleLocationService googleLocationService);

}
