package com.ultimateguitar.weatherforecast.database.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */

public class WeatherResponse implements Serializable {

    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("dt")
    private long mDt;
    @SerializedName("coord")
    private Coordination mCoord;
    @SerializedName("weather")
    private List<Weather> mWeather;
    @SerializedName("main")
    private Main mMain;


    public WeatherResponse() {

    }

    public WeatherResponse(int id, String name, long dt, Coordination coord, List<Weather> weather, Main main) {
        mId = id;
        mName = name;
        mDt = dt;
        mCoord = coord;
        mWeather = weather;
        mMain = main;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public long getDt() {
        return mDt;
    }

    public void setDt(long dt) {
        mDt = dt;
    }

    public Coordination getCoord() {
        return mCoord;
    }

    public void setCoord(Coordination coord) {
        mCoord = coord;
    }

    public List<Weather> getWeather() {
        return mWeather;
    }

    public void setWeather(List<Weather> weather) {
        mWeather = weather;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main main) {
        mMain = main;
    }
}
