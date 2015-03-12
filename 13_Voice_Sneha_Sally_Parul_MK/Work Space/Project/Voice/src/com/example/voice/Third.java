package com.example.voice;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Third extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
	}
	public void onClickgrandpa (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClickgrandma (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClickdad (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClickmom (View view){
		Toast.makeText(this, "Yes! Well Done", Toast.LENGTH_SHORT).show(); 
	}
	public void swapto4(View v2)
	{
		startActivity(new Intent(Third.this, Fourth.class));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}