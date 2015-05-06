package com.example.srija.dietplanner;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class PREV_DATA extends ActionBarActivity {

    SQLiteDatabase db;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev__dat);
        tv= (TextView)findViewById(R.id.tv1);
        db=openOrCreateDatabase("test.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.execSQL(
                "create table if not exists USER_DETAILS " +
                        "( height,weight,BMI)"
        );

        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
        up();
    }


    void up()
    {
        db=openOrCreateDatabase("test.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        Cursor cr=db.query("USER_DETAILS", null, null, null, null, null, null, null);
        cr.moveToFirst();
        tv.setText("HEIGHT\t\t\tWEIGHT\t\t\tBMI\n");
        while(!cr.isAfterLast())
        {
            tv.append("\n"+cr.getString(0) + "\t\t\t\t\t\t" + cr.getString(1)+"\t\t\t\t\t\t"+cr.getString(2)+"\n");
            cr.moveToNext();

        }
        cr.close();
        db.close();
    }
    void del()
    {
        this.deleteDatabase("test.db");
        tv.setText("NO DATA");
        Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prev__dat, menu);
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
          del();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
