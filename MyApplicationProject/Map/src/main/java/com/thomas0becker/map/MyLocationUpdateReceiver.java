package com.thomas0becker.map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;

/**
 * Created by thomas0becker on 29/05/13.
 */
public class MyLocationUpdateReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        String key = LocationManager.KEY_LOCATION_CHANGED;
        Location location = (Location)intent.getExtras().get(key);

    }
}
