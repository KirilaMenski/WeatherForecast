package com.ultimateguitar.weatherforecast.database.daoimpl;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.ultimateguitar.weatherforecast.WeatherForecastApp;
import com.ultimateguitar.weatherforecast.database.DatabaseHelper;
import com.ultimateguitar.weatherforecast.database.dao.MainWeatherDao;
import com.ultimateguitar.weatherforecast.database.entity.MainWeather;

import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.util.List;

import android.content.Context;

/**
 * Created by kirila on 5.4.17.
 */

public class MainWeatherDaoImpl implements MainWeatherDao {

    private static MainWeatherDaoImpl mInstance;
    private WeakReference<Context> mContext;
    private DatabaseHelper mDatabaseHelper;
    private Dao<MainWeather, Integer> mDao;

    public static synchronized MainWeatherDaoImpl getInstance() {
        if (mInstance == null) {
            mInstance = new MainWeatherDaoImpl();
        }
        return mInstance;
    }

    private MainWeatherDaoImpl() {
        mContext = new WeakReference<>(WeatherForecastApp.getAppContext());
        mDatabaseHelper = OpenHelperManager.getHelper(mContext.get(), DatabaseHelper.class);
        mDao = mDatabaseHelper.getMainWeatherDao();
    }

    @Override
    public void addWeathers(List<MainWeather> mainWeathers) {
        try {
            mDao.create(mainWeathers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
