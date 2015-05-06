package com.example.shon.safet;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;


public class firstpage extends ActionBarActivity implements LocationListener {

    String p1, p2, p3;
    SQLiteDatabase db;
    Context ctx = this;
    public Button smsViewBtn;
    public Button test;
    Geocoder g;
    boolean flag=false;
    Location l;
    String str;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_firstpage);

        db = openOrCreateDatabase("test1.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.execSQL(
                "create table if not exists CONTACT " +
                        "( p1 text,p2 text,p3 text)"
        );

        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);


        smsViewBtn = (Button) findViewById(R.id.smsVIntent);
        test = (Button) findViewById(R.id.test);


        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String message="I'm IN DANGER";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(p2, null, message, null, null);
                smsManager.sendTextMessage(p2, null, message, null, null);
                smsManager.sendTextMessage(p3, null, message, null, null);
                Toast.makeText(getApplicationContext(), "Message SENT WITHOUT Location", Toast.LENGTH_LONG).show();
            }
        });


        smsViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, firstpage.this);

                g = new Geocoder(getApplicationContext(), Locale.getDefault());

                Selectdata(view);
            }

    });}

    void Selectdata(View view) {


        up();
    }

    void up() {
        db = openOrCreateDatabase("test1.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        Cursor cr = db.query("CONTACT", null, null, null, null, null, null, null);
        cr.moveToFirst();

        while (cr.isAfterLast() == false) {
            p1 = cr.getString(0);
            p2 = cr.getString(1);
            p3 = cr.getString(2);
            cr.moveToNext();

        }
        cr.close();
        db.close();
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_firstpage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Intent intent1 = new Intent(getApplicationContext(), contact.class);
            startActivity(intent1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void onLocationChanged(Location location) {
      l=location;

        try {
            if (l != null && flag==false)
            {       Date today = new Date();
                Timestamp currentTimeStamp = new Timestamp(today.getTime());
                Log.d("LOCATION CHANGED", location.getLatitude() + "");
                Log.d("LOCATION CHANGED", location.getLongitude() + "");
                str = "\n CurrentLocation: " +
                        "\n Latitude: " + location.getLatitude() +
                        "\n Longitude: " + location.getLongitude() +
                        "\n Accuracy: " + location.getAccuracy() +
                        "\n CurrentTimeStamp " + currentTimeStamp;
                address = g.getFromLocation(l.getLatitude(), l.getLongitude(), 1).get(0).getAddressLine(0);


                String message = "I'M IN DANGER!! " + address+str;


                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(p1, null, message, null, null);
                smsManager.sendTextMessage(p2, null, message, null, null);
                smsManager.sendTextMessage(p3, null, message, null, null);
                Toast.makeText(getApplicationContext(), "Message With Location", Toast.LENGTH_LONG).show();
                flag=true;

            }
            else
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();




        }
        catch(Exception e)
        {
           // Toast.makeText(getApplicationContext(),"geocoder error", Toast.LENGTH_LONG).show();
        }
    }




    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Turn  ON GPS", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(firstpage.this, "", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast.makeText(firstpage.this, "onStatusChanged", Toast.LENGTH_LONG).show();
    }



}
