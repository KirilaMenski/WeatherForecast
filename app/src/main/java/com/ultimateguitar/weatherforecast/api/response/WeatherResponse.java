package com.ultimateguitar.weatherforecast.api.response;

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
    @SerializedName("weather")
    private List<Weather> mWeathers;
    @SerializedName("main")
    private Main mMain;


    public WeatherResponse() {

    }

    public WeatherResponse(int id, String name, List<Weather> weather) {
        mId = id;
        mName = name;
        mWeathers = weather;
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

    public List<Weather> getWeathers() {
        return mWeathers;
    }

    public void setWeathers(List<Weather> weathers) {
        mWeathers = weathers;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main main) {
        mMain = main;
    }
}
