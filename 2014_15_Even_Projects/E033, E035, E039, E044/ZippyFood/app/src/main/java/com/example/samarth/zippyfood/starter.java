package com.example.samarth.zippyfood;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class starter extends ActionBarActivity {
Button button90;
    Button button91;
    Button button92;
    Button button93;
Button button113;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        button90 = (Button) findViewById(R.id.button90);
        button90.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), pbp.class);
                startActivityForResult(intent, 0);
            }
        });

        button91 = (Button) findViewById(R.id.button91);
        button91.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cbm.class);
                startActivityForResult(intent, 0);
            }
        });

        button92 = (Button) findViewById(R.id.button92);
        button92.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chickmomos.class);
                startActivityForResult(intent, 0);
            }
        });




        button113 = (Button) findViewById(R.id.button113);
        button113.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), springroll.class);
                startActivityForResult(intent, 0);
            }
        });
    }
    }


