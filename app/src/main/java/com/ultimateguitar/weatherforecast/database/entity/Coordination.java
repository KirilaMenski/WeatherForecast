package com.ultimateguitar.weatherforecast.database.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kirila on 4.4.17.
 */
public class Coordination implements Serializable {

    @SerializedName("lon")
    private double mLong;
    @SerializedName("lat")
    private double mLat;

    public Coordination(){

    }

    public Coordination(double aLong, double lat) {
        mLong = aLong;
        mLat = lat;
    }

    public double getLong() {
        return mLong;
    }

    public void setLong(double aLong) {
        mLong = aLong;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }
}
