package com.ultimateguitar.weatherforecast;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by kirila on 4.4.17.
 */

public class WeatherForecastApp extends MultiDexApplication {

    private static Context sContext;

    public void onCreate() {
        super.onCreate();
        sContext = this;
//        WFPreference.init(sContext);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getAppContext() {
        return sContext;
    }
}

