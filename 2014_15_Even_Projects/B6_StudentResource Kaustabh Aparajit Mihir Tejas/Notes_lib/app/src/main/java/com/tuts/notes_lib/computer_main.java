package com.tuts.notes_lib;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by KAUSTABH on 25-02-2015.
 */
public class computer_main  extends ActionBarActivity {
    SQLiteDatabase db;
    Button b1,b2,b3,b4,b5;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computeractivity);
b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
tv=(TextView)findViewById(R.id.tv1);

     Intent i1= getIntent();

       String gota= i1.getStringExtra("DEPT");
        tv.append(gota);
        db = openOrCreateDatabase("Notes.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
       // getSupportActionBar().setTitle("Computer");

        Cursor cr=db.query("Course1",null,null,null,null,null,null,null);
        cr.moveToFirst();
       // String[] year=new String[5];
       // int i=0;
        while(cr.isAfterLast()==false)
        {
            tv.append(gota);
            String a=cr.getString(0);
            tv.append(a);
           // if(a.toLowerCase().toString().equals(gota.toLowerCase().toString()))
            //year[i]=cr.getString(1);
            //i++;

        }
/*b1.setText(year[0]);
        b2.setText(year[1]);
        b3.setText(year[3]);
        b4.setText(year[4]);*/
    }

}
