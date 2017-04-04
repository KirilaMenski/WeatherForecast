package com.ultimateguitar.weatherforecast.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by kirila on 4.4.17.
 */

public class FragmentUtil {

    public static void replaceFragment(FragmentActivity activity, int containerId, Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(containerId, fragment);
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    static public void replaceAnimFragment(FragmentActivity activity, int containerId, Fragment fragment, boolean addToBackStack, int animStart, int animEnd) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        ft.setCustomAnimations(R.anim.right_out, R.anim.left_out);
        ft.setCustomAnimations(animStart, animEnd);
        ft.replace(containerId, fragment);
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

}
