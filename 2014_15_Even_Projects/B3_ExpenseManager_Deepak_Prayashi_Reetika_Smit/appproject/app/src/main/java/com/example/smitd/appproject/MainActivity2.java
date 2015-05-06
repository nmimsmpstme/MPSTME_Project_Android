package com.example.smitd.appproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends ActionBarActivity {

    Spinner s1;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        Intent in=getIntent();
        TextView t1=(TextView)findViewById(R.id.label);
        s1=(Spinner)findViewById(R.id.category);
        String balance=in.getStringExtra("secpg");
        t1.setText(balance);

        TextView t2=(TextView)findViewById(R.id.text);
        et1=(EditText)findViewById(R.id.et);
        Button b2=(Button)findViewById(R.id.view);
  b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int w[];
        String s;
        int sum=0;
        if(s1.getSelectedItemPosition()==0) {
            w = Config.getf();
            s = "Food\n";
            for (int m = 0; m < w.length; m++) {
                s += "\n" + w[m];
                sum +=w[m];
            }
            TextView t=(TextView)findViewById(R.id.tv);
            t.setText(s+"\nSum: "+sum);
        }
        if(s1.getSelectedItemPosition()==1) {
            w = Config.getd();
            s = "Drink\n";
            for (int m = 0; m < w.length; m++) {
                s += "\n" + w[m];
                sum +=w[m];
            }
            TextView t=(TextView)findViewById(R.id.tv);
            t.setText(s+"\nSum: "+sum);
        }
        if(s1.getSelectedItemPosition()==2) {
            w = Config.getfu();
            s = "Fuel\n";
            for (int m = 0; m < w.length; m++) {
                s += "\n" + w[m];
                sum +=w[m];
            }
            TextView t=(TextView)findViewById(R.id.tv);
            t.setText(s+"\nSum: "+sum);
        }
        if(s1.getSelectedItemPosition()==3) {
            w = Config.geth();
            s = "Hotel\n";
            for (int m = 0; m < w.length; m++) {
                s += "\n" + w[m];
                sum +=w[m];
            }
            TextView t=(TextView)findViewById(R.id.tv);
            t.setText(s+"\nSum: "+sum);
        }
        /*if(s1.getSelectedItemPosition()==0) {
            s = "Merchandise\n";
        }
        if(s1.getSelectedItemPosition()==0) {
            s = "Others\n";
        }*/



    }
});

        Button b3=(Button)findViewById(R.id.clear);
b3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(s1.getSelectedItemPosition()==0)
        {Config.clearf();
        int[] w = Config.getf();
        int sum=0;
        String s = "Food\n";
        for (int m = 0; m < w.length; m++) {
            s += "\n" + w[m];
            sum +=w[m];
        }
        TextView t=(TextView)findViewById(R.id.tv);
        t.setText(s+"\nSum: "+sum);

    }
    if(s1.getSelectedItemPosition()==1)
    {Config.clearf();
        int[] w = Config.getd();
        int sum=0;
        String s = "Drink\n";
        for (int m = 0; m < w.length; m++) {
            s += "\n" + w[m];
            sum +=w[m];
        }
        TextView t=(TextView)findViewById(R.id.tv);
        t.setText(s+"\nSum: "+sum);

    }
        if(s1.getSelectedItemPosition()==2)
        {Config.clearf();
            int[] w = Config.getfu();
            int sum=0;
            String s = "Fuel\n";
            for (int m = 0; m < w.length; m++) {
                s += "\n" + w[m];
                sum +=w[m];
            }
            TextView t=(TextView)findViewById(R.id.tv);
            t.setText(s+"\nSum: "+sum);

        }
        if(s1.getSelectedItemPosition()==3)
        {Config.clearf();
            int[] w = Config.geth();
            int sum=0;
            String s = "Hotel\n";
            for (int m = 0; m < w.length; m++) {
                s += "\n" + w[m];
                sum +=w[m];
            }
            TextView t=(TextView)findViewById(R.id.tv);
            t.setText(s+"\nSum: "+sum);

        }}


});
        Button b1=(Button)findViewById(R.id.save);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int x= Integer.parseInt(et1.getText().toString());
                int w[];
                int sum;
                String s;
               if(s1.getSelectedItemPosition()==0) {
                   Config.addf(x);
                   w = Config.getf();
                   sum=0;
                   s = "Food\n";
                   for (int m = 0; m < w.length; m++) {
                       s += "\n" + w[m];
                       sum +=w[m];
                   }TextView t=(TextView)findViewById(R.id.tv);
                   t.setText(s+"\nSum: "+sum);}
                   if(s1.getSelectedItemPosition()==1) {
                       Config.addd(x);
                       w = Config.getd();
                       sum=0;
                       s = "Drink\n";
                       for (int m = 0; m < w.length; m++) {
                           s += "\n" + w[m];
                           sum +=w[m];
                       }TextView t=(TextView)findViewById(R.id.tv);
                       t.setText(s+"\nSum: "+sum);}
                   if(s1.getSelectedItemPosition()==2) {
                           Config.addfu(x);
                           w = Config.getfu();
                           sum=0;
                           s = "Fuel\n";
                           for (int m = 0; m < w.length; m++) {
                               s += "\n" + w[m];
                               sum +=w[m];
                        }TextView t=(TextView)findViewById(R.id.tv);
                       t.setText(s+"\nSum: "+sum);}
                   if(s1.getSelectedItemPosition()==3) {
                           Config.addh(x);
                           w = Config.geth();
                           sum=0;
                           s = "Hotel\n";
                           for (int m = 0; m < w.length; m++) {
                               s += "\n" + w[m];
                               sum +=w[m];
                           }TextView t=(TextView)findViewById(R.id.tv);
                       t.setText(s+"\nSum: "+sum);}
                   //Toast.makeText(MainActivity2.this, "" + s, Toast.LENGTH_LONG).show();
               }
                //Toast.makeText(MainActivity2.this, "You entered "+x+" You're screwed!!!", Toast.LENGTH_LONG).show();

        });
    }
}