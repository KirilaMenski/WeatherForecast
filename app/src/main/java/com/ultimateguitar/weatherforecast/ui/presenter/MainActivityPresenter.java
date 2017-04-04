package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.MainActivityView;

/**
 * Created by kirila on 4.4.17.
 */
public class MainActivityPresenter extends BasePresenter {

    private MainActivityView mView;

    public MainActivityPresenter(MainActivityView view) {
        super(view.getContext());
        mView = view;
    }

    @Override
    public BaseContextView getView() {
        return mView;
    }
}
