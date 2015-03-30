package com.example.alarm;

import java.util.Calendar;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class Activity_Buzzer extends Activity{

	int hr,min;
	Intent service;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buzzing_activity);
		
	}

	public void stop(View view) {
		Intent myAlarm = new Intent(this, MyAlarm.class);
		stopService(myAlarm);
		finish();
	}
	
	public void snooze(View view) {
		Intent myAlarm = new Intent(this, MyAlarm.class);
		stopService(myAlarm);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 5);
		hr = c.get(Calendar.HOUR_OF_DAY);
		min = c.get(Calendar.MINUTE);
		service = new Intent(this,MyService.class);
		Bundle bundle = new Bundle();
		bundle.putInt("HOUR", hr);
		bundle.putInt("MIN", min);
		bundle.putInt("MODE", 0);
		service.putExtras(bundle);
		startService(service);
		finish();
	}
}
