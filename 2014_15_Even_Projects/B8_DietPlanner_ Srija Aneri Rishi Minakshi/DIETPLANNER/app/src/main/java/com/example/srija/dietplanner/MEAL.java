package com.example.srija.dietplanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MEAL extends ActionBarActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        Intent j=getIntent();
      /*  String cal;
        cal=j.getExtras().getString("CALORIE");
        String cal1,cal2;
        cal1=j.getExtras().getString("CALORIE1");
        cal2=j.getExtras().getString("CALORIE2");*/
        final String bmi;
        bmi=j.getExtras().getString("BMI");
        final String gender;
        Toast.makeText(getApplicationContext(), "CHOOSE YOUR MEAL", Toast.LENGTH_SHORT).show();
        gender=j.getExtras().getString("GENDER");
        b1=(Button)findViewById(R.id.bbrk);
        b2=(Button)findViewById(R.id.btnlun);
        b3=(Button)findViewById(R.id.bdin);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i1=new Intent(getApplicationContext(),BREAKFAST.class);
                i1.putExtra("BMI",bmi);
                i1.putExtra("GENDER",gender);
                startActivity(i1);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent i2=new Intent(getApplicationContext(),LUNCH.class);
                                      i2.putExtra("BMI",bmi);
                                      i2.putExtra("GENDER",gender);
                                      startActivity(i2);

                                  }
                              }
        );
        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent i3=new Intent(getApplicationContext(),DINNER.class);
                                      i3.putExtra("BMI",bmi);
                                      i3.putExtra("GENDER",gender);
                                      startActivity(i3);

                                  }
                              }
        );






    }


}


