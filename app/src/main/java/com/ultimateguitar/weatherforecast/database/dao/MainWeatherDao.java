package com.ultimateguitar.weatherforecast.database.dao;

import com.ultimateguitar.weatherforecast.database.entity.MainWeather;

import java.util.List;

/**
 * Created by kirila on 5.4.17.
 */

public interface MainWeatherDao {

    void addWeathers(List<MainWeather> mainWeathers);

}
