package com.ultimateguitar.weatherforecast.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kirila on 4.4.17.
 */
public class Weather implements Serializable {

    @SerializedName("id")
    private int mId;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("icon")
    private String mIcon;

    public Weather() {

    }

    public Weather(int id, String description, String icon) {
        mId = id;
        mDescription = description;
        mIcon = icon;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
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
