package com.example.voice;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Fourth extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourth);
	}
	public void onClicko (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClicka (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClicke (View view){
		Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show(); 
	}
	public void onClicki (View view){
		Toast.makeText(this, "Yes! Well Done", Toast.LENGTH_SHORT).show(); 
	}
	public void swapto5(View v3)
	{
		startActivity(new Intent(Fourth.this, Fifth.class));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}