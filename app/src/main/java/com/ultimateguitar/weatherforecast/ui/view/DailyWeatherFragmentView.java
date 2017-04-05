package com.ultimateguitar.weatherforecast.ui.view;

import com.ultimateguitar.weatherforecast.database.entity.MainWeather;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;

import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */
public interface DailyWeatherFragmentView extends BaseContextView {

    void updateWeekWeather(List<MainWeather> weatherResponses);

}
