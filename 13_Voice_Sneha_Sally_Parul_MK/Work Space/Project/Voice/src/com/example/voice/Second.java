package com.example.voice;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Second extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
	}
	public void onClickapple (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClickcookie (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClickcake (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClickcheese (View view){
		Toast.makeText(this, "Yes! Well Done", Toast.LENGTH_SHORT).show(); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 //Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void swapto21(View v)
	{
		startActivity(new Intent(Second.this, Third.class));
	}

}