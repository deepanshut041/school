package com.futurastic.deepanshu.school.di.module;

import android.app.Application;
import android.content.Context;

import com.futurastic.deepanshu.school.BuildConfig;
import com.futurastic.deepanshu.school.R;
import com.futurastic.deepanshu.school.data.AppDataManager;
import com.futurastic.deepanshu.school.data.DataManager;
import com.futurastic.deepanshu.school.data.api.ApiHeader;
import com.futurastic.deepanshu.school.data.api.ApiHelper;
import com.futurastic.deepanshu.school.data.api.AppApiHelper;
import com.futurastic.deepanshu.school.data.db.AppDbHelper;
import com.futurastic.deepanshu.school.data.db.DbHelper;
import com.futurastic.deepanshu.school.data.db.DbOpenHelper;
import com.futurastic.deepanshu.school.data.prefs.AppPreferencesHelper;
import com.futurastic.deepanshu.school.data.prefs.PreferencesHelper;
import com.futurastic.deepanshu.school.di.ApiInfo;
import com.futurastic.deepanshu.school.di.ApplicationContext;
import com.futurastic.deepanshu.school.di.DatabaseInfo;
import com.futurastic.deepanshu.school.di.PreferenceInfo;
import com.futurastic.deepanshu.school.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by deepanshu on 17/3/18.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    /**
     * We are providing the AppDataManager by constructing it, because we want the Dependency
     * graph to provide the interfaces for these classes for loose binding to its implementation.
     */
    @Provides
    @Singleton
    DataManager provideDataManager(DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        return new AppDataManager(dbHelper, preferencesHelper, apiHelper);
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbOpenHelper dbOpenHelper) {
        return new AppDbHelper(dbOpenHelper);
    }

    @Provides
    @Singleton
    DbOpenHelper provideDbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        return new DbOpenHelper(context, name);
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(
            @ApplicationContext Context context,
            @PreferenceInfo String prefFileName) {
        return new AppPreferencesHelper(context, prefFileName);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHeader apiHeader) {
        return new AppApiHelper(apiHeader);
    }

    @Provides
    @Singleton
    ApiHeader provideApiHeader(@ApiInfo String apiKey, DbHelper dbHelper, PreferencesHelper preferencesHelper) {
        return new ApiHeader(apiKey, dbHelper, preferencesHelper);
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
