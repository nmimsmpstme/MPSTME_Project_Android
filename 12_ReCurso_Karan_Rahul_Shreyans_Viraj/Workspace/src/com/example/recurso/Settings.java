package com.example.recurso;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class Settings extends Activity implements OnSeekBarChangeListener {

	RelativeLayout ll1;
	SQLiteDatabase sb,sb3;
	SeekBar r,g,b;
	int rr=0,gg=0,bb=0;
	Button bset;
	Cursor z;

	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		Intent gg=new Intent(this,MainActivity.class);
		startActivity(gg);
		
			overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
		
		finish();
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.settings);
	ll1=(RelativeLayout)findViewById(R.id.lll1);
	
		bset=(Button)findViewById(R.id.bset);
		r=(SeekBar)findViewById(R.id.R);
		g=(SeekBar)findViewById(R.id.G);
		b=(SeekBar)findViewById(R.id.BB);
		
		r.setOnSeekBarChangeListener(this);
		g.setOnSeekBarChangeListener(this);
		b.setOnSeekBarChangeListener(this);
		


		sb=openOrCreateDatabase("TEMP", MODE_PRIVATE, null);
		
		try
		{sb.execSQL("create table color(_id integer primary key autoincrement,rr integer,gg integer,bb integer)");
			}
		catch(Exception e)
		{

		}
		

	}
	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		if(arg0==r)
		{
			rr=arg1*3;
			set();
		}
		if(arg0==g)
		{
			gg=arg1*3;
			set();
		}
		if(arg0==b)
		{
			bb=arg1*3;
			set();
		}
	}
	
	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	private void set() {
		// TODO Auto-generated method stub
		ll1.setBackgroundColor(Color.rgb(rr, gg, bb));
	}


	public void set(View v)
	{
		Cursor d;
		d=sb.query("color", null, null, null, null, null, null);
		d=sb.rawQuery("UPDATE color SET rr="+rr,null);

		if (d != null ) 
			{
		     if  (d.moveToFirst()) 
		     	{
		           do {
		        
		        	   
		        	   }while (d.moveToNext());
		         }
			}

		d=sb.rawQuery("UPDATE color SET gg="+gg,null);

		if (d != null ) 
			{
		     if  (d.moveToFirst()) 
		     	{
		           do {
		        
		        	   
		        	   }while (d.moveToNext());
		         }
			}

		d=sb.rawQuery("UPDATE color SET bb="+bb,null);

		if (d != null ) 
			{
		     if  (d.moveToFirst()) 
		     	{
		           do {
		        
		        	   
		        	   }while (d.moveToNext());
		         }
			}
		sb.close();
		
		
		Intent gg=new Intent(this,MainActivity.class);
		startActivity(gg);
		overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		finish();
			
	}	

}