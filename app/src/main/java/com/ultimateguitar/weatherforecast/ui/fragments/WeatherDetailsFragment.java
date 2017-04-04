package com.ultimateguitar.weatherforecast.ui.fragments;

import com.ultimateguitar.weatherforecast.database.entity.WeekMain;
import com.ultimateguitar.weatherforecast.ui.adapter.WeekWeatherAdapter;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseFragment;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.presenter.WeatherDetailsFragmentPresenter;
import com.ultimateguitar.weatherforecast.ui.view.WeatherDetailsFragmentView;

import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import by.ultimateguitar.weatherforecast.R;

/**
 * Created by kirila on 4.4.17.
 */
public class WeatherDetailsFragment extends BaseFragment implements WeatherDetailsFragmentView {

    private int LAYOUT = R.layout.fragment_city_weather;

    private static final String EXTRA_CITY_ID = "com.ultimateguitar.weatherforecast.ui.fragments.city_id";

    private WeatherDetailsFragmentPresenter mPresenter;
    private WeekWeatherAdapter mWeatherAdapter;
    private int mCityId;

    @BindView(R.id.week_weather_recycler)
    RecyclerView mWeekWeatherRecycler;

    public static WeatherDetailsFragment newInstance(int cityId) {
        WeatherDetailsFragment fragment = new WeatherDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(EXTRA_CITY_ID, cityId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);
        mCityId = getArguments().getInt(EXTRA_CITY_ID);
        mPresenter.loadWeather(mCityId);
        return view;
    }

    @Override
    public BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new WeatherDetailsFragmentPresenter(this);
    }

    @Override
    public void updateWeekWeather(List<WeekMain> weekMains) {
        mWeatherAdapter = new WeekWeatherAdapter(weekMains, getActivity());
        mWeekWeatherRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mWeekWeatherRecycler.setAdapter(mWeatherAdapter);
    }
}
