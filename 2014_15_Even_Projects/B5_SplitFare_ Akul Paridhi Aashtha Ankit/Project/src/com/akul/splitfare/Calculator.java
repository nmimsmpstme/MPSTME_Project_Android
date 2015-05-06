package com.akul.splitfare;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;

public class Calculator extends ActionBarActivity {

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
		setContentView(R.layout.activity_calculator);
		Button b = (Button) findViewById(R.id.calc_btn);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				EditText e1 = (EditText) findViewById(R.id.calc_amt);
				EditText e2 = (EditText)findViewById(R.id.calc_num);
				int num = Integer.parseInt(e2.getText().toString());
				float amt = Float.parseFloat(e1.getText().toString());
				float fnl = amt/num*1.0f;

				new MaterialDialog.Builder(Calculator.this)
		        .title("Bill Split")
		        .content("Each Person Must Pay : "+fnl)
		        .positiveText("OK")
		        .titleColor(R.color.red_600)
		        .callback(new MaterialDialog.ButtonCallback() {
		            @Override
		            public void onPositive(MaterialDialog dialog) 
		            {
		            	dialog.dismiss();
		            }
		        })
		        .cancelable(false)
		        .show();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
