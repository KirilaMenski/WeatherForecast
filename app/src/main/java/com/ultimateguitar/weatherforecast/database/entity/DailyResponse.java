package com.ultimateguitar.weatherforecast.database.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */

public class DailyResponse implements Serializable {

    @SerializedName("cnt")
    private int mCnt;
    @SerializedName("list")
    private List<WeekMain> mMains;

    public DailyResponse() {
    }

    public DailyResponse(int cnt, List<WeekMain> mains) {
        mCnt = cnt;
        mMains = mains;
    }

    public int getCnt() {
        return mCnt;
    }

    public void setCnt(int cnt) {
        mCnt = cnt;
    }

    public List<WeekMain> getMains() {
        return mMains;
    }

    public void setMains(List<WeekMain> mains) {
        mMains = mains;
    }
}
