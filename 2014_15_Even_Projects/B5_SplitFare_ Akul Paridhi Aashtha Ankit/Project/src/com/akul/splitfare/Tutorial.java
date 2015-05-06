package com.akul.splitfare;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class Tutorial extends ActionBarActivity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		 setTheme(ConfigHandler.getstyle()); 
		super.onCreate(savedInstanceState);
		android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) 
        {
    	    setSupportActionBar(toolbar);
        }
		final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		  try
		  {
		        ViewConfiguration config = ViewConfiguration.get(this);
		        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
		        if(menuKeyField != null) 
		        {
		            menuKeyField.setAccessible(true);
		            menuKeyField.setBoolean(config, false);
		        }
		    } 
		  catch (Exception ex)
		  {
			  
		  }
	
		setContentView(R.layout.activity_tutorial);
		StringBuilder buf=new StringBuilder();
	try
	{
		InputStream tut=getAssets().open("tutorial.txt");
	    BufferedReader in=
	        new BufferedReader(new InputStreamReader(tut, "UTF-8"));
	    String str;
	    while ((str=in.readLine()) != null) 
	    {
	      buf.append(str+"\n");
	    }

	    in.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	TextView tv= (TextView) findViewById(R.id.tv_tutm);
	tv.setText(buf.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tutorial, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
