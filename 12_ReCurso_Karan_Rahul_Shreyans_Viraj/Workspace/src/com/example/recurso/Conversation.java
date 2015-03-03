package com.example.recurso;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Conversation extends Activity implements OnClickListener{

	SQLiteDatabase db;
	Cursor c;
	TextView eng,ger;
	String lang,name,l,en;
	int number,total;
	Button pre,next,img1,img2;
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conversation);
		
		img1=(Button)findViewById(R.id.conv_button1);
		img2=(Button)findViewById(R.id.conv_button2);
		
		eng=(TextView)findViewById(R.id.conv_textView2);
		ger=(TextView)findViewById(R.id.conv_textView1);
		
		pre=(Button)findViewById(R.id.conv_button3);
		next=(Button)findViewById(R.id.conv_button4);
		
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");
		 name=in.getStringExtra("name");
		 String number1=in.getStringExtra("number");
		 number=Integer.parseInt(number1);
	
		 setphotoonbutton();
		 
		 pre.setOnClickListener(this);
			next.setOnClickListener(this);
			 
		 
		 db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
			
			
		 c=db.query(lang+"_"+name, null, null, null, null, null, null);
			c=db.rawQuery("select * from "+ lang+"_"+name,null);	
				
			if (c != null ) 
			{
		     if  (c.moveToFirst()) 
		     	{
		           do {
		        		total=c.getCount();
		           		}while (c.moveToNext());
		         }
			}
			
			c.close();
			db.close();
	
			datadata();
		
	}

	private void setphotoonbutton() {
		// TODO Auto-generated method stub
		
		pre.setBackgroundResource(R.drawable.prev11);
		next.setBackgroundResource(R.drawable.next11);
		
		if(name.equals("conversation1"))
		{
			img1.setBackgroundResource(R.drawable.girl1);
			img2.setBackgroundResource(R.drawable.girl2);
		}
		
	}

	@SuppressLint("NewApi")
	private void datadata() {
		// TODO Auto-generated method stub
		db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		
		
		c=db.query(lang+"_"+name, null, null, null, null, null, null);
		c=db.rawQuery("select * from "+ lang+"_"+name +" where _id = " + number,null);	
		
		if (c != null ) 
		{
	     if  (c.moveToFirst()) 
	     	{
	           do {
	        		en = c.getString(c.getColumnIndex("english"));
	        		l=c.getString(c.getColumnIndex("language"));
	        		
	           		}while (c.moveToNext());
	         }
		}

		eng.setText(en);
		ger.setText(l);

		
		if(number%2==1)
		{
			eng.setGravity(Gravity.LEFT);
			ger.setGravity(Gravity.LEFT);
			
			eng.setBackgroundColor(Color.GREEN);
			ger.setBackgroundColor(Color.GREEN);
			
			img2.setAlpha((float) 0.5);
			img1.setAlpha(1);
			
		}
		else
		{
			eng.setGravity(Gravity.RIGHT);
			ger.setGravity(Gravity.RIGHT);
			
			eng.setBackgroundColor(Color.YELLOW);
			ger.setBackgroundColor(Color.YELLOW);
			
			img1.setAlpha((float) 0.5);
			img2.setAlpha(1);
		}
		
		
		if(number==1)
		 {
			 pre.setClickable(false);
		 }
		 else
		 {
			 pre.setClickable(true);
		 }
		
		 if(number==total)
		 {
			next.setClickable(false);
		 }
		 else
		 {
			next.setClickable(true);
		 }
	
	}
	
	@Override
	public void onClick(final View v) {
		// TODO Auto-generated method stub
	
		v.setAlpha((float) 0.5);
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		  @Override
		  public void run() {
		    v.setAlpha(1);
		  }
		}, 100);
		
		switch (v.getId())
		{
		
		case R.id.conv_button3:
			if(number>1)
			{
				number=number-1;
				datadata();
			}
			
		break;
		
		case R.id.conv_button4:
			if(number<total)
			{
				number=number+1;
				datadata();
			}
		break;
			
		}
		
	}
		
}
