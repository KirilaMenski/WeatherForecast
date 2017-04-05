package com.ultimateguitar.weatherforecast.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by kirila on 5.4.17.
 */

public class DateUtil {

    private static final String DATE_FORMAT = "dd MMM yyyy kk:mm";

    public static String getDate(){
        String date;
        Calendar calendar = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.UK);
        date = format.format(calendar.getTime());
        return date;
    }

}
