package com.ultimateguitar.weatherforecast.ui.fragments;

import com.squareup.picasso.Picasso;
import com.ultimateguitar.weatherforecast.ui.adapter.CityAdapter;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseFragment;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.presenter.CityWeatherFragmentPresenter;
import com.ultimateguitar.weatherforecast.ui.view.CityWeatherFragmentView;
import com.ultimateguitar.weatherforecast.util.DateUtil;
import com.ultimateguitar.weatherforecast.util.FileManager;
import com.ultimateguitar.weatherforecast.util.FragmentUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.ultimateguitar.weatherforecast.R;

/**
 * Created by kirila on 4.4.17.
 */

public class CityWeatherFragment extends BaseFragment implements CityWeatherFragmentView {

    private final int LAYOUT = R.layout.fragment_city_weather;
    private static final String EXTRA_CITY_ID = "com.ultimateguitar.weatherforecast.ui.fragments.city_id";

    private CityWeatherFragmentPresenter mPresenter;
    private CityAdapter mCityAdapter;
    private int mCityId;

    @BindView(R.id.weather_icon)
    ImageView mWeatherIcon;
    @BindView(R.id.city_name)
    TextView mNameCity;
    @BindView(R.id.temp)
    TextView mTemp;
    @BindView(R.id.humidity)
    TextView mHumidity;
    @BindView(R.id.pressure)
    TextView mPressure;
    @BindView(R.id.description)
    TextView mDescription;
    @BindView(R.id.share)
    TextView mShare;

    @BindView(R.id.city_weather_ll)
    LinearLayout mCityWeatherLl;

    public static CityWeatherFragment newInstance(int cityId) {
        CityWeatherFragment fragment = new CityWeatherFragment();
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

    @OnClick(R.id.city_weather_ll)
    public void openCityDetails() {
        FragmentUtil.replaceFragment(getActivity(), R.id.main_fragment_container, DailyWeatherFragment.newInstance(mCityId), true);
    }

    @OnClick(R.id.share)
    public void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_format, DateUtil.getDate(),
                mNameCity.getText().toString(), mDescription.getText().toString(), mTemp.getText().toString()));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
        startActivity(intent);
    }

    @Override
    public BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new CityWeatherFragmentPresenter(this);
    }

    @Override
    public void setWeatherIcon(String icon) {
        String url = FileManager.ICON_PATH + String.format("%s.png", icon);
        Picasso.with(getContext())
                .load(url)
                .into(mWeatherIcon);
    }

    @Override
    public void setDescription(String description) {
        mDescription.setText(description);
    }

    @Override
    public void setCityName(String name) {
        mNameCity.setText(name);
    }

    @Override
    public void setTemp(double temp) {
        mTemp.setText(getResources().getString(R.string.temp, (int) (temp - 273)));
    }

    @Override
    public void setPressure(double pressure) {
        mPressure.setText(getResources().getString(R.string.pressure, (int) pressure));
    }

    @Override
    public void setHumidity(int humidity) {
        mHumidity.setText(getString(R.string.humidity, (int) humidity));
    }

}
