package com.example.samarth.zippyfood;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class italian extends ActionBarActivity {

    Button button88;
    Button button89;
    Button button94;
    Button button95;
    Button button96;
    Button button97;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian);
        button88 = (Button) findViewById(R.id.button88);
        button88.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), brush.class);
                startActivityForResult(intent, 0);

            }

        });
        button89 = (Button) findViewById(R.id.button89);
        button89.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), calzone.class);
                startActivityForResult(intent, 0);

            }

        });
        button94 = (Button) findViewById(R.id.button94);
        button94.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cbd.class);
                startActivityForResult(intent, 0);

            }

        });
        button95 = (Button) findViewById(R.id.button95);
        button95.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chicpasta.class);
                startActivityForResult(intent, 0);

            }

        });

        button96 = (Button) findViewById(R.id.button96);
        button96.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chicspa.class);
                startActivityForResult(intent, 0);

            }

        });
        button97 = (Button) findViewById(R.id.button97);
        button97.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), rcp.class);
                startActivityForResult(intent, 0);

            }

        });
    }
}
