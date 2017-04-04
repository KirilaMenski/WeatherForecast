package com.ultimateguitar.weatherforecast.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by kirila on 4.4.17.
 */
public class DisplayMetricsUtil {

    public static int getTypedValue(Context context, int size){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, context.getResources().getDisplayMetrics());
    }

}
