package com.iot.classify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.SQLException;


public class request_tab extends ActionBarActivity {

    FlyOutContainer root;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_request_tab, null);
        setContentView(root);
        TextView tv = (TextView)findViewById(R.id.textView);
        RDBAdapter db = new RDBAdapter(request_tab.this);
        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String data = db.getData();
        db.close();
        tv.setText(data);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_request_tab, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.button:
                slide(v);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addrequest(View v)
    {
        Button b1 = (Button)findViewById(R.id.postrequest);
        Intent addnotif = new Intent(request_tab.this,add_request.class);
        startActivity(addnotif);
    }
    public void remrequest(View v)
    {
        Button b1 = (Button)findViewById(R.id.accreq);
        Intent addnotif = new Intent(request_tab.this,rem_request.class);
        startActivity(addnotif);
    }

    public void gotoclassnotifications(View view){
        Intent intent = new Intent(request_tab.this,class_level_notifications.class);
        startActivity(intent);
    }

    public void gotoeventnotifications(View view){
        Intent intent = new Intent(request_tab.this,events_notifications.class);
        startActivity(intent);
    }

    public void gotoinstitutenotifications(View view){
        Intent intent = new Intent(request_tab.this,institute_notifications.class);
        startActivity(intent);
    }

    public void gotorequesttab(View view){
        Intent intent = new Intent(request_tab.this,request_tab.class);
        startActivity(intent);
    }

    public void slide(View view){
        this.root.ToggleMenu();
    }
}
