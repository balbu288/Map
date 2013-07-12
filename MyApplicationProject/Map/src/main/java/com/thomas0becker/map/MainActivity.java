package com.thomas0becker.map;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locationManager;
        String svcName = Context.LOCATION_SERVICE;
        locationManager = (LocationManager)getSystemService(svcName);

        String provider = LocationManager.GPS_PROVIDER;

        int t = 5000;
        int distance = 5;

        final int locationUpdateRC = 0;

        Intent intent = new Intent(this, MyLocationUpdateReceiver.class);
        PendingIntent pendingIntent;
        pendingIntent = pendingIntent.getBroadcast(this, locationUpdateRC, intent, flags);

        Location l;
        l = locationManager.getLastKnownLocation(provider, t, distance, pendingIntent);

        updateWithNewLocation(l);
    }

    private void updateWithNewLocation(Location location){
        TextView myLocationText;
        myLocationText = (TextView)findViewById(R.id.myLocationText);

        String latLongString = "aucun emplacement trouvé";
        if(location != null){
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            double alt = location.getAltitude();
            latLongString = "Lat : " + lat + "\nLongitude : " + lng + "\nAltitude : " + alt;
        }
        myLocationText.setText("Votre position courrante est\n" + latLongString);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
