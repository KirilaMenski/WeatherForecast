package com.ultimateguitar.weatherforecast.ui.pager;

import com.ultimateguitar.weatherforecast.database.entity.City;
import com.ultimateguitar.weatherforecast.ui.fragments.CityWeatherFragment;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseFragment;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.presenter.CitiesPagerPresenter;
import com.ultimateguitar.weatherforecast.ui.view.CitiesPagerView;
import com.ultimateguitar.weatherforecast.util.DisplayMetricsUtil;

import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.ultimateguitar.weatherforecast.R;

/**
 * Created by kirila on 4.4.17.
 */

public class CitiesPagerFragment extends BaseFragment implements CitiesPagerView {

    private final int LAYOUT = R.layout.fragment_cities_pager;

    private CitiesPagerPresenter mPresenter;
    private int mPosition = 0;
    private List<City> mCities;


    @BindView(R.id.cities_view_pager)
    ViewPager mCitiesPager;

    public static CitiesPagerFragment newInstance() {
        CitiesPagerFragment fragment = new CitiesPagerFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getAllCities();
    }

    private FragmentStatePagerAdapter getAdapter() {
        return new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return CityWeatherFragment.newInstance(mCities.get(position).getCityId());
            }

            @Override
            public int getCount() {
                return mCities.size();
            }
        };
    }

    private ViewPager.OnPageChangeListener getPageListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    @OnClick(R.id.add_city)
    public void addCity() {
        mPresenter.showDialogCity(getActivity());
    }

    @Override
    public BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new CitiesPagerPresenter(this);
    }

    @Override
    public void updateCitiesAdapter(List<City> cities) {
        mCities = cities;
        mCitiesPager.setAdapter(getAdapter());
        mCitiesPager.addOnPageChangeListener(getPageListener());
        mCitiesPager.setCurrentItem(mPosition);
        mCitiesPager.setClipToPadding(false);
        mCitiesPager.setPageMargin(DisplayMetricsUtil.getTypedValue(getContext(), 10));
        mCitiesPager.setPadding(DisplayMetricsUtil.getTypedValue(getContext(), 40),
                DisplayMetricsUtil.getTypedValue(getContext(), 30),
                DisplayMetricsUtil.getTypedValue(getContext(), 40),
                DisplayMetricsUtil.getTypedValue(getContext(), 50));
    }
}
