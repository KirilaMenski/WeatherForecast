package com.ultimateguitar.weatherforecast.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */

public class DailyResponse implements Serializable {

    private int mId;
    @SerializedName("list")
    private List<WeekMain> mMains;

    public DailyResponse() {

    }

    public DailyResponse(int id, List<WeekMain> mains) {
        mId = id;
        mMains = mains;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public List<WeekMain> getMains() {
        return mMains;
    }

    public void setMains(List<WeekMain> mains) {
        mMains = mains;
    }
}
