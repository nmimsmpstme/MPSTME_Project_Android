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



public class GMAL_LOGIN extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmal__login);
        Button loginbt=(Button)findViewById(R.id.loginbtn);
        final EditText sap=(EditText)findViewById(R.id.sid);
        final EditText pass=(EditText)findViewById(R.id.loginpass);
        loginbt.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String check = sap.getText().toString();
                String check1=pass.getText().toString();
                if (check.contentEquals("fac/1")&&check1.contentEquals("fac"))
                {
                sendMessagea(v);
                }
                else if (check.contentEquals("hod/1")&&check1.contentEquals("hod"))
                {
                    sendMessageb(v);

                }
                else if (check.contentEquals("dean/1")&&check1.contentEquals("dean"))
                {
                    sendMessagec(v);

                }
                else if (check.contentEquals("hr/1")&&check1.contentEquals("hr"))
                {
                    sendmessagedc(v);
                }
                else
                {
                    Context context = getApplicationContext();
                    Toast toast=Toast.makeText(context , "invalid username or password",Toast.LENGTH_LONG);
                       toast.show();
                }
            }
        });
    }

    public void sendMessagea(View view)
    {
        Intent intent = new Intent(this, Fac_inbox.class);

        startActivity(intent);
    }

    public void sendmessagedc(View view)
    {
        Intent intent = new Intent(this, hr.class);

        startActivity(intent);
    }
    public void sendMessageb(View view)
    {
        Intent intent = new Intent(this, Inbox.class);

        startActivity(intent);
    }
    public void sendMessagec(View view)
    {
        Intent intent = new Intent(this,Dean_inbox.class);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gmal__login, menu);
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
