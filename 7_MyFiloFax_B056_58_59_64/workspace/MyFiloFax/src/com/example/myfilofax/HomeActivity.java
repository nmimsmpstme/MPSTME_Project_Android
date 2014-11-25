package com.example.myfilofax;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends Activity {
	@SuppressLint("NewApi")
	String x ;
	MainActivity m ;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		// Show the Up button in the action bar.
		setupActionBar();
	}

	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
 public void loo(View view)
 {
	 Intent re = new Intent(this, Tasks.class);
	 startActivity(re);
	 
 }
 public void pole(View view)
 {
	 Intent pre = new Intent(this, Share.class);
	 startActivity(pre);
	 
 }

 public void cole(View view)
 {
	 Intent pre = new Intent(this, Upload.class);
	 startActivity(pre);
	 
 }
 
 public void dole(View view)
 {
	 Intent pre = new Intent(this, Weekview.class);
	 startActivity(pre);
	 
 }
 
 public void fole(View view)
 {
	 Intent pre = new Intent(this, Exams.class);
	 startActivity(pre);
	 
 }
 
 public void gole(View view)
 {
	 Intent pre = new Intent(this, Requests.class);
	 startActivity(pre);
	 
 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

public void got(View view)
{
Intent ind = new Intent (this, Tasks.class );
startActivity(ind);

}


}
     