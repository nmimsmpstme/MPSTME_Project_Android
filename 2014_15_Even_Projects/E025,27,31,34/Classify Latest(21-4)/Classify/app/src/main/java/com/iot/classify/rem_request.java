package com.iot.classify;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;


public class rem_request extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rem_request);
    }


    public void postacc(View v) throws SQLException {
        EditText name = (EditText) findViewById(R.id.name);
        EditText req = (EditText) findViewById(R.id.reqno);
        Button b1 = (Button)findViewById(R.id.postacc);
        String regno= new String();
        regno = null;
        regno=req.getText().toString();
        if(regno!=null)
        {
            RDBAdapter db = new RDBAdapter(rem_request.this);
            db.open();
            db.deleteRecord(regno);
            db.close();
        }
        String nam=new String();
        nam=null;
        nam=name.getText().toString();
        String fin = new String();
        fin=null;
        fin="Your request no "+regno+" has been accepted by "+nam;
        NotificationManager notifyclass = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification classnoti = new Notification(R.drawable.notiflogo, "New Message", System.currentTimeMillis());

        Intent intent = new Intent(rem_request.this, request_tab.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        classnoti.setLatestEventInfo(rem_request.this,"Acceptance Notification",fin,pendingIntent);
        notifyclass.notify(9999, classnoti);

        startActivity(intent);
    }
}
