package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.SplashActivityView;

/**
 * Created by kirila on 4.4.17.
 */
public class SplashActivityPresenter extends BasePresenter {

    private SplashActivityView mView;

    public SplashActivityPresenter(SplashActivityView view) {
        super(view.getContext());
        mView = view;
    }

    @Override
    public BaseContextView getView() {
        return mView;
    }
}
