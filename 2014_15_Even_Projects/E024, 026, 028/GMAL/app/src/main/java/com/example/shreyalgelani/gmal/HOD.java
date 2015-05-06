package com.example.shreyalgelani.gmal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class HOD extends ActionBarActivity implements View.OnClickListener {
    EditText s6,s7,s8,s9,s10;
    Button button1,button2;
    public void nl() throws SQLException {
        FM1 ho = new FM1(this);
        ho.open();
        String f = ho.getfrom();

        s6.setText(f);


        String f1 = ho.getfrom1();

        s7.setText(f1);


        String f2 = ho.getfrom3();
        if(f2.contentEquals("2131230806"))
            s8.setText("SICK");
        if(f2.contentEquals("2131230807"))
            s8.setText("CASUAL");
        if(f2.contentEquals("2131230808"))
            s8.setText("DUTY");


        String f3 = ho.getfrom2();

        s9.setText(f3);


        String f4 = ho.getfrom4();

        s10.setText("fac/1");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod);
        s6=(EditText)findViewById(R.id.editText6);
        s7=(EditText)findViewById(R.id.editText7);
        s8=(EditText)findViewById(R.id.editText8);
        s9=(EditText)findViewById(R.id.editText10);
        s10=(EditText)findViewById(R.id.editText4);
button1=(Button)findViewById(R.id.button2);
        button2=(Button)findViewById(R.id.button3);

        try {
            nl();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    button1.setOnClickListener(this);
        button2.setOnClickListener(this );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hod, menu);
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

    @Override
    public void onClick(View arg0) {
        switch(arg0.getId()) {
            case R.id.button2:
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "ACCEPTED", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(this, Inbox.class);
                startActivity(intent);
                break;
            case R.id.button3:
                Context context1 = getApplicationContext();
                Toast toast1 = Toast.makeText(context1, "REJECTED", Toast.LENGTH_LONG);
                toast1.show();
                Intent intent1 = new Intent(this, Inbox.class);
                startActivity(intent1);
                break;


        }}
}

