package com.ultimateguitar.weatherforecast.ui.activities;

import com.ultimateguitar.weatherforecast.ui.mvp.BaseActivity;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.presenter.SplashActivityPresenter;
import com.ultimateguitar.weatherforecast.ui.view.SplashActivityView;

import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import butterknife.ButterKnife;
import by.ultimateguitar.weatherforecast.R;
import rx.Observable;
import rx.Observer;

/**
 * Created by kirila on 4.4.17.
 */

public class SplashActivity extends BaseActivity implements SplashActivityView {

    private static final int LAYOUT = R.layout.activity_splash;

    private SplashActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
        Observable<String> observable = Observable.just("0").delay(1500, TimeUnit.MILLISECONDS);
        createAndAddSubscription(observable, observer);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new SplashActivityPresenter(this);

    }

    private Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {
            startActivity(MainActivity.newIntent(SplashActivity.this));
            finish();
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();

        }

        @Override
        public void onNext(String s) {

        }
    };

}
