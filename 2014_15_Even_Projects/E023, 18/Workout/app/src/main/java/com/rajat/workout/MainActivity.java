package com.rajat.workout;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void e4(View view) {



        Intent ab = new Intent(getApplicationContext(), sample2.class);
        startActivity(ab);
    }

    public void e1(View view)
    {





        Intent bc = new Intent(getApplicationContext(), sample3.class);
        startActivity(bc);



    }


    public void e2(View view) {



        Intent qb = new Intent(getApplicationContext(), sample4.class);
        startActivity(qb);
    }

    public void e3(View view) {



        Intent bh = new Intent(getApplicationContext(), sample5.class);
        startActivity(bh);
    }

}