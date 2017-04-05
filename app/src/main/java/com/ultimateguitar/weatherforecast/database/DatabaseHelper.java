package com.ultimateguitar.weatherforecast.database;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ultimateguitar.weatherforecast.database.entity.City;
import com.ultimateguitar.weatherforecast.database.entity.CurrentWeather;
import com.ultimateguitar.weatherforecast.database.entity.DailyWeather;
import com.ultimateguitar.weatherforecast.database.entity.MainWeather;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kirila on 4.4.17.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "Weather.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<City, Integer> mCitiesDao = null;
    private Dao<CurrentWeather, Integer> mWeatherDao = null;
    private Dao<DailyWeather, Integer> mDailyDao = null;
    private Dao<MainWeather, Integer> mMainWeatherDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, City.class);
            TableUtils.createTable(connectionSource, CurrentWeather.class);
            TableUtils.createTable(connectionSource, DailyWeather.class);
            TableUtils.createTable(connectionSource, MainWeather.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<City, Integer> getCitiesDao() {
        if (mCitiesDao == null) {
            try {
                mCitiesDao = getDao(City.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mCitiesDao;
    }

    public Dao<CurrentWeather, Integer> getWeatherDao() {
        if (mWeatherDao == null) {
            try {
                mWeatherDao = getDao(CurrentWeather.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mWeatherDao;
    }

    public Dao<DailyWeather, Integer> getDailyDao() {
        if (mDailyDao == null) {
            try {
                mDailyDao = getDao(DailyWeather.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mDailyDao;
    }

    public Dao<MainWeather, Integer> getMainWeatherDao() {
        if (mMainWeatherDao == null) {
            try {
                mMainWeatherDao = getDao(MainWeather.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mMainWeatherDao;
    }

}
