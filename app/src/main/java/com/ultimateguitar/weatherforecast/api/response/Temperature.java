package com.ultimateguitar.weatherforecast.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kirila on 4.4.17.
 */
public class Temperature implements Serializable {

    @SerializedName("day")
    private double mTempDay;
    @SerializedName("eve")
    private double mTempEve;
    @SerializedName("morn")
    private double mTempMorn;
    @SerializedName("night")
    private double mTempNight;

    public Temperature() {

    }

    public Temperature(double tempDay, double tempEve, double tempMorn, double tempNight) {
        mTempDay = tempDay;
        mTempEve = tempEve;
        mTempMorn = tempMorn;
        mTempNight = tempNight;
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

    public double getTempMorn() {
        return mTempMorn;
    }

    public void setTempMorn(double tempMorn) {
        mTempMorn = tempMorn;
    }

    public double getTempNight() {
        return mTempNight;
    }

    public void setTempNight(double tempNight) {
        mTempNight = tempNight;
    }

}
