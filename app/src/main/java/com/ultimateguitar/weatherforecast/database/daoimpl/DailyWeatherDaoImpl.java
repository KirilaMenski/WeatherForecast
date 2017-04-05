package com.ultimateguitar.weatherforecast.database.daoimpl;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.ultimateguitar.weatherforecast.WeatherForecastApp;
import com.ultimateguitar.weatherforecast.database.DatabaseHelper;
import com.ultimateguitar.weatherforecast.database.dao.DailyWeatherDao;
import com.ultimateguitar.weatherforecast.database.entity.DailyWeather;

import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

/**
 * Created by kirila on 5.4.17.
 */

public class DailyWeatherDaoImpl implements DailyWeatherDao {

    private static DailyWeatherDaoImpl mInstance;
    private WeakReference<Context> mContext;
    private DatabaseHelper mDatabaseHelper;
    private Dao<DailyWeather, Integer> mDao;

    public static synchronized DailyWeatherDaoImpl getInstance() {
        if (mInstance == null) {
            mInstance = new DailyWeatherDaoImpl();
        }
        return mInstance;
    }

    private DailyWeatherDaoImpl() {
        mContext = new WeakReference<>(WeatherForecastApp.getAppContext());
        mDatabaseHelper = OpenHelperManager.getHelper(mContext.get(), DatabaseHelper.class);
        mDao = mDatabaseHelper.getDailyDao();
    }

    @Override
    public void addWeather(DailyWeather weather) {
        try {
            mDao.create(weather);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWeather(DailyWeather weather) {
        try {
            mDao.delete(weather);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DailyWeather> getCurrentWeather() {
        List<DailyWeather> dailyWeathers = new ArrayList<>();
        try {
            QueryBuilder<DailyWeather, Integer> queryBuilder = mDao.queryBuilder();
            dailyWeathers = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dailyWeathers;
    }

    @Override
    public DailyWeather getWeatherByCityId(int cityId) {
        List<DailyWeather> weatherResponses;
        try {
            QueryBuilder<DailyWeather, Integer> queryBuilder = mDao.queryBuilder();
            queryBuilder.where().eq("city_id", cityId);
            weatherResponses = queryBuilder.query();
            return (weatherResponses.size() > 0) ? weatherResponses.get(0) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
