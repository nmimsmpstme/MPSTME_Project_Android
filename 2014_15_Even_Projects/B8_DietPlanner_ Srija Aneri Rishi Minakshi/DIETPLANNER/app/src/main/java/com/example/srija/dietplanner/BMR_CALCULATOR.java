package com.example.srija.dietplanner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import static android.view.View.OnClickListener;


public class BMR_CALCULATOR extends ActionBarActivity {
    TextView t2;
    EditText t;
    String a;
    Button btn1;
    float ans1;
    float ans2;

    float height, weight;
    int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr__calculator);

        Intent i = getIntent();
        final String BMI;
        BMI = i.getExtras().getString("BMI");
        final String h;
        h = i.getExtras().getString("HEIGHT");
        height = Float.parseFloat(h);


        final String w;
        w = i.getExtras().getString("WEIGHT");
        weight = Float.parseFloat(w);
        final String gender;
        gender = i.getExtras().getString("GENDER");
        t = (EditText) findViewById(R.id.etxtage);
        t2 = (TextView) findViewById(R.id.txtv3);
        btn1 = (Button) findViewById(R.id.btnbmr);

        btn1.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {

                age = Integer.parseInt(t.getText().toString());
                if (gender.compareToIgnoreCase("M") == 0) {
                    ans1 = 1900;
                } else if (gender.compareToIgnoreCase("F") == 0) {
                    ans1 = 1900;
                }

                if (BMI.compareToIgnoreCase("NORMAL") == 0) {
                    a = Float.toString(ans1);
                    t2.setText(a);
                } else if (BMI.compareToIgnoreCase("OVERWEIGHT") == 0) {

                    ans2 = ans1 - 550;

                    a = Float.toString(ans2);

                    t2.setText(a);
                } else if (BMI.compareToIgnoreCase("OBESE") == 0) {
                    ans2 = ans1 - 550;

                    a = Float.toString(ans2);

                    t2.setText(a);
                } else if (BMI.compareToIgnoreCase("UNDERWEIGHT") == 0) {
                    if (gender.compareToIgnoreCase("F") == 0) {
                        ans1 = ans1 + 550;
                    } else if (gender.compareToIgnoreCase("M") == 0) {
                        ans1 = ans1 + 550;
                    }
                    a = Float.toString(ans1);
                    Toast.makeText(getApplicationContext(), "CHECK YOUR DIET", Toast.LENGTH_SHORT).show();
                    t2.setText(a);
                }


            }


        });
        Button btnnext1 = (Button) findViewById(R.id.btn3);
        btnnext1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MEAL.class);
                intent.putExtra("BMI", BMI);
                intent.putExtra("GENDER", gender);
                startActivity(intent);

            }
        });


    }

}

