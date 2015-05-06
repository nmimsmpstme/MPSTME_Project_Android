package com.iot.classify;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class add_class_notification extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class_notification);
    }


    public void post(View v) throws SQLException {
        EditText subject = (EditText) findViewById(R.id.Subject);
        EditText message = (EditText) findViewById(R.id.Message);
        Button b1 = (Button) findViewById(R.id.AddNotif);
        String sub = new String();
        sub = null;
        sub = subject.getText().toString();
        String msg = new String();
        msg = null;
        msg = message.getText().toString();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String tag = df.format(c.getTime());
        if (sub != null && msg != null && tag != null) {
            CNDBAdapter db = new CNDBAdapter(add_class_notification.this);
            db.open();
            db.insertRecord(sub, msg, tag);
            db.close();
        }
        NotificationManager notifyclass = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification classnoti = new Notification(R.drawable.notiflogo, "New Message", System.currentTimeMillis());

        Intent intent = new Intent(add_class_notification.this, class_level_notifications.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        classnoti.setLatestEventInfo(add_class_notification.this, sub, msg, pendingIntent);
        notifyclass.notify(9999, classnoti);
        startActivity(intent);
    }
}
