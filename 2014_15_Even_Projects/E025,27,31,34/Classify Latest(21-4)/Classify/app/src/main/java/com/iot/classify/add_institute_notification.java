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


public class add_institute_notification extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_intsitute_notification);
    }

    public void postmessage(View view)throws SQLException {
        EditText message = (EditText) findViewById(R.id.message);
        Button b1 = (Button) findViewById(R.id.postevent);
        String mess = new String();
        mess = null;
        mess = message.getText().toString();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String tag = df.format(c.getTime());
        if (mess != null) {
            INDBAdapter db = new INDBAdapter(add_institute_notification.this);
            db.open();
            db.insertRecord(mess,tag);
            db.close();
        }
        NotificationManager notifyclass = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification classnoti = new Notification(R.drawable.notiflogo, "New Message", System.currentTimeMillis());

        Intent intent = new Intent(add_institute_notification.this, institute_notifications.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        classnoti.setLatestEventInfo(add_institute_notification.this,"Institute Notification",mess,pendingIntent);
        notifyclass.notify(9999, classnoti);
        startActivity(intent);
    }
}
