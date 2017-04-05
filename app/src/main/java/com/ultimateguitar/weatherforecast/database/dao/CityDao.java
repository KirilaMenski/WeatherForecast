package com.ultimateguitar.weatherforecast.database.dao;

import com.ultimateguitar.weatherforecast.database.entity.City;

import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */
public interface CityDao {

    void addCity(City city);

    void updateCity(City city);

    void deleteCity(City city);

    List<City> getAllCities();

    City getCityById(int cityId);
}
