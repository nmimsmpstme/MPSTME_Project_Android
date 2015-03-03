package com.example.recurso;

import java.io.IOException;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends Activity implements OnClickListener {

	Button learn,translate,settings,instruction,exit;
	SQLiteDatabase db,db1;
	Cursor c,d;
	private new_data mDbHelper; 
	int temp_in_db=31;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		db = openOrCreateDatabase("TEMP", MODE_PRIVATE, null);
		try
		{
		db.execSQL("create table TFlag(_id integer primary key autoincrement,typ number(1))");
		db.execSQL("create table color(_id integer primary key autoincrement,rr integer,gg integer,bb integer)");
		}
		catch(Exception e)
		{
		}
	 
		c=db.query("TFlag", null, null, null, null, null, null);
		d=db.query("color", null, null, null, null, null, null);
		if(c.getCount()==0)
		{
			for(int j=0;j<1;j++)
			{
				db.execSQL("insert into TFlag (typ)values(1)");
				db.execSQL("insert into color(rr,gg,bb)values(202,225,255)");
			}
	
			new_data myDbHelper = new new_data(getBaseContext());
	        myDbHelper = new new_data(this);
		
	        
	        try {
	        	myDbHelper.copyDataBase();
	     }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   	 
	     
		}
		c.close();
		db.close();
	 			
		learn=(Button)findViewById(R.id.btn_str_1);
		translate=(Button)findViewById(R.id.btn_str_2);
		settings=(Button)findViewById(R.id.btn_str_3);
		instruction=(Button)findViewById(R.id.btn_str_4);
		exit=(Button)findViewById(R.id.btn_str_5);

		
		learn.setOnClickListener(this);
		translate.setOnClickListener(this);
		settings.setOnClickListener(this);
		instruction.setOnClickListener(this);
		exit.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int iidd=v.getId();
		final Button gghh=(Button)findViewById(iidd);
		String bstring=gghh.getText().toString();
		gghh.setAlpha((float) 0.5);
		
		if(bstring.equals("Lets Learn"))
		{
			
			Intent play=new Intent(this,SecondPage.class);
			startActivity(play);
			
		}
		
		if(bstring.equals("Lets Translate"))
		{
			Intent play=new Intent(this,Translate.class);
			startActivity(play);
		}	
		
		if(bstring.equals("Settings"))
		{
			Intent play=new Intent(this,Settings.class);
			finish();
			startActivity(play);
			
		}
		
		if(bstring.equals("Exit"))
		{
			
			finish();
			
		}
		
		if(bstring.equals("Instruction"))
		{
			Intent play=new Intent(this,Instructions.class);
			startActivity(play);
			
		}
		overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		  @Override
		  public void run() {
		    gghh.setAlpha(1);
		  }
		}, 100);
		
		
	}
}
