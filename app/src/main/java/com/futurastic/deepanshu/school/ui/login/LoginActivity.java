package com.futurastic.deepanshu.school.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.futurastic.deepanshu.school.R;
import com.futurastic.deepanshu.school.ui.base.BaseActivity;
import com.futurastic.deepanshu.school.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginActivity.this);
    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openMainActivity() {
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = MainActivity.getStartIntent(LoginActivity.this);
                startActivity(intent);
                finish();
            }
        }, 1000);
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
