package com.ultimateguitar.weatherforecast.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */
public class WeekMain implements Serializable {

    @SerializedName("temp")
    Temperature mTemperatures;
    @SerializedName("pressure")
    private double mPressure;
    @SerializedName("humidity")
    private int mHumidity;
    @SerializedName("weather")
    private List<Weather> mWeathers;

    public WeekMain() {

    }

    public WeekMain(int id, double pressure, List<Weather> weather, int humidity) {
        mPressure = pressure;
        mWeathers = weather;
        mHumidity = humidity;
    }

    public Temperature getTemperatures() {
        return mTemperatures;
    }

    public void setTemperatures(Temperature temperatures) {
        mTemperatures = temperatures;
    }

    public double getPressure() {
        return mPressure;
    }

    public void setPressure(double pressure) {
        mPressure = pressure;
    }

    public List<Weather> getWeathers() {
        return mWeathers;
    }

    public void setWeathers(List<Weather> weathers) {
        mWeathers = weathers;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        mHumidity = humidity;
    }
}
