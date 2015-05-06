package com.example.shon.safet;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;


public class LocationSample extends Activity {

    String str;
    TextView tv;
    Geocoder g;
    String address;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);
       // tv = (TextView) this.findViewById(R.id.txtLocation);
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener ll = new mylocationlistener();
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);
        g = new Geocoder(this, Locale.getDefault());


    }

    class mylocationlistener implements LocationListener {


        public void onLocationChanged(Location location) {

            Intent loc = new Intent(getApplicationContext(), firstpage.class);
                        Date today = new Date();
            Timestamp currentTimeStamp = new Timestamp(today.getTime());
            try {
                address = g.getFromLocation(location.getLatitude(), location.getLongitude(), 1).get(0).getAddressLine(0);
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "geocoder not in service", Toast.LENGTH_LONG).show();
            }
            if (location != null) {
                Log.d("LOCATION CHANGED", location.getLatitude() + "");
                Log.d("LOCATION CHANGED", location.getLongitude() + "");
                str = "\n CurrentLocation: " +
                        "\n Latitude: " + location.getLatitude() +
                        "\n Longitude: " + location.getLongitude() +
                        "\n Accuracy: " + location.getAccuracy() +
                        "\n CurrentTimeStamp " + currentTimeStamp +
                        "\n ADDRESS " + address;


                loc.putExtra(str,"key");
                startActivity(loc);


            } else {
                Toast.makeText(getApplicationContext(), "Location Unavailabe", Toast.LENGTH_LONG).show();
                str="Location Unavailable";
                loc.putExtra(str,"key");
                startActivity(loc);

            }

            Toast.makeText(LocationSample.this, str, Toast.LENGTH_SHORT).show();
             }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(LocationSample.this, "Turn  ON GPS", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(LocationSample.this, "SEARCHING...", Toast.LENGTH_LONG).show();
        }


        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Toast.makeText(LocationSample.this, "onStatusChanged", Toast.LENGTH_LONG).show();
        }
    }

}
