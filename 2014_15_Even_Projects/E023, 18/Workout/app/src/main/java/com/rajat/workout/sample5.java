package com.rajat.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class sample5 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample5);
    }
    public void e2(View view) {



        Intent qb = new Intent(getApplicationContext(), sample9.class);
        startActivity(qb);
    }
}