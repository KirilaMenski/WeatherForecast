package com.ultimateguitar.weatherforecast.ui.presenter;

import com.ultimateguitar.weatherforecast.database.entity.City;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseContextView;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.view.AllCitiesDialogView;
import com.ultimateguitar.weatherforecast.util.FileManager;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;

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

//        try {
//            List<City> cities = FileManager.getCities(mView.getContext());
//            mView.updateCityRecycler(cities);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        final List<City> cities = new ArrayList<>();
        mView.updateViewsVisible(true);
        Observable<List<City>> observable = FileManager.getObservableCities(mView.getContext());
        Observer<List<City>> observer = new Observer<List<City>>() {
            @Override
            public void onCompleted() {
                mView.updateCityRecycler(cities);
                mView.updateViewsVisible(false);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<City> cityList) {
                cities.clear();
                cities.addAll(cityList);
            }
        };
        bindObservable(observable, observer);
    }
}
