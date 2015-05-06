package com.example.srija.dietplanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class BREAKFAST extends ActionBarActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        tv=(TextView)this.findViewById(R.id.brk);
        Intent i1=getIntent();
        final String bmi;
        bmi=i1.getExtras().getString("BMI");

        String O="Oatmeal\n" +
                "Yoghurt\n" +
                "Peanut butter\n" +
                "Eggs\n" +
                "Fruits/fruit juice\n";

        String N="Berries:\n" +
                "cold cereal\n" +
                "eggs\n" +
                "green tea\n" +
                "whole grain breads with peanut butter\n" +
                "oatmeal\n" +
                "smoothies\n" +
                "yoghurt\n" +
                "\n" +
                "\n";


        String U=" Fruit or fruit juice \n" +
                "Cereal with milk and sugar \n" +
                "Boiled egg or bacon or sausage \n" +
                "Wholewheat toast or roll with butter and jam \n" +

                "\n" +
                "Morning tea:\n" +
                "\n" +
                "Milky drink \n" +
                "or\n" +
                "Smoothy \n" +
                "or\n" +
                "Fruit juice with snack \n";

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


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_breakfast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
