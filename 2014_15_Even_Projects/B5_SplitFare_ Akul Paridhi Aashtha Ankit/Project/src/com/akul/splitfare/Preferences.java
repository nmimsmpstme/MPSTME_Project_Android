package com.akul.splitfare;

import java.lang.reflect.Field;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class Preferences extends ActionBarActivity 
{

	EditText e;
	Spinner s;
	Switch sw;
	public void loadprefs()
	{
		e.setText(ConfigHandler.getcurr());
		s.setSelection(ConfigHandler.getacc());
		sw.setChecked(ConfigHandler.getd());
	}
	public void setprefs()
	{
		if(Common.gt(e).trim().length() == 0)
		{
			Toast.makeText(this, "Enter A Currency", Toast.LENGTH_LONG).show();
		}
		else
		{
		ConfigHandler.setcurr(Common.gt(e).trim());
		ConfigHandler.setd(sw.isChecked());
		ConfigHandler.setacc(s.getSelectedItemPosition());
	Toast.makeText(this, "Preferences Saved!", Toast.LENGTH_LONG).show();
		Intent i = getBaseContext().getPackageManager()
	             .getLaunchIntentForPackage( getBaseContext().getPackageName() );
	i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	Thread th = new Thread()
	{
		@Override
		public void run()
		{
			try
			{
			String r =Common.APICall("http://akul.cu.cc/setprefs.php?u="+ConfigHandler.getuid()+"&d="+(ConfigHandler.getd()?""+1:""+0)+"&curr="+ConfigHandler.getcurr()+"&acc="+ConfigHandler.getacc()).substring(4);
			}
			catch(Exception e){}
		}
	};
	th.start();
	startActivity(i);
	finish();
		}
	}
	void init()
	{
		sw = (Switch)findViewById(R.id.sw1);
		e = (EditText)findViewById(R.id.prefs_edcurr);
		s = (Spinner)findViewById(R.id.spinner1);
	}
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
		actionBar.setTitle("Preferences");  
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
		setContentView(R.layout.activity_preferences);
		init();
		loadprefs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preferences, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		if (id == R.id.prefs_ok) 
		{
			setprefs();
		}
		else
			if(id == R.id.prefs_cancel)
			{
				finish();
			}
		return super.onOptionsItemSelected(item);
	}
}
