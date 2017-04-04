package com.ultimateguitar.weatherforecast.ui.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by kirila on 4.4.17.
 */

public interface BaseContextView {

    Activity getActivity();

    Context getContext();

    void startActivity(Intent intent);

    void hideKeyBoard();

}
