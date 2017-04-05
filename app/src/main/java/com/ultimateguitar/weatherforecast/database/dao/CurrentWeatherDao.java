package com.ultimateguitar.weatherforecast.database.dao;

import com.ultimateguitar.weatherforecast.database.entity.CurrentWeather;

import java.util.List;

/**
 * Created by kirila on 5.4.17.
 */

public interface CurrentWeatherDao {

    void addWeather(CurrentWeather weatherResponse);

    void deleteWeather(CurrentWeather weatherResponse);

    List<CurrentWeather> getCurrentWeather();

    CurrentWeather getWeatherByCityId(int cityId);

}
