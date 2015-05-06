package com.example.samarth.zippyfood;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseObject;


public class rice extends ActionBarActivity {
    Button button58;
    Button button59;
    Button button60;
    Button button61;
    Button button62;
    Button button63;
    Button button64;
    Button button65;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice);
        button58 = (Button) findViewById(R.id.button58);
        button58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "CHICKEN BIRYANI");

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        button59 = (Button) findViewById(R.id.button59);
        button59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "MUTTON BIRYANI");

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        button60 = (Button) findViewById(R.id.button60);
        button60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "VEG BIRAYANI");

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        button61 = (Button) findViewById(R.id.button61);
        button61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "PEAS PULAO");

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        button62 = (Button) findViewById(R.id.button62);
        button62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "MUSHROOM RICE");

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        button63 = (Button) findViewById(R.id.button63);
        button63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "RASINS AND NUTS PULAO");

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();

            }
        });
        button64 = (Button) findViewById(R.id.button64);
        button64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "JEERA PULAO");

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        button65 = (Button) findViewById(R.id.button65);
        button65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("Table", "Table 1");
                testObject.put("Order", "PLAIN BASMATI RICE");

                Toast myToast = Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

    }
}




