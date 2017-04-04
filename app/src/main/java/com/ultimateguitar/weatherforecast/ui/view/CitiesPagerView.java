package com.ultimateguitar.weatherforecast.ui.view;

import com.ultimateguitar.weatherforecast.database.entity.City;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;

import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */
public interface CitiesPagerView extends BaseContextView {

    void updateCitiesAdapter(List<City> cities);

}
