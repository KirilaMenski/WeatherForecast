package com.ultimateguitar.weatherforecast.database.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kirila on 4.4.17.
 */
public class Main implements Serializable {

    @SerializedName("temp")
    private double mTemp;
    @SerializedName("pressure")
    private double mPressure;
    @SerializedName("humidity")
    private int mHumidity;
    @SerializedName("temp_min")
    private double mMinTemp;
    @SerializedName("temp_max")
    private double mMaxTemp;

    public Main() {

    }

    public Main(double temp, double pressure, int humidity, double minTemp, double maxTemp) {
        mTemp = temp;
        mPressure = pressure;
        mHumidity = humidity;
        mMinTemp = minTemp;
        mMaxTemp = maxTemp;
    }

    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double temp) {
        mTemp = temp;
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

    public double getMinTemp() {
        return mMinTemp;
    }

    public void setMinTemp(double minTemp) {
        mMinTemp = minTemp;
    }

    public double getMaxTemp() {
        return mMaxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        mMaxTemp = maxTemp;
    }
}
