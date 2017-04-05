package com.ultimateguitar.weatherforecast.ui.view;

import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;

/**
 * Created by kirila on 4.4.17.
 */
public interface CityWeatherFragmentView extends BaseContextView {

    void setWeatherIcon(String icon);

    void setDescription(String description);

    void setCityName(String name);

    void setTemp(double temp);

    void setPressure(double pressure);

    void setHumidity(int humidity);

}
