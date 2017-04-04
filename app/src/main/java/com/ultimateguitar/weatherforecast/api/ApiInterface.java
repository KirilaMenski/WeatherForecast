package com.ultimateguitar.weatherforecast.api;

import com.ultimateguitar.weatherforecast.database.entity.DailyResponse;
import com.ultimateguitar.weatherforecast.database.entity.WeatherResponse;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kirila on 4.4.17.
 */

public interface ApiInterface {

    @POST("weather")
    Observable<WeatherResponse> getWeather(@Query("id") int cityId, @Query("appid") String appId);
    @POST("forecast/daily")
    Observable<DailyResponse> getWeekWeather(@Query("id") int cityId, @Query("appid") String appId);

}
