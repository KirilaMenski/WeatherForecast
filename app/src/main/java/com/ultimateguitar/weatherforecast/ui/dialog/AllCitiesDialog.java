package com.ultimateguitar.weatherforecast.ui.dialog;

import com.ultimateguitar.weatherforecast.database.entity.City;
import com.ultimateguitar.weatherforecast.ui.adapter.CityAdapter;
import com.ultimateguitar.weatherforecast.ui.mvp.BaseDialog;
import com.ultimateguitar.weatherforecast.ui.mvp.BasePresenter;
import com.ultimateguitar.weatherforecast.ui.presenter.AllCitiesDialogPresenter;
import com.ultimateguitar.weatherforecast.ui.view.AllCitiesDialogView;

import java.lang.ref.WeakReference;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import by.ultimateguitar.weatherforecast.R;

/**
 * Created by kirila on 4.4.17.
 */

public class AllCitiesDialog extends BaseDialog implements AllCitiesDialogView, CityAdapter.CityListener {

    private final int LAYOUT = R.layout.dialog_all_cities;

    private AllCitiesDialogPresenter mPresenter;
    private Dialog mDialog;
    private WeakReference<DialogListener> mListener;
    private CityAdapter mCityAdapter;

    @BindView(R.id.cancel)
    TextView mCancel;
    @BindView(R.id.search)
    EditText mSearchEt;
    @BindView(R.id.cities_recycler)
    RecyclerView mCitiesRecycler;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mPresenter.getAllCities();
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(LAYOUT, null);
        ButterKnife.bind(this, view);
        mDialog = new AlertDialog.Builder(getActivity()).setView(view).create();
        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    mDialog.dismiss();
                }
                return true;
            }
        });
        mDialog.setCanceledOnTouchOutside(false);
        return mDialog;
    }

    @Override
    public void onResume() {
        super.onResume();
//        mPresenter.getAllCities();
        mHandler.post(mRunnable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mRunnable);
    }

    @OnClick(R.id.cancel)
    public void cancel() {
        mDialog.dismiss();
    }

    @OnTextChanged(R.id.search)
    public void onTextChanged() {
        if (mSearchEt.length() > 0) {
            mCityAdapter.getFilter().filter(mSearchEt.getText().toString());
        } else {
//            mPresenter.getAllCities();
            mHandler.post(mRunnable);
        }
    }

    public void setListener(DialogListener listener) {
        mListener = new WeakReference<>(listener);
    }

    @Override
    public void onPause() {
        mDialog.dismiss();
        super.onPause();
    }

    @Override
    public BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new AllCitiesDialogPresenter(this);
    }

    @Override
    public void updateCityRecycler(List<City> cities) {
//        Collections.sort(cities, new City());
        mCityAdapter = new CityAdapter(cities, getActivity());
        mCityAdapter.setListener(this);
        mCitiesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mCitiesRecycler.setAdapter(mCityAdapter);
        mCitiesRecycler.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void updateViewsVisible(boolean vis) {
        mCitiesRecycler.setVisibility(vis ? View.GONE : View.VISIBLE);
        mProgressBar.setVisibility(vis ? View.VISIBLE : View.GONE);
    }

    @Override
    public void citySelected(City city) {
        mListener.get().citySelectedFromDialog(city);
        mDialog.dismiss();
    }

    public interface DialogListener {
        void citySelectedFromDialog(City city);
    }

}
