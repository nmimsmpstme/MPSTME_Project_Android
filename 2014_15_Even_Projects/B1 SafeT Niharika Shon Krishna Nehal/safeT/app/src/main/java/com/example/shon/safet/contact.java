package com.example.shon.safet;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;


public class contact extends ActionBarActivity {
    SQLiteDatabase db;
    public Button B;
    Context ctx=this;
    EditText phoneNumber1;
    EditText phoneNumber2;
    EditText phoneNumber3;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        db=openOrCreateDatabase("test1.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.execSQL(
                "create table if not exists CONTACT " +
                        "( p1 text,p2 text,p3 text)"
        );

        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);




        setContentView(R.layout.activity_contact);
        B = (Button) findViewById(R.id.Btn);

         phoneNumber1 = (EditText) findViewById(R.id.PhoneNumber1);
         phoneNumber2 = (EditText) findViewById(R.id.PhoneNumber2);
         phoneNumber3 = (EditText) findViewById(R.id.PhoneNumber3);


        B.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                Intent obj = new Intent(getApplicationContext(), firstpage.class);
                insert(v);

                startActivity(obj);
            }

        });


    }
    void insert(View v)
    {

        db=openOrCreateDatabase("test1.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        ContentValues cv=new ContentValues();
        cv.put("p1",phoneNumber1.getText().toString());
        cv.put("p2",phoneNumber2.getText().toString());
        cv.put("p3",phoneNumber3.getText().toString());
        long a= db.insert("CONTACT", null, cv);
        db.close();
        if(a!=0)
        {
            Toast.makeText(getBaseContext(),"Contacts Saved",Toast.LENGTH_SHORT).show();


        }

        else
        {
            Toast.makeText(this,"Error occured",Toast.LENGTH_SHORT).show();
        }


    }


}
