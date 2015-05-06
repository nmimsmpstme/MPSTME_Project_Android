package com.example.srija.dietplanner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.database.sqlite.*;
import android.content.ContentValues;
import java.util.Locale;
public class BMI_CALCULATOR extends ActionBarActivity {
    EditText e1,e2,e3;
    TextView t1,t2;
    Button b1;
    SQLiteDatabase db;
       String temp1,temp2;
    float ans;


    float height=0,weight=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__calculator);

        e1 = (EditText) findViewById(R.id.etxtheight);
        e2 = (EditText) findViewById(R.id.etxtweight);
        e3 = (EditText) findViewById(R.id.etxt);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.txtview2);

        b1 = (Button) findViewById(R.id.btncalc);
        db = openOrCreateDatabase("test.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.execSQL(
                "create table if not exists USER_DETAILS " +
                        "( height,weight,BMI)"
        );

        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        temp1 = e1.getText().toString();
                        temp2 = e2.getText().toString();

                        height = Float.parseFloat(temp1);
                        height = height / 100;
                        weight = Float.parseFloat(temp2);

                        ans  = ((weight) / (height * height));
                    String temp = Float.toString(ans);

                    t1.setText(temp);
                    String e = e3.getText().toString();
                    if (e.compareToIgnoreCase("M") == 0) {
                        if (ans > 31.1) {
                            t2.setText("OBESE");
                        } else if ((ans > 26.4) && (ans <= 31.1)) {
                            t2.setText("OVERWEIGHT");
                        } else if ((ans > 20.7) && (ans <= 26.4)) {
                            t2.setText("NORMAL");
                        } else {
                            t2.setText("UNDERWEIGHT");
                        }
                    } else if (e.compareToIgnoreCase("F") == 0) {
                        if (ans > 32.3) {
                            t2.setText("OBESE");

                        } else if ((ans > 25.8) && (ans <= 32.3)) {
                            t2.setText("OVERWEIGHT");
                        } else if ((ans > 19.1) && (ans <= 25.8)) {
                            t2.setText("NORMAL");
                        } else {
                            t2.setText("UNDERWEIGHT");
                        }
                    } else {
                        t2.setText("invalid entry");
                    }

                    Toast.makeText(getApplicationContext(), "PRESS NEXT FOR BMR", Toast.LENGTH_SHORT).show();



            }
        });


        Button btnnext = (Button) findViewById(R.id.btn2);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent i = new Intent(getApplicationContext(), BMR_CALCULATOR.class);

                    i.putExtra("BMI", t2.getText().toString());
                    i.putExtra("HEIGHT", e1.getText().toString());
                    i.putExtra("WEIGHT", e2.getText().toString());
                    i.putExtra("GENDER", e3.getText().toString());
                    startActivity(i);
                    insert(v);
                }



        });
    }


    void insert(View v)
    {

        db=openOrCreateDatabase("test.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        ContentValues cv=new ContentValues();
        cv.put("height", (height*100));
        cv.put("weight", weight);
        cv.put("BMI", ans);
        long a= db.insert("USER_DETAILS", null, cv);
        db.close();
        if(a!=0)
        {
          //  Toast.makeText(this,"inserted",Toast.LENGTH_SHORT).show();


        }

        else
        {
            Toast.makeText(this,"Error occured",Toast.LENGTH_SHORT).show();
        }


    }

    void Selectdata(View v)
    {


        //up();
    }






    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_bmi__calculator, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {

            Intent nt=new Intent(getApplicationContext(),PREV_DATA.class);

            startActivity(nt);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


