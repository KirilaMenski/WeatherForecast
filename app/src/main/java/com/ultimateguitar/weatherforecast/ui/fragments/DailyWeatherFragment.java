package com.ultimateguitar.weatherforecast.ui.fragments;

import com.ultimateguitar.weatherforecast.database.entity.MainWeather;
import com.ultimateguitar.weatherforecast.ui.adapter.WeekWeatherAdapter;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseFragment;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.presenter.DailyWeatherFragmentPresenter;
import com.ultimateguitar.weatherforecast.ui.view.DailyWeatherFragmentView;

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
public class DailyWeatherFragment extends BaseFragment implements DailyWeatherFragmentView {

    private int LAYOUT = R.layout.fragment_daily_weather;

    private static final String EXTRA_CITY_ID = "com.ultimateguitar.weatherforecast.ui.fragments.city_id";

    private DailyWeatherFragmentPresenter mPresenter;
    private WeekWeatherAdapter mWeatherAdapter;
    private int mCityId;

    @BindView(R.id.week_weather_recycler)
    RecyclerView mWeekWeatherRecycler;

    public static DailyWeatherFragment newInstance(int cityId) {
        DailyWeatherFragment fragment = new DailyWeatherFragment();
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
        mPresenter = new DailyWeatherFragmentPresenter(this);
    }

    @Override
    public void updateWeekWeather(List<MainWeather> weekMains) {
        mWeatherAdapter = new WeekWeatherAdapter(weekMains, getActivity());
        mWeekWeatherRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mWeekWeatherRecycler.setAdapter(mWeatherAdapter);
    }
}
