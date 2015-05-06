package com.example.skinani.reachsafe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by skinani on 4/17/2015.
 */
public class Event extends Activity {


    TextView txtLat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
        txtLat = (TextView) findViewById(R.id.textView1);
        Button cr = (Button) findViewById(R.id.createev);
        Button se = (Button) findViewById(R.id.send);
        cr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.createev:
                        startActivity(new Intent(Event.this, gps2.class));
                        break;
                    case R.id.send:
                        break;
                }

            }

        });
        se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.createev:
                         break;
                    case R.id.send:

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("9769505168", null, "Please help me.", null, null);
                        Toast.makeText(Event.this, "Sms has been sent", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }


}









