package com.ultimateguitar.weatherforecast.ui.adapter;

import com.squareup.picasso.Picasso;
import com.ultimateguitar.weatherforecast.database.entity.WeekMain;

import java.lang.ref.WeakReference;
import java.util.List;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import by.ultimateguitar.weatherforecast.R;

/**
 * Created by kirila on 4.4.17.
 */

public class WeekWeatherAdapter extends RecyclerView.Adapter<WeekWeatherAdapter.WeekWeatherHolder> {

    private final int LAYOUT = R.layout.item_day_weather;

    private List<WeekMain> mWeekMains;
    private WeakReference<Activity> mActivity;

    public WeekWeatherAdapter(List<WeekMain> weekMains, Activity activity){
        mWeekMains = weekMains;
        mActivity = new WeakReference<>(activity);
    }

    @Override
    public WeekWeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity.get());
        View view = inflater.inflate(LAYOUT, parent, false);
        return new WeekWeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(WeekWeatherHolder holder, int position) {
        WeekMain weekMain = mWeekMains.get(position);
        holder.bindView(weekMain, position);
    }

    @Override
    public int getItemCount() {
        return mWeekMains.size();
    }

    public class WeekWeatherHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weather_icon)
        ImageView mWeatherIcon;
        @BindView(R.id.temp_morning)
        TextView mTempMorn;
        @BindView(R.id.temp_day)
        TextView mTempDay;
        @BindView(R.id.temp_eve)
        TextView mTempEve;
        @BindView(R.id.temp_night)
        TextView mTempNight;
        @BindView(R.id.pressure)
        TextView mPressure;
        @BindView(R.id.humidity)
        TextView mHumidity;

        public WeekWeatherHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(WeekMain weekMain, int position){
            String url = String.format("http://openweathermap.org/img/w/%s.png", weekMain.getWeather().get(0).getIcon());
            Picasso.with(mActivity.get())
                    .load(url)
                    .into(mWeatherIcon);
            mTempMorn.setText(mActivity.get().getString(R.string.temp_morn) + weekMain.getTemp().getTempMorn());
            mTempDay.setText(mActivity.get().getString(R.string.temp_day) + weekMain.getTemp().getTempMorn());
            mTempEve.setText(mActivity.get().getString(R.string.temp_eve) + weekMain.getTemp().getTempMorn());
            mTempNight.setText(mActivity.get().getString(R.string.temp_night) + weekMain.getTemp().getTempMorn());
            mPressure.setText(mActivity.get().getString(R.string.pressure) + weekMain.getPressure());
            mHumidity.setText(mActivity.get().getString(R.string.humidity) + weekMain.getHumidity());
        }
    }
}
