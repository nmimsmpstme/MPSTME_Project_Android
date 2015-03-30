package com.example.alarm;

import java.util.Calendar;
import java.util.Random;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class MyAlarm extends Service{

	public static final String TAG = "MyServiceTag";
	static NotificationManager notificationManager;
	String dayName, Schedule = "";
	Bundle bundle;
	int flag;
	MediaPlayer mMediaPlayer;
	CountDownTimer count;
	Vibrator v;
	int hr,min;
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override 
	public void onCreate() { 
		Log.d(TAG, "onCreate"); 
	} 
	

	@Override 
	public void onStart(Intent intent, int startId) { 
		Bundle bundle = intent.getExtras();
		min = bundle.getInt("MIN", 60);
	    hr = bundle.getInt("HOUR", 24);
		notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		notification(this);
		Log.d(TAG, "onStart");
	} 
	
	private void notification(Context arg0) {
			mMediaPlayer = new MediaPlayer();
			createNotification();
	}
	
	
	public void createNotification() {
        // Prepare intent which is triggered if the
        // notification is selected
		notificationManager.cancelAll();
        
        // Build notification
		//Intent intent = new Intent(this, AlarmMainActivity.class);
		Random rand = new Random();
		int choice = rand.nextInt(3);
		Intent intent;
		if(choice==1) {
			intent = new Intent(this, Matheq.class);
		}
		else if(choice==2){
			intent = new Intent(this, Squares.class);
		}
		else
		{
			intent=new Intent(this, Diff.class);
		}
	
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        @SuppressWarnings("deprecation")
		Notification noti = new Notification.Builder(this)
        .setContentTitle("Alarm")
        .setContentText("Alarm for " + hr + ":" + min)
        .setSmallIcon(R.drawable.ic_launcher)
        .setContentIntent(pIntent)
        .setLights(Color.RED, 3000, 3000)
        .getNotification();
        noti.flags |= Notification.FLAG_NO_CLEAR;
        
        try {
        	  Uri alert =  RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        	  mMediaPlayer = new MediaPlayer();
        	  mMediaPlayer.setDataSource(this, alert);
        	  final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        	  if (audioManager.getStreamVolume(AudioManager.STREAM_RING) != 0) {
        		  mMediaPlayer.setAudioStreamType(AudioManager.STREAM_RING);
        		  mMediaPlayer.setLooping(true);
        		  mMediaPlayer.prepare();
        		  mMediaPlayer.start();
        		  count = new CountDownTimer(120000, 1000){

        		       @Override
        		       public void onTick(long millisUntilFinished) {

        		       }       

        		       @Override
        		       public void onFinish() {
        		           //Codes for checking the changes in the database on the server
        		    	   mMediaPlayer.stop();
        		       }
        		   };
        		  count.start();
        		  
        	  }
        	} catch(Exception e) {
        	}   
        
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 15 seconds

        v.vibrate(new long[] { 1000, 1000, 1000, 1000, 1000 }, 1);
        notificationManager.notify(0, noti);
      }
	
	public void cancelNotification() {
		notificationManager.cancelAll();
	}

	@Override 
	public void onDestroy() { 
		v.cancel();
		mMediaPlayer.stop();
		
		cancelNotification();
		Toast.makeText(this, "Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy"); 
	}
	
}
