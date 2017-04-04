package com.ultimateguitar.weatherforecast.ui.activities;

import com.ultimateguitar.weatherforecast.ui.mvp.BaseActivity;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.pager.CitiesPagerFragment;
import com.ultimateguitar.weatherforecast.ui.presenter.MainActivityPresenter;
import com.ultimateguitar.weatherforecast.ui.view.MainActivityView;
import com.ultimateguitar.weatherforecast.util.FragmentUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import by.ultimateguitar.weatherforecast.R;

public class MainActivity extends BaseActivity implements MainActivityView {

    private final int LAYOUT = R.layout.activity_main;

    private MainActivityPresenter mPresenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        FragmentUtil.replaceFragment(this, R.id.main_fragment_container, CitiesPagerFragment.newInstance(), false);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new MainActivityPresenter(this);
    }
}
