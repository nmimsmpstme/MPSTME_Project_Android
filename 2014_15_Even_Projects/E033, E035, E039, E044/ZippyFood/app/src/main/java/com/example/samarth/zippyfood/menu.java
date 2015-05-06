package com.example.samarth.zippyfood;

import android.app.NotificationManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;

import android.app.Application;

public class menu extends ActionBarActivity
{
    Button button9;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button57;
    Button button70;
    Button button80;
    Button button87;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
// Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "Qcv6wTZoErAluXdWgAfMnWVthvomc4ZhBtQoJnIj", "d7ec8XdC3fhxTimLK1ne9lECY65ENtJ9XV1ZQ3fw");


        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int ID= getIntent().getIntExtra("ID",8);
        nm.cancel(ID);
        ParseInstallation.getCurrentInstallation().saveInBackground();

                button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), drinks.class);
                startActivityForResult(intent, 0);

            }

        });
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), starter.class);
                startActivityForResult(intent, 0);

            }

        });
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), maincourse.class);
                startActivityForResult(intent, 0);

            }

        });
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), desserts.class);
                startActivityForResult(intent, 0);

            }

        });


        button70 = (Button) findViewById(R.id.button70);
        button70.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), rice.class);
                startActivityForResult(intent, 0);

            }

        });
        button80 = (Button) findViewById(R.id.button80);
        button80.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), breads.class);
                startActivityForResult(intent, 0);

            }

        });
        button87 = (Button) findViewById(R.id.button87);
        button87.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), salads.class);
                startActivityForResult(intent, 0);

            }

        });


    }

          }

