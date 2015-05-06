package com.tuts.notes_lib;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.database.sqlite.SQLiteDatabase;

import java.util.Locale;


public class Notes extends ActionBarActivity {

    EditText name, id1;
    SQLiteDatabase db;
    TextView te;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
createActivityTable();

        final Button btnComp = (Button) findViewById(R.id.btn_comp);
        btnComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    db = openOrCreateDatabase("Notes.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
              Intent i=new Intent(getApplicationContext(),computer_main.class);
                String a=btnComp.getText().toString();
                i.putExtra("DEPT", a);
                startActivity(i);

            }
        });

/*
        Button btnComp = (Button) findViewById(R.id.btn_comp);
        btnComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Notes.this);
                builder.setMessage("Do you want to go to the next page?");
                builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Notes.this,"You clicked Yes",Toast.LENGTH_LONG).show();
                        Intent i1 = new Intent(getApplicationContext(), computer_main.class);

                        Notes.this.startActivity(i1);
                    }

                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //User Cancelled the dialog
                        Toast.makeText(Notes.this,"You clicked No",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        });*/
        Button btnMech = (Button) findViewById(R.id.button3);
        btnMech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i2 = new Intent(getApplicationContext(), Mechanical1.class);
                //startActivity(i2);
                db = openOrCreateDatabase("Notes.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                // getSupportActionBar().setTitle("Computer");

                Cursor cr=db.query("Course1",null,null,null,null,null,null,null);
                cr.moveToFirst();
                // String[] year=new String[5];
                // int i=0;
                while(cr.isAfterLast()==false)
                {
                   // tv.append(gota);
                    String a=cr.getString(1);
                    te.append(a);
                    // if(a.toLowerCase().toString().equals(gota.toLowerCase().toString()))
                    //year[i]=cr.getString(2);
                    //i++;

                }
            }


        });
        Button btnIT = (Button) findViewById(R.id.btn_it);
        btnIT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(),IT.class);
                startActivity(i3);
            }
        });
        Button btnCivil = (Button) findViewById(R.id.btn_civil);
        btnCivil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getApplicationContext(),Civil.class);
                startActivity(i4);
            }
        });
    }

public void createActivityTable()
{
    db = openOrCreateDatabase("Notes.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
    db.setVersion(1);
    db.setLocale(Locale.getDefault());

    final String create="Create table Course1 (Dept Text,Year Integer)";
    db.execSQL(create);

    ContentValues cv=new ContentValues();
    for  (int i=0;i<4;i++) {
        cv.put("Dept", "Computer");
        cv.put("Year", i+1);
    }
    for  (int i=0;i<4;i++) {
        cv.put("Dept", "Mechanical");
        cv.put("Year", i+1);
    }
    for  (int i=0;i<4;i++) {
        cv.put("Dept", "IT");
        cv.put("Year", i+1);
    }
    for  (int i=0;i<4;i++) {
        cv.put("Dept", "Civil");
        cv.put("Year", i+1);
    }
    db.insert("Course1",null,cv);

}




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notes, menu);
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
    }
}
