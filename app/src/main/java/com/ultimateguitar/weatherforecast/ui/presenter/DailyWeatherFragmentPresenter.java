package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.api.ApiRequest;
import com.ultimateguitar.weatherforecast.api.response.DailyResponse;
import com.ultimateguitar.weatherforecast.database.dao.DailyWeatherDao;
import com.ultimateguitar.weatherforecast.database.dao.MainWeatherDao;
import com.ultimateguitar.weatherforecast.database.daoimpl.DailyWeatherDaoImpl;
import com.ultimateguitar.weatherforecast.database.daoimpl.MainWeatherDaoImpl;
import com.ultimateguitar.weatherforecast.database.entity.DailyWeather;
import com.ultimateguitar.weatherforecast.database.entity.MainWeather;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.DailyWeatherFragmentView;
import com.ultimateguitar.weatherforecast.util.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

import by.ultimateguitar.weatherforecast.R;
import rx.Observable;
import rx.Observer;

/**
 * Created by kirila on 4.4.17.
 */
public class DailyWeatherFragmentPresenter extends BasePresenter {

    private DailyWeatherFragmentView mView;
    private DailyWeatherDao mDailyWeatherDao = DailyWeatherDaoImpl.getInstance();
    private MainWeatherDao mMainWeatherDao = MainWeatherDaoImpl.getInstance();

    public DailyWeatherFragmentPresenter(DailyWeatherFragmentView view) {
        super(view.getContext());
        mView = view;
    }

    @Override
    public BaseContextView getView() {
        return mView;
    }

    public void loadWeather(int cityId) {
        if (NetworkUtil.isNetworkConnected(mView.getContext())) {
            loadOnline(cityId);
        } else {
            loadOffline(cityId);
        }
    }

    private void loadOffline(int cityId) {
        mView.updateWeekWeather(mDailyWeatherDao.getWeatherByCityId(cityId).getMainWeather());
    }

    private void loadOnline(final int cityId) {
        final List<MainWeather> weekMains = new ArrayList<>();
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
                DailyWeather oldDailyWeather = mDailyWeatherDao.getWeatherByCityId(cityId);
                if (oldDailyWeather != null) {
                    mDailyWeatherDao.deleteWeather(oldDailyWeather);
                }

                DailyWeather newDailyWeather = new DailyWeather();
                newDailyWeather.setCityId(cityId);
                mDailyWeatherDao.addWeather(newDailyWeather);
                List<MainWeather> mainWeathers = new ArrayList<>();
                for (int i = 0; i < dailyResponse.getMains().size(); i++) {
                    MainWeather mainWeather = new MainWeather();
                    mainWeather.setDailyWeather(newDailyWeather);
                    mainWeather.setTempDay(dailyResponse.getMains().get(i).getTemperatures().getTempDay());
                    mainWeather.setTempEve(dailyResponse.getMains().get(i).getTemperatures().getTempEve());
                    mainWeather.setTempNight(dailyResponse.getMains().get(i).getTemperatures().getTempNight());
                    mainWeather.setTempMorn(dailyResponse.getMains().get(i).getTemperatures().getTempMorn());
                    mainWeather.setHumidity(dailyResponse.getMains().get(i).getHumidity());
                    mainWeather.setPressure(dailyResponse.getMains().get(i).getPressure());
                    mainWeather.setIcon(dailyResponse.getMains().get(i).getWeathers().get(0).getIcon());
                    mainWeather.setDescription(dailyResponse.getMains().get(i).getWeathers().get(0).getDescription());
                    mainWeathers.add(mainWeather);
                }
                mMainWeatherDao.addWeathers(mainWeathers);
                weekMains.addAll(mainWeathers);
            }
        };
        bindObservable(observable, observer);
    }

}
