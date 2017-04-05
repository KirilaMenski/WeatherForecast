package com.ultimateguitar.weatherforecast.database.daoimpl;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.ultimateguitar.weatherforecast.WeatherForecastApp;
import com.ultimateguitar.weatherforecast.database.DatabaseHelper;
import com.ultimateguitar.weatherforecast.database.dao.CurrentWeatherDao;
import com.ultimateguitar.weatherforecast.database.entity.CurrentWeather;

import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

/**
 * Created by kirila on 5.4.17.
 */

public class CurrentWeatherDaoImpl implements CurrentWeatherDao {

    private static CurrentWeatherDaoImpl mInstance;
    private WeakReference<Context> mContext;
    private DatabaseHelper mDatabaseHelper;
    private Dao<CurrentWeather, Integer> mDao;

    public static synchronized CurrentWeatherDaoImpl getInstance() {
        if (mInstance == null) {
            mInstance = new CurrentWeatherDaoImpl();
        }
        return mInstance;
    }

    private CurrentWeatherDaoImpl() {
        mContext = new WeakReference<>(WeatherForecastApp.getAppContext());
        mDatabaseHelper = OpenHelperManager.getHelper(mContext.get(), DatabaseHelper.class);
        mDao = mDatabaseHelper.getWeatherDao();
    }

    @Override
    public void addWeather(CurrentWeather weatherResponse) {
        try {
            mDao.create(weatherResponse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWeather(CurrentWeather weatherResponse) {
        try {
            mDao.delete(weatherResponse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CurrentWeather> getCurrentWeather() {
        List<CurrentWeather> weatherResponses = new ArrayList<>();
        try {
            QueryBuilder<CurrentWeather, Integer> queryBuilder = mDao.queryBuilder();
            weatherResponses = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weatherResponses;
    }

    @Override
    public CurrentWeather getWeatherByCityId(int cityId) {
        List<CurrentWeather> weatherResponses;
        try {
            QueryBuilder<CurrentWeather, Integer> queryBuilder = mDao.queryBuilder();
            queryBuilder.where().eq("city_id", cityId);
            weatherResponses = queryBuilder.query();
            return (weatherResponses.size() > 0) ? weatherResponses.get(0) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
