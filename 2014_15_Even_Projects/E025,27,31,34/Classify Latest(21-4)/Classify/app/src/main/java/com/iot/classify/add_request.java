package com.iot.classify;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class add_request extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);
    }


    public void postreq(View v) throws SQLException {
        EditText name = (EditText) findViewById(R.id.name);
        EditText subject = (EditText) findViewById(R.id.subject);
        EditText preferredtime = (EditText) findViewById(R.id.preferredtime);
        Button b1 = (Button) findViewById(R.id.postrequest);
        String nam = new String();
        nam = null;
        nam = name.getText().toString();
        String sub = new String();
        sub = null;
        sub= subject.getText().toString();
        String prtime=new String();
        prtime=null;
        prtime=preferredtime.getText().toString();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String tag = df.format(c.getTime());
        if (nam != null && sub != null && prtime!=null && tag != null) {
            RDBAdapter db = new RDBAdapter(add_request.this);
            db.open();
            db.insertRecord(nam,sub,prtime,tag);
            db.close();
        }
        Intent intent = new Intent(add_request.this, request_tab.class);
        startActivity(intent);
    }
}
