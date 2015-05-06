package com.example.samarth.zippyfood;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class chinese extends ActionBarActivity {
    Button button9;
    Button button53;
    Button button54;
    Button button55;
    Button button56;
    Button button83;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);


        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chowmein.class);
                startActivityForResult(intent, 0);

            }

        });
        button53 = (Button) findViewById(R.id.button53);
        button53.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), vegmanch.class);
                startActivityForResult(intent, 0);

            }

        });
        button54 = (Button) findViewById(R.id.button54);
        button54.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), vegrice.class);
                startActivityForResult(intent, 0);

            }

        });
        button55 = (Button) findViewById(R.id.button55);
        button55.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chillychic.class);
                startActivityForResult(intent, 0);

            }

        });
        button56 = (Button) findViewById(R.id.button56);
        button56.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chicchow.class);
                startActivityForResult(intent, 0);

            }

        });
        button83 = (Button) findViewById(R.id.button83);
        button83.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), thai.class);
                startActivityForResult(intent, 0);

            }

        });
    }
}