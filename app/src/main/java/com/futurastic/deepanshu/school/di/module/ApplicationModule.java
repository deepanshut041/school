package com.futurastic.deepanshu.school.di.module;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Provides;
import io.reactivex.plugins.RxJavaPlugins;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by deepanshu on 17/3/18.
 */

public class ApplicationModule {

    private String mBaseUrl;

    public ApplicationModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory(){
        GsonConverterFactory factory = GsonConverterFactory.create();
        return factory;
    }

    @Singleton
    @Provides
    @Named("ok-1")
    OkHttpClient provideOkHttpClient1() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    @Named("ok-2")
    OkHttpClient provideOkHttpClient2() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory, RxJavaCallAdapterFactory adapterFactory){
        GsonConverterFactory factory = GsonConverterFactory.create();
        RxJavaCallAdapterFactory factory1 = RxJavaCallAdapterFactory.create();
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)
                .build();
    }
}
