package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.database.entity.City;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.AllCitiesDialogView;
import com.ultimateguitar.weatherforecast.util.CitiesFile;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by kirila on 4.4.17.
 */
public class AllCitiesDialogPresenter extends BasePresenter {

    private AllCitiesDialogView mView;

    public AllCitiesDialogPresenter(AllCitiesDialogView view) {
        super(view.getContext());
        mView = view;
    }

    @Override
    public BaseContextView getView() {
        return mView;
    }

    public void getAllCities() {

        try {
            List<City> cities = CitiesFile.getCities(mView.getContext());
            mView.updateCityRecycler(cities);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
