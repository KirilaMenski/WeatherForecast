package com.ultimateguitar.weatherforecast.database.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kirila on 5.4.17.
 */
@DatabaseTable(tableName = "daily_weather")
public class DailyWeather implements Serializable {

    @DatabaseField(generatedId = true, columnName = "id")
    private int mId;
    @DatabaseField(columnName = "city_id")
    private int mCityId;
    @ForeignCollectionField
    ForeignCollection<MainWeather> mMainWeather;

    public DailyWeather() {

    }

    public DailyWeather(int id, int cityId) {
        mId = id;
        mCityId = cityId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getCityId() {
        return mCityId;
    }

    public void setCityId(int cityId) {
        mCityId = cityId;
    }

    public List<MainWeather> getMainWeather() {
        List<MainWeather> mainWeathers = new ArrayList<>();
        for (MainWeather weather : mMainWeather) {
            mainWeathers.add(weather);
        }
        return mainWeathers;
    }

}
