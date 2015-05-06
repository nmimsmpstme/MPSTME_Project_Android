package com.iot.classify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.SQLException;


public class institute_notifications extends ActionBarActivity {

    FlyOutContainer root;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_institute_notifications, null);
        setContentView(root);
        TextView tv = (TextView)findViewById(R.id.textView);
        INDBAdapter db = new INDBAdapter(institute_notifications.this);
        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String data = db.getData();
        db.close();
        tv.setText(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_institute_notifications, menu);
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

    public void addnotification(View v)
    {
        ImageButton imag=(ImageButton) findViewById(R.id.add_button);
        Intent addnotif = new Intent(institute_notifications.this,add_institute_notification.class);
        startActivity(addnotif);
    }

    public void gotoclassnotifications(View view){
        Intent intent = new Intent(institute_notifications.this,class_level_notifications.class);
        startActivity(intent);
    }

    public void gotoeventnotifications(View view){
        Intent intent = new Intent(institute_notifications.this,events_notifications.class);
        startActivity(intent);
    }

    public void gotoinstitutenotifications(View view){
        Intent intent = new Intent(institute_notifications.this,institute_notifications.class);
        startActivity(intent);
    }

    public void gotorequesttab(View view){
        Intent intent = new Intent(institute_notifications.this,request_tab.class);
        startActivity(intent);
    }

    public void slide(View view){
        this.root.ToggleMenu();
    }

}
