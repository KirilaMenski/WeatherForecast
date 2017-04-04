package com.ultimateguitar.weatherforecast.util;

import com.ultimateguitar.weatherforecast.database.entity.City;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

/**
 * Created by kirila on 4.4.17.
 */

public class CitiesFile {

    private static final String FILE_NAME = "cities/city.list.txt";


    public static List<City> getCities(Context context) throws IOException, JSONException {

        List<City> cities = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(FILE_NAME)));

        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        while (mLine != null) {
            sb.append(mLine);
            mLine = reader.readLine();
            if (mLine != null) {
                JSONObject jsonObject = new JSONObject(mLine);
                City city = new City();
                city.setId(jsonObject.getInt("_id"));
                city.setCountry(jsonObject.getString("country"));
                city.setName(jsonObject.getString("name"));
                cities.add(city);
            }
        }
        reader.close();
        return cities;

    }

}
