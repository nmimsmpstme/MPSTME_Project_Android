package com.example.srija.dietplanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class LUNCH extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        TextView tv;
        tv=(TextView)this.findViewById(R.id.lnc);
        Intent i2=getIntent();
        final String bmi;
        bmi=i2.getExtras().getString("BMI");

        String O="green salad\n" +
                "protein form like eggs,soyabean,chicken.\n" +
                "sandwich on whole-grain bread, brown rice or pasta with vegetables.\n" +
                "Grilled or steamed potatoes \n" +
                "Add ginger, cayenne pepper, turmeric or mustard to meals to boost metabolism.";
        String N=" fresh minestrone soup with 1 small wholemeal roll. \n" +
                "Salad \n" +
                "wholemeal pitta bread with half a 200g tub tzatziki, crudités and 1 nectarine. \n" +
                "small wholemeal roll filled with 2tsp low-fat spread\n" +
                "oat crackers with 2tbsp low-fat soft cheese and salad\n" +
                "Ready made sandwich, wrap, roll or salad\n" +
                "apple,fruit salad or fat free yoghurt\n" +
                "\n";
        String U="\n" +
                "Soup \n" +
                "Meat, fish or poultry \n" +
                "Potato \n" +
                "Vegetable or salad with dressing \n" +
                "Pudding \n" +
                "Roll with butter and cheese \n" +
                "Pasta or bread with a little high sugar content\n "+
                "Beverage (1 cup of coffee or tea with full-cream milk and 2 t of sugar)\n";


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
