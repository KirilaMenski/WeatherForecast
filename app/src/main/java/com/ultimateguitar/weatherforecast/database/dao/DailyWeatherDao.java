package com.ultimateguitar.weatherforecast.database.dao;

import com.ultimateguitar.weatherforecast.database.entity.DailyWeather;

import java.util.List;

/**
 * Created by kirila on 5.4.17.
 */

public interface DailyWeatherDao {

    void addWeather(DailyWeather weather);

    void deleteWeather(DailyWeather weather);

    List<DailyWeather> getCurrentWeather();

    DailyWeather getWeatherByCityId(int cityId);

}
