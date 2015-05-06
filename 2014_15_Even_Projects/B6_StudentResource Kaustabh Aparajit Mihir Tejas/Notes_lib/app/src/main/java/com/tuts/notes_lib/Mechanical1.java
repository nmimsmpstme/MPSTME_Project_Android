package com.tuts.notes_lib;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class Mechanical1  extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical1);

        getIntent();
        getSupportActionBar().setTitle("Mechanical");

    }

}