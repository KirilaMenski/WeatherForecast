package com.ultimateguitar.weatherforecast.ui.adapter;

import com.squareup.picasso.Picasso;
import com.ultimateguitar.weatherforecast.database.entity.MainWeather;
import com.ultimateguitar.weatherforecast.util.FileManager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
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

    private List<MainWeather> mWeekMains;
    private WeakReference<Activity> mActivity;
    private List<String> mWeekDays;

    public WeekWeatherAdapter(List<MainWeather> weekMains, Activity activity) {
        mWeekMains = weekMains;
        mActivity = new WeakReference<>(activity);
        mWeekDays = new ArrayList<>(Arrays.asList(mActivity.get().getResources().getStringArray(R.array.week_days)));
    }

    @Override
    public WeekWeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity.get());
        View view = inflater.inflate(LAYOUT, parent, false);
        return new WeekWeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(final WeekWeatherHolder holder, int position) {
        final MainWeather weekMain = mWeekMains.get(position);
        holder.bindView(weekMain, position);
        holder.mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, mActivity.get().getString(R.string.share_format_item,
                        holder.mTempMorn.getText().toString(), holder.mTempDay.getText().toString(),
                        holder.mTempEve.getText().toString(), holder.mTempNight.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, mActivity.get().getString(R.string.share));
                mActivity.get().startActivity(intent);
            }
        });
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
        @BindView(R.id.week_day)
        TextView mWeekDay;
        @BindView(R.id.share)
        TextView mShare;

        public WeekWeatherHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(MainWeather weekMain, int position) {
            String path = FileManager.ICON_PATH + String.format("%s.png", weekMain.getIcon());
            Picasso.with(mActivity.get())
                    .load(path)
                    .into(mWeatherIcon);
            mTempMorn.setText(mActivity.get().getString(R.string.temp_morn, (int) (weekMain.getTempMorn() - 273)));
            mTempDay.setText(mActivity.get().getString(R.string.temp_day, (int) (weekMain.getTempDay() - 273)));
            mTempEve.setText(mActivity.get().getString(R.string.temp_eve, (int) (weekMain.getTempEve() - 273)));
            mTempNight.setText(mActivity.get().getString(R.string.temp_night, (int) (weekMain.getTempNight() - 273)));
            mPressure.setText(mActivity.get().getString(R.string.pressure, (int) weekMain.getPressure()));
            mHumidity.setText(mActivity.get().getString(R.string.humidity, (int) weekMain.getHumidity()));
            mWeekDay.setText(mWeekDays.get(position));
        }
    }
}
