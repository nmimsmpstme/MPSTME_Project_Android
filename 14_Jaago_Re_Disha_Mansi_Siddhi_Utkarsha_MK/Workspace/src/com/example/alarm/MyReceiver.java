package com.example.alarm;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.InboxStyle;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver{

	static NotificationManager notificationManager;
	String dayName, Schedule = "";
	Bundle bundle;
	int flag;
	MediaPlayer mMediaPlayer;
	Intent i ;
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		//Toast.makeText(arg0, "Broadcast Started", Toast.LENGTH_LONG).show();
		bundle = arg1.getExtras();
		i = new Intent(arg0, MyAlarm.class);
		i.putExtras(bundle);
		arg0.startService(i);
		
	}

}
