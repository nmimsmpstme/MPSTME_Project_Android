package com.example.aashya.thereadingroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by aashya on 27/03/15.
 */
public class american1 extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.american1);




        Button a = (Button) findViewById(R.id.about2);

        a.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                Intent intent1 = new Intent(american1.this, american2.class);
                startActivity(intent1);
            }
        });

        Button b = (Button) findViewById(R.id.contact2);

        b.setOnClickListener(new View.OnClickListener()

                             {
                                 public void onClick(View v) {

                                     Intent intent1 = new Intent(american1.this, american3.class);
                                     startActivity(intent1);
                                 }
                             }

        );


    }
}



