package com.ultimateguitar.weatherforecast.database.daoimpl;


import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.ultimateguitar.weatherforecast.WeatherForecastApp;
import com.ultimateguitar.weatherforecast.database.DatabaseHelper;
import com.ultimateguitar.weatherforecast.database.dao.CityDao;
import com.ultimateguitar.weatherforecast.database.entity.City;

import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

/**
 * Created by kirila on 4.4.17.
 */

public class CityDaoImpl implements CityDao {

    private static CityDaoImpl mInstance;
    private WeakReference<Context> mContext;
    private DatabaseHelper mDatabaseHelper;
    private Dao<City, Integer> mDao;

    public static synchronized CityDaoImpl getInstance() {
        if (mInstance == null) {
            mInstance = new CityDaoImpl();
        }
        return mInstance;
    }

    private CityDaoImpl() {
        mContext = new WeakReference<>(WeatherForecastApp.getAppContext());
        mDatabaseHelper = OpenHelperManager.getHelper(mContext.get(), DatabaseHelper.class);
        mDao = mDatabaseHelper.getCitiesDao();
    }

    @Override
    public void addCity(City city) {
        try {
            mDao.create(city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCity(City city) {
        try {
            mDao.update(city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(City city) {
        try {
            mDao.delete(city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        QueryBuilder<City, Integer> queryBuilder = mDao.queryBuilder();
        try {
            cities = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
