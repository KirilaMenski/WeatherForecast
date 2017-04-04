package com.ultimateguitar.weatherforecast.database.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */
public class WeekMain implements Serializable {

    private int mId;
    @SerializedName("temp")
    private Temperature mTemp;
    @SerializedName("pressure")
    private double mPressure;
    @SerializedName("humidity")
    private int mHumidity;
    @SerializedName("weather")
    private List<Weather> mWeather;

    public WeekMain() {

    }

    public WeekMain(int id, Temperature temp, double pressure, List<Weather> weather, int humidity) {
        mId = id;
        mTemp = temp;
        mPressure = pressure;
        mWeather = weather;
        mHumidity = humidity;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public Temperature getTemp() {
        return mTemp;
    }

    public void setTemp(Temperature temp) {
        mTemp = temp;
    }

    public double getPressure() {
        return mPressure;
    }

    public void setPressure(double pressure) {
        mPressure = pressure;
    }

    public List<Weather> getWeather() {
        return mWeather;
    }

    public void setWeather(List<Weather> weather) {
        mWeather = weather;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        mHumidity = humidity;
    }
}
