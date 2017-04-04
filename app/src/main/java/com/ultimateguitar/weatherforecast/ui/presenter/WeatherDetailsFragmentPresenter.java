package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.api.ApiRequest;
import com.ultimateguitar.weatherforecast.database.entity.DailyResponse;
import com.ultimateguitar.weatherforecast.database.entity.WeekMain;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.WeatherDetailsFragmentView;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import by.ultimateguitar.weatherforecast.R;
import rx.Observable;
import rx.Observer;

/**
 * Created by kirila on 4.4.17.
 */
public class WeatherDetailsFragmentPresenter extends BasePresenter {

    private WeatherDetailsFragmentView mView;

    public WeatherDetailsFragmentPresenter(WeatherDetailsFragmentView view) {
        super(view.getContext());
        mView = view;
    }

    @Override
    public BaseContextView getView() {
        return mView;
    }

    public void loadWeather(int cityId) {
        final List<WeekMain> weekMains = new ArrayList<>();
        Observable<DailyResponse> observable = ApiRequest.getInstance().getApi().getWeekWeather(cityId, mView.getContext().getString(R.string.api_key));
        Observer<DailyResponse> observer = new Observer<DailyResponse>() {
            @Override
            public void onCompleted() {
                mView.updateWeekWeather(weekMains);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(DailyResponse dailyResponse) {
                weekMains.addAll(dailyResponse.getMains());
            }
        };
        bindObservable(observable, observer);
    }
}
