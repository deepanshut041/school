package com.futurastic.deepanshu.school.ui.setting;

import com.futurastic.deepanshu.school.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by deepanshu on 17/3/18.
 */

public class SettingPresenter<V extends SettingMvpView> extends BasePresenter<V>
        implements SettingMvpPresenter<V> {

    @Inject
    public SettingPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
