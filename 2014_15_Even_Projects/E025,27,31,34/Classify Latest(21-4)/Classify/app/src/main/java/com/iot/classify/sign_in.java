package com.iot.classify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class sign_in extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }


    public void login(View v)
    {
        Button b = (Button)findViewById(R.id.login) ;
        EditText e1 = (EditText)findViewById(R.id.userid);
        EditText e2 = (EditText)findViewById(R.id.password);
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        Intent mainpage = new Intent(sign_in.this,class_level_notifications.class);
        if("vinay".equals(s1) && "login".equals(s2))
        {
            startActivity(mainpage);
        }
        else
        {
            Toast.makeText(sign_in.this, "User Id or Password is invalid", Toast.LENGTH_SHORT).show();
        }
    }

}
