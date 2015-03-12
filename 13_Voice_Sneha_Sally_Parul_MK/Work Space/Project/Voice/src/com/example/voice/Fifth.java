package com.example.voice;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Fifth extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifth);
	}
	public void onClicks (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClicky (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClickc (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClickp (View view){
		Toast.makeText(this, "Yes! Well Done", Toast.LENGTH_SHORT).show(); 
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}