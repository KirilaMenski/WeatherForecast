package com.ultimateguitar.weatherforecast.database.entity;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by kirila on 4.4.17.
 */

@DatabaseTable(tableName = "cities")
public class City implements Serializable, Comparator<City> {

    @DatabaseField(generatedId = true, columnName = "id")
    private int mId;
    @SerializedName("_id")
    @DatabaseField(columnName = "city_id")
    private int mCityId;
    @SerializedName("name")
    @DatabaseField(columnName = "name")
    private String mName;
    @SerializedName("country")
    @DatabaseField(columnName = "country")
    private String mCountry;

    public City() {

    }

    public City(int cityId, String name, String country) {
        mCityId = cityId;
        mName = name;
        mCountry = country;
    }

    public int getCityId() {
        return mCityId;
    }

    public void setCityId(int id) {
        mCityId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    @Override
    public int compare(City city, City t1) {
        String name1 = city.getName().toLowerCase().trim();
        String name2 = t1.getName().toLowerCase().trim();
        return name1.compareTo(name2);
    }
}
