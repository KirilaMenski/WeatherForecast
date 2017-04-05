package com.ultimateguitar.weatherforecast.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by kirila on 5.4.17.
 */

public class NetworkUtil {

    public static boolean isNetworkConnected(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}
