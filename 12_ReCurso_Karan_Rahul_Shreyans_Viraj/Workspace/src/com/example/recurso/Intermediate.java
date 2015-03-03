package com.example.recurso;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Intermediate extends Activity {


	Button alphabets,people1;
	String bstring;
	Dialog d1;
	int total=0;
	int count;
	String lang;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intermediate);
	
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");
	}

	
	
	public void jump (View v) {
		// TODO Auto-generated method stub
		
		int iidd=v.getId();
		final Button gghh=(Button)findViewById(iidd);
		bstring=gghh.getText().toString();
		gghh.setAlpha((float) 0.5);
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		  @Override
		  public void run() {
		   gghh.setAlpha(1);
		  }
		}, 100);
		

		if(bstring.equals("Articles"))
		{
			Intent play=new Intent(this,dispmeaning.class);
			play.putExtra("lang", lang);
			play.putExtra("level", "basics");
			play.putExtra("number", "1");
			startActivity(play);
			overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		}

		else
		{
			Intent play=new Intent(this,Game.class);
			play.putExtra("lang", lang);
			play.putExtra("name", bstring);
			play.putExtra("number", "1");
			startActivity(play);
			overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		}
	}

	public void progress (View v) {
		// TODO Auto-generated method stub
		

		d1=new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		d1.setContentView(R.layout.progress);
		
		total=0;
		TextView p1 = (TextView)d1.findViewById(R.id.prog_textView1);
		int temp=retrieve("People1");
		p1.setText("People1= "+temp+"%");
		
		total=0;
		TextView room = (TextView)d1.findViewById(R.id.prog_textView2);
		room.setText("Room= "+retrieve("Room")+"%");
		
		total=0;
		TextView colour = (TextView)d1.findViewById(R.id.prog_textView3);
		colour.setText("Colour= "+retrieve("Colour")+"%");

		total=0;
		TextView animals = (TextView)d1.findViewById(R.id.prog_textView4);
		animals.setText("Animals= "+retrieve("Animals")+"%");
		
		d1.show();
		
		}



	private int retrieve(String name) {
		// TODO Auto-generated method stub
		SQLiteDatabase db;
		Cursor c;
	
db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		
		
		c=db.query(lang+"_"+name, null, null, null, null, null, null);
		c=db.rawQuery("select * from "+ lang+"_"+name,null);	
		
		if (c != null ) 
		{
	     if  (c.moveToFirst()) 
	     	{
	           do {
	        		count=c.getCount();
	        		}while (c.moveToNext());
	         }
		}
		
		c.close();
		
		
		c=db.query(lang+"_"+name, null, null, null, null, null, null);
		for(int h=1;h<=count;h++)
		{
			
			c=db.rawQuery("select status from "+ lang+"_"+name+" where _id = "+h,null);	
			if (c != null ) 
			{
		     if  (c.moveToFirst()) 
		     	{
		           do {
		        		total=total+c.getInt((c.getColumnIndex("status")));
		           		}while (c.moveToNext());
		         }
			}
			
		}
		c.close();
		db.close();

		total=(total*100)/count;
		
return total;
	}

}