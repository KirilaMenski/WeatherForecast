package com.ultimateguitar.weatherforecast.database.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kirila on 4.4.17.
 */
public class Temperature implements Serializable {

    private int mId;
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

    public Temperature(int id, double tempDay, double tempEve, double tempMorn, double tempNight) {
        mId = id;
        mTempDay = tempDay;
        mTempEve = tempEve;
        mTempMorn = tempMorn;
        mTempNight = tempNight;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
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
