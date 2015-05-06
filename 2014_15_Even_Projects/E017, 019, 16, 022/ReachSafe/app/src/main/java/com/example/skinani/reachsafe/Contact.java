package com.example.skinani.reachsafe;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import android.provider.ContactsContract;

public class Contact extends Activity {

    int count;

    public void displayContact() {
        ContentResolver cr = getContentResolver();
        String name, phoneNo, n1;
        TextView tv = (TextView) findViewById(R.id.cinfo1);
        EditText cont = (EditText) findViewById(R.id.name1);
        n1 = cont.getText().toString();
        Cursor c = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (c.getCount() > 0) {
            while (c.moveToNext()) {
                String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                if (Integer.parseInt(c.getString(
                        c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    Cursor pcur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                    while (pcur.moveToNext()) {
                        name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        phoneNo = pcur.getString(pcur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        if (n1.contentEquals(name)) {
                            tv.setText("Name: " + name + "    " +

                                    "Phone no: " + phoneNo);
                        }
                    }
                    pcur.close();
                }
            }
        }
        cont.setText("");
    }

    public void displayContact1() {
        ContentResolver cr1 = getContentResolver();
        String na, phNo, n2;
        TextView tv1 = (TextView) findViewById(R.id.cinfo2);
        EditText cont1 = (EditText) findViewById(R.id.name2);
        n2 = cont1.getText().toString();
        Cursor cur = cr1.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                if (Integer.parseInt(cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    Cursor pcur1 = cr1.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                    while (pcur1.moveToNext()) {
                        na = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        phNo = pcur1.getString(pcur1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        if (n2.contentEquals(na)) {
                            tv1.setText("Name: " + na + " " +

                                    "Phone no: " + phNo);

                        }
                    }
                    pcur1.close();
                }
            }
        }
        cont1.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        Button pro= (Button) findViewById(R.id.Pro1);
        Button con1= (Button) findViewById(R.id.c1);
        Button con2= (Button) findViewById(R.id.c2);
        pro.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                if(count<2)
                {
                    Toast.makeText(Contact.this,"Please choose two contacts",Toast.LENGTH_SHORT).show();
                }
                if(count>=2)
                {
                    startActivity(new Intent(Contact.this, Event.class));
                }
            }
        });

        con1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                displayContact();
                Log.i("Second","Completed the contact list");
                count++;

            }
        });

        con2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                displayContact1();
                Log.i("Second", "Second Contact in list");
                count++;
            }
        });

    }

}