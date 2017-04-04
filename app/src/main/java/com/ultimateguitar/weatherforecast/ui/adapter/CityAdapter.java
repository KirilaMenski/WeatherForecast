package com.ultimateguitar.weatherforecast.ui.adapter;

import com.ultimateguitar.weatherforecast.database.entity.City;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import by.ultimateguitar.weatherforecast.R;

/**
 * Created by kirila on 4.4.17.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityHolder> implements Filterable {

    private final int LAYOUT = R.layout.item_city;

    private List<City> mCities;
    private List<City> mCitiesCopy;
    private WeakReference<Activity> mActivity;
    private WeakReference<CityListener> mListener;

    public CityAdapter(List<City> cities, Activity activity) {
        mCities = cities;
        mCitiesCopy = cities;
        mActivity = new WeakReference<>(activity);
    }

    @Override
    public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity.get());
        View view = inflater.inflate(LAYOUT, parent, false);
        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(CityHolder holder, int position) {
        final City city = mCities.get(position);
        holder.bindView(city.getName());
        holder.mCityLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.get().citySelected(city);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<City> filteredResult;
                if (charSequence.length() == 0) {
                    filteredResult = mCitiesCopy;
                } else {
                    filteredResult = getFilteredResults(charSequence.toString().toLowerCase());
                }

                FilterResults results = new FilterResults();
                results.values = filteredResult;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mCities = (List<City>) filterResults.values;
                CityAdapter.this.notifyDataSetChanged();
            }
        };
    }

    private List<City> getFilteredResults(String constraint) {
        List<City> cities = new ArrayList<>();
        for (City city : mCitiesCopy) {
            if (city.getName().toLowerCase().contains(constraint)) {
                cities.add(city);
            }
        }
        return cities;
    }

    public class CityHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.city)
        TextView mNameCity;
        @BindView(R.id.city_item)
        LinearLayout mCityLl;

        public CityHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(String name) {
            mNameCity.setText(name);
        }

    }

    public void setListener(CityListener listener) {
        mListener = new WeakReference<>(listener);
    }

    public interface CityListener {
        void citySelected(City city);
    }

}
