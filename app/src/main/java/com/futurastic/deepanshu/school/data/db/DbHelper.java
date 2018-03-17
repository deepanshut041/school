package com.futurastic.deepanshu.school.data.db;

import com.futurastic.deepanshu.school.data.db.Model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by deepanshu on 17/3/18.
 */

public interface DbHelper {

    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();
}