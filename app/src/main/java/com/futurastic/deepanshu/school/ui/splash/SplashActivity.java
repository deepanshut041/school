package com.futurastic.deepanshu.school.ui.splash;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.futurastic.deepanshu.school.R;
import com.futurastic.deepanshu.school.ui.base.BaseActivity;
import com.futurastic.deepanshu.school.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

import static android.os.Looper.getMainLooper;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);
    }

    @Override
    public void openLoginActivity() {
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();
            }
        }, 800);
    }

    @Override
    public void openMainActivity() {
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = MainActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();
            }
        }, 800);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}