package com.example.srija.dietplanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class DINNER extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
        TextView tv;
        tv=(TextView)this.findViewById(R.id.din);
        Intent i3=getIntent();
        final String bmi;
        bmi=i3.getExtras().getString("BMI");

        String O="Light nachos\n" +
                "Fresh herbs and condiments in food\n" +
                "Protein form of fish or white meat.\n" +
                "Citrus fruits.\n" +
                "Roasted vegetables\n" +
                "Wheat bread \n" +
                "Green beans and sesame oil.\n" +
                "Fresh corn.\n" +
                "Egg white only.\n";
        String N="Vegetable gnocchi \n" +
                "Chicken couscous or simple chicken dishes. \n" +
                "large jacket potato \n" +
                "Omelette  3 eggs. \n" +
                "skimmed milk and salad\n "+
                "\n";

        String U="\n" +
                "Fruit juice \n" +
                "Meat or fish or cheese or eggs \n" +
                "Vegetable or salad with dressing \n" +
                "Starch \n" +
                "Pudding with ice cream.\n" +
                "coffee or tea.\n" +
                "\n" +
                "\n" +
                "Milk drink (1 cup of Milo or Ovaltine made with full-cream milk) Biscuits (2-3 biscuits)";


        if(bmi.compareToIgnoreCase("UNDERWEIGHT")==0)
        {
            tv.setText(U);
            Toast.makeText(getApplicationContext(), "DRINK LOTS OF WATER TOO!!!", Toast.LENGTH_SHORT).show();

        }
        else if(bmi.compareToIgnoreCase("NORMAL")==0)
        {
            tv.setText(N);
            Toast.makeText(getApplicationContext(), "DRINK LOTS OF WATER TOO!!!", Toast.LENGTH_SHORT).show();
        }

        else if((bmi.compareToIgnoreCase("OVERWEIGHT")==0)||(bmi.compareToIgnoreCase("OBESE")==0))
        {
            tv.setText(O);
            Toast.makeText(getApplicationContext(), "DRINK LOTS OF WATER TOO!!!", Toast.LENGTH_SHORT).show();
        }





    }




}
