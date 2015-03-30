package com.example.alarm;



import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmMainActivity extends Activity {
	
	TimePicker timePick;
	int hr,min;
	Intent service;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_main);
		timePick = (TimePicker) findViewById (R.id.timePicker1);
	}
	 
	 	     
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_widget_alarm_manager, menu);
	 	return true;
	}*/
	
	public void Start(View view) {
		hr = timePick.getCurrentHour();
		min = timePick.getCurrentMinute();
		service = new Intent(this,MyService.class);
		Bundle bundle = new Bundle();
		bundle.putInt("HOUR", hr);
		bundle.putInt("MIN", min);
		bundle.putInt("MODE", 0);
		service.putExtras(bundle);
		startService(service);
		
	}
	
	public void cancel(View view) {
		hr = timePick.getCurrentHour();
		min = timePick.getCurrentMinute();
		Intent myAlarm = new Intent(this, MyAlarm.class);
		Intent myService = new Intent(this, MyService.class);
		Bundle bundle = new Bundle();
		bundle.putInt("HOUR", hr);
		bundle.putInt("MIN", min);
		bundle.putInt("MODE", 1);
		myService.putExtras(bundle);
		myAlarm.putExtras(bundle);
		stopService(myAlarm);
		startService(myService);
	}
	
	public void stop(View view) {
		Intent myAlarm = new Intent(this, MyAlarm.class);
		stopService(myAlarm);
	}
}
	
