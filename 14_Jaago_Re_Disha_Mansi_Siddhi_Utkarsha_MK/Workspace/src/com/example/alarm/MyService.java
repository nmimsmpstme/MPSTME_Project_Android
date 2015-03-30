package com.example.alarm;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
 
public class MyService extends Service {
	
	String TAG, Schedule = "";
	NotificationManager notificationManager;
	String dayName;
	PendingIntent pendIntent;
	AlarmManager alarmManager ;
	int min;
	int hr,mode;
	int i;
	Intent intent1 ;
	
	@Override 
	public IBinder onBind(Intent arg0) { 
		return null; 
	} 
	
	@Override 
	public void onCreate() { 
		Log.d(TAG, "onCreate"); 
		i=0;
	} 
	

	@Override 
	public void onStart(Intent intent, int startId) { 
			Bundle bundle = intent.getExtras();
			min = bundle.getInt("MIN", 60);
		    hr = bundle.getInt("HOUR", 24);
		    mode = bundle.getInt("MODE", 0);
		    if(mode==0) {
		    	Toast.makeText(this, "Alarm Set: " + hr + ":" + min, Toast.LENGTH_LONG).show(); 
				Calendar calendar = Calendar.getInstance();
		    	calendar.set(Calendar.HOUR_OF_DAY, hr);
		    	calendar.set(Calendar.MINUTE, min);
		    	calendar.set(Calendar.SECOND, 00);
		    	intent1 = new Intent (this, MyReceiver.class);
		    	Bundle bundle1 = new Bundle();
		    	bundle1.putInt("HOUR", hr);
				bundle1.putInt("MIN", min);
		    	intent1.putExtras(bundle1);
		        pendIntent = PendingIntent.getBroadcast(this, (hr+min),  intent1, PendingIntent.FLAG_ONE_SHOT);
		        alarmManager = (AlarmManager) getSystemService (Context.ALARM_SERVICE);
		        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendIntent);
		        startService(intent1);
		    }
		    else {
		    	intent1 = new Intent (this, MyReceiver.class);
		    	Bundle bundle1 = new Bundle();
		    	bundle1.putInt("HOUR", hr);
				bundle1.putInt("MIN", min);
		    	intent1.putExtras(bundle1);
		        pendIntent = PendingIntent.getBroadcast(this, (hr+min),  intent1, PendingIntent.FLAG_UPDATE_CURRENT);
		        pendIntent.cancel();
		    }
			Log.d(TAG, "onStart");
		
	} 
	

	@Override 
	public void onDestroy() { 
		alarmManager.cancel(pendIntent);
		Log.d(TAG, "onDestroy"); 
	}

}