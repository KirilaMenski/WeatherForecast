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

    @SerializedName("_id")
    @DatabaseField(columnName = "id")
    private int mId;
    @SerializedName("name")
    @DatabaseField(columnName = "name")
    private String mName;
    @SerializedName("country")
    @DatabaseField(columnName = "country")
    private String mCountry;
    @SerializedName("coord")
//    @DatabaseField(columnName = "coord")
    private Coordination mCoord;

    public City() {

    }

    public City(int id, String name, String country, Coordination coord) {
        mId = id;
        mName = name;
        mCountry = country;
        mCoord = coord;
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

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public Coordination getCoord() {
        return mCoord;
    }

    public void setCoord(Coordination coord) {
        mCoord = coord;
    }

    @Override
    public int compare(City city, City t1) {
        String name1 = city.getName().toLowerCase().trim();
        String name2 = t1.getName().toLowerCase().trim();
        return name1.compareTo(name2);
    }
}
