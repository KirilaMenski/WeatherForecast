package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.database.dao.CityDao;
import com.ultimateguitar.weatherforecast.database.daoimpl.CityDaoImpl;
import com.ultimateguitar.weatherforecast.database.entity.City;
import com.ultimateguitar.weatherforecast.ui.dialog.AllCitiesDialog;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.CitiesPagerView;

import android.support.v4.app.FragmentActivity;

/**
 * Created by kirila on 4.4.17.
 */
public class CitiesPagerPresenter extends BasePresenter implements AllCitiesDialog.DialogListener {

    private CitiesPagerView mView;
    private CityDao mCityDao = CityDaoImpl.getInstance();

    public CitiesPagerPresenter(CitiesPagerView view) {
        super(view.getContext());
        mView = view;
    }

    @Override
    public BaseContextView getView() {
        return mView;
    }

    public void getAllCities() {
        mView.updateCitiesAdapter(mCityDao.getAllCities());
    }

    @Override
    public void citySelectedFromDialog(City city) {
        mCityDao.addCity(city);
        mView.updateCitiesAdapter(mCityDao.getAllCities());
    }

    public void showDialogCity(FragmentActivity activity) {
        AllCitiesDialog dialog = new AllCitiesDialog();
        dialog.setListener(this);
        dialog.show(activity.getSupportFragmentManager(), "cities");
    }
}
