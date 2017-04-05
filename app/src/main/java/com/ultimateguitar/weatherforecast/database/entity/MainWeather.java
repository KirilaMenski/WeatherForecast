package com.ultimateguitar.weatherforecast.database.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by kirila on 5.4.17.
 */
@DatabaseTable(tableName = "main_weather")
public class MainWeather implements Serializable {

    @DatabaseField(generatedId = true, columnName = "id")
    private int mId;
    @DatabaseField(columnName = "daily_weather_id", foreign = true,
            foreignAutoRefresh = true, columnDefinition = "integer references daily_weather(id) on delete cascade")
    private DailyWeather mDailyWeather;
    @DatabaseField(columnName = "temp_morn")
    private double mTempMorn;
    @DatabaseField(columnName = "temp_day")
    private double mTempDay;
    @DatabaseField(columnName = "temp_eve")
    private double mTempEve;
    @DatabaseField(columnName = "temp_night")
    private double mTempNight;
    @DatabaseField(columnName = "humidity")
    private int mHumidity;
    @DatabaseField(columnName = "pressure")
    private double mPressure;
    @DatabaseField(columnName = "description")
    private String mDescription;
    @DatabaseField(columnName = "icon")
    private String mIcon;

    public MainWeather() {
    }

    public MainWeather(int id, DailyWeather dailyWeather, double tempMorn, double tempDay, double tempEve, double tempNight, int humidity, double pressure, String description, String icon) {
        mId = id;
        mDailyWeather = dailyWeather;
        mTempMorn = tempMorn;
        mTempDay = tempDay;
        mTempEve = tempEve;
        mTempNight = tempNight;
        mHumidity = humidity;
        mPressure = pressure;
        mDescription = description;
        mIcon = icon;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public DailyWeather getDailyWeather() {
        return mDailyWeather;
    }

    public void setDailyWeather(DailyWeather dailyWeather) {
        mDailyWeather = dailyWeather;
    }

    public double getTempMorn() {
        return mTempMorn;
    }

    public void setTempMorn(double tempMorn) {
        mTempMorn = tempMorn;
    }

    public double getTempDay() {
        return mTempDay;
    }

    public void setTempDay(double tempDay) {
        mTempDay = tempDay;
    }

    public double getTempEve() {
        return mTempEve;
    }

    public void setTempEve(double tempEve) {
        mTempEve = tempEve;
    }

    public double getTempNight() {
        return mTempNight;
    }

    public void setTempNight(double tempNight) {
        mTempNight = tempNight;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        mHumidity = humidity;
    }

    public double getPressure() {
        return mPressure;
    }

    public void setPressure(double pressure) {
        mPressure = pressure;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }
}
