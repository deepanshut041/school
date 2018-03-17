package com.futurastic.deepanshu.school.data.db;

import com.futurastic.deepanshu.school.data.db.Model.User;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

/**
 * Created by deepanshu on 17/3/18.
 */

public class AppDbHelper implements DbHelper {

    private final DaoSession daoSession;

    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        daoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Long> insertUser(final User user) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return daoSession.getUserDao().insert(user);
            }
        });
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return daoSession.getUserDao().loadAll();
            }
        });
    }
}