package com.ultimateguitar.weatherforecast.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kirila on 4.4.17.
 */
public class Main implements Serializable {

    @SerializedName("id")
    private int mId;
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

    public Main(int id, double temp, double pressure, int humidity, double minTemp, double maxTemp) {
        mId = id;
        mTemp = temp;
        mPressure = pressure;
        mHumidity = humidity;
        mMinTemp = minTemp;
        mMaxTemp = maxTemp;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
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
