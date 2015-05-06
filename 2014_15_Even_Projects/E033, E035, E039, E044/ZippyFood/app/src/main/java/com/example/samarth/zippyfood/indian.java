package com.example.samarth.zippyfood;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class indian extends ActionBarActivity {

Button button11;
Button button12;
Button button37;
    Button button39;
Button button43;
    Button button44;
    Button button40;
    Button button102;
    Button button103;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian);

        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), sabsh.class);
                startActivityForResult(intent, 0);
            }

        });
        button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), pnssh.class);
                startActivityForResult(intent, 0);
            }

        });
        button37 = (Button) findViewById(R.id.button37);
        button37.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(v.getContext(), sabko.class);
                                            startActivityForResult(intent, 0);
                                        }
                                    });
            button39 = (Button) findViewById(R.id.button39);
            button39.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), chickar.class);
                    startActivityForResult(intent, 0);
                }

            });

        button43 = (Button) findViewById(R.id.button43);
        button43.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), saagmeat.class);
                startActivityForResult(intent, 0);
            }

        });
        button103 = (Button) findViewById(R.id.button103);
        button103.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), malaikofta.class);
                startActivityForResult(intent, 0);
            }

        });

        button102 = (Button) findViewById(R.id.button102);
        button102.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ccwh.class);
                startActivityForResult(intent, 0);
            }

        });
        button44 = (Button) findViewById(R.id.button44);
        button44.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chicmal.class);
                startActivityForResult(intent, 0);
            }

        });
        button40 = (Button) findViewById(R.id.button40);
        button40.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), mutdopya.class);
                startActivityForResult(intent, 0);
            }

        });

    }
}


