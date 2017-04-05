package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.api.ApiRequest;
import com.ultimateguitar.weatherforecast.database.dao.CurrentWeatherDao;
import com.ultimateguitar.weatherforecast.database.daoimpl.CurrentWeatherDaoImpl;
import com.ultimateguitar.weatherforecast.api.response.WeatherResponse;
import com.ultimateguitar.weatherforecast.database.entity.CurrentWeather;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.CityWeatherFragmentView;
import com.ultimateguitar.weatherforecast.util.NetworkUtil;

import by.ultimateguitar.weatherforecast.R;
import rx.Observable;
import rx.Observer;

/**
 * Created by kirila on 4.4.17.
 */
public class CityWeatherFragmentPresenter extends BasePresenter {

    private CityWeatherFragmentView mView;
    private CurrentWeatherDao mWeatherDao = CurrentWeatherDaoImpl.getInstance();

    public CityWeatherFragmentPresenter(CityWeatherFragmentView view) {
        super(view.getContext());
        mView = view;
    }

    public void loadWeather(int cityId) {
        if (NetworkUtil.isNetworkConnected(mView.getContext())) {
            loadOnline(cityId);
        } else {
            loadOffline(cityId);
        }
    }

    private void loadOnline(final int cityId) {
        Observable<WeatherResponse> observable = ApiRequest.getInstance().getApi().getWeather(cityId, mView.getContext().getString(R.string.api_key));
        Observer<WeatherResponse> observer = new Observer<WeatherResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(WeatherResponse weatherResponse) {

                CurrentWeather oldWeather = mWeatherDao.getWeatherByCityId(cityId);
                if (oldWeather != null) {
                    mWeatherDao.deleteWeather(oldWeather);
                }
                CurrentWeather newWeather = new CurrentWeather();
                newWeather.setCityId(cityId);
                newWeather.setDescription(weatherResponse.getWeathers().get(0).getDescription());
                newWeather.setCityName(weatherResponse.getName());
                newWeather.setCurrentTemp(weatherResponse.getMain().getTemp());
                newWeather.setIcon(weatherResponse.getWeathers().get(0).getIcon());
                newWeather.setHumidity(weatherResponse.getMain().getHumidity());
                newWeather.setPressure(weatherResponse.getMain().getPressure());
                mWeatherDao.addWeather(newWeather);

                initializeViews(newWeather);

            }
        };
        bindObservable(observable, observer);
    }

    private void loadOffline(int cityId) {
        CurrentWeather currentWeather = mWeatherDao.getWeatherByCityId(cityId);
        initializeViews(currentWeather);
    }

    private void initializeViews(CurrentWeather weatherResponse) {
        if (weatherResponse != null) {
            mView.setCityName(weatherResponse.getCityName());
            mView.setTemp(weatherResponse.getCurrentTemp());
            mView.setDescription(weatherResponse.getDescription());
            mView.setPressure(weatherResponse.getPressure());
            mView.setHumidity(weatherResponse.getHumidity());
            mView.setWeatherIcon(weatherResponse.getIcon());
        }
    }

    @Override
    public BaseContextView getView() {
        return mView;
    }

}
