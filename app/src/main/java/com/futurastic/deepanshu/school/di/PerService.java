package com.futurastic.deepanshu.school.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by deepanshu on 17/3/18.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}
