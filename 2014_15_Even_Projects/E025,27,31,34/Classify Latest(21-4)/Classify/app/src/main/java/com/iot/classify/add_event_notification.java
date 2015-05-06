package com.iot.classify;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class add_event_notification extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_notification);
    }

    public void postevent(View view)throws SQLException{
        EditText committee = (EditText) findViewById(R.id.committee);
        EditText eventname = (EditText) findViewById(R.id.eventname);
        EditText description = (EditText) findViewById(R.id.description);
        EditText date = (EditText) findViewById(R.id.datentime);
        Button b1 = (Button) findViewById(R.id.postevent);
        String com = new String();
        com = null;
        com = committee.getText().toString();
        String name = new String();
        name = null;
        name = eventname.getText().toString();
        String des = new String();
        des = null;
        des = description.getText().toString();
        String datentime = new String();
        datentime = null;
        datentime = date.getText().toString();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String tag = df.format(c.getTime());
        if (com != null && name != null && tag != null) {
            ENDBAdapter db = new ENDBAdapter(add_event_notification.this);
            db.open();
            db.insertRecord(com, name,des,datentime,tag);
            db.close();
        }
        NotificationManager notifyclass = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification classnoti = new Notification(R.drawable.notiflogo, "New Message", System.currentTimeMillis());

        Intent intent = new Intent(add_event_notification.this, events_notifications.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        classnoti.setLatestEventInfo(add_event_notification.this,name,datentime,pendingIntent);
        notifyclass.notify(9999, classnoti);
        startActivity(intent);
    }
}

