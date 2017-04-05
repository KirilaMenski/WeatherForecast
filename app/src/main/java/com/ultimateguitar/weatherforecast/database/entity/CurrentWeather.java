package com.ultimateguitar.weatherforecast.database.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by kirila on 5.4.17.
 */

@DatabaseTable(tableName = "current_weather")
public class CurrentWeather implements Serializable {

    @DatabaseField(generatedId = true, columnName = "id")
    private int mId;
    @DatabaseField(columnName = "city_id")
    private int mCityId;
    @DatabaseField(columnName = "city_name")
    private String mCityName;
    @DatabaseField(columnName = "icon")
    private String mIcon;
    @DatabaseField(columnName = "current_temp")
    private double mCurrentTemp;
    @DatabaseField(columnName = "pressure")
    private double mPressure;
    @DatabaseField(columnName = "humidity")
    private int mHumidity;
    @DatabaseField(columnName = "description")
    private String mDescription;

    public CurrentWeather() {

    }

    public CurrentWeather(int id, int cityId, String cityName, String icon, double currentTemp, double pressure, int humidity, String description) {
        mId = id;
        mCityId = cityId;
        mCityName = cityName;
        mIcon = icon;
        mCurrentTemp = currentTemp;
        mPressure = pressure;
        mHumidity = humidity;
        mDescription = description;
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

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public double getCurrentTemp() {
        return mCurrentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        mCurrentTemp = currentTemp;
    }

    public double getPressure() {
        return mPressure;
    }

    public void setPressure(double pressure) {
        mPressure = pressure;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        mHumidity = humidity;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
