package com.rajat.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class sample3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample3);
    }
    public void e2(View view) {



        Intent qb = new Intent(getApplicationContext(), sample7.class);
        startActivity(qb);
    }
}