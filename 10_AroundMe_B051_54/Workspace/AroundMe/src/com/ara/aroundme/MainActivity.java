package com.ara.aroundme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	Button btn,btn2;
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void emergency(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(this, Emergency.class);
		startActivity(i);
	//	Toast.makeText(MainActivity.this,"Calling emergency",Toast.LENGTH_SHORT).show();
	}

		public void stations(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(MainActivity.this,Station.class);
			startActivity(i);
	
	}
		public void places(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(MainActivity.this,Map0.class);
			startActivity(i);
	
	}
}