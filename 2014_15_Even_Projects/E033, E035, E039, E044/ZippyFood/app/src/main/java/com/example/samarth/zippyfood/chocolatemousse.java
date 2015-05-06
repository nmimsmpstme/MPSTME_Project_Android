package com.example.samarth.zippyfood;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseObject;


public class chocolatemousse extends ActionBarActivity {
Button button34;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocolatemousse);
        button34 = (Button) findViewById(R.id.button34);
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder notification = new NotificationCompat.Builder(chocolatemousse.this);
                notification.setSmallIcon(R.drawable.appicon);
                notification.setTicker("Thank You for placing the order");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("Your Order has been placed");
                notification.setContentText("Choose more food");
                notification.setVibrate(new long[]{1000,1000});
                notification.setLights(Color.BLUE,3000,3000);
                notification.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.appicon);
                notification.setLargeIcon(picture);

                PendingIntent myPendingIntent;
                Intent myIntent = new Intent();
                Context myContext = getApplicationContext();
                myIntent.setClass(myContext, menu.class );
                myIntent.putExtra("ID",12);
                myPendingIntent = PendingIntent.getActivity(myContext, 0, myIntent, 0);
                notification.setContentIntent(myPendingIntent);

                Notification n = notification.build();
                NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(12,n);


                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "CHOCOLATE MOUSSE");
                testObject.saveInBackground();

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();

            }
        });
    }



}





