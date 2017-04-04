package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.api.ApiRequest;
import com.ultimateguitar.weatherforecast.database.entity.WeatherResponse;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.CityWeatherFragmentView;

import by.ultimateguitar.weatherforecast.R;
import rx.Observable;
import rx.Observer;

/**
 * Created by kirila on 4.4.17.
 */
public class CityWeatherFragmentPresenter extends BasePresenter {

    private CityWeatherFragmentView mView;

    public CityWeatherFragmentPresenter(CityWeatherFragmentView view) {
        super(view.getContext());
        mView = view;
    }

    public void initializeView(int cityId) {
        Observable<WeatherResponse> observable = ApiRequest.getInstance().getApi().getWeather(cityId, mView.getContext().getString(R.string.api_key));
        Observer<WeatherResponse> observer = new Observer<WeatherResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(WeatherResponse weatherResponse) {
                mView.setCityName(weatherResponse.getName());
                mView.setTemp(weatherResponse.getMain().getTemp());
                mView.setPressure(weatherResponse.getMain().getPressure());
                mView.setHumidity(weatherResponse.getMain().getHumidity());
                mView.setWeatherIcon(weatherResponse.getWeather().get(0).getIcon());
            }
        };
        bindObservable(observable, observer);
    }

    @Override
    public BaseContextView getView() {
        return mView;
    }

}
