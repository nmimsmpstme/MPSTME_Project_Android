package com.example.recurso;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Test extends Activity implements OnClickListener, OnDismissListener{
	
	Random rm=new Random();
	SQLiteDatabase db;
	Cursor c;
	String lang,question,options1;
	int answer;
	Dialog d1;
	
	int number,count=0,marks=0;
	Button a1,a2,a3,a4;
	TextView tv1,tv2;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finaltest);
		
		
		a1= (Button)findViewById(R.id.ft_button1);
		a2= (Button)findViewById(R.id.ft_button2);
		a3= (Button)findViewById(R.id.ft_button3);
		a4= (Button)findViewById(R.id.ft_button4);
		tv1=(TextView)findViewById(R.id.ft_textView1);
		tv2=(TextView)findViewById(R.id.ft_textView2);
		
	Intent in=getIntent();
	 lang=in.getStringExtra("lang");
	 
	 number=1;
	 
	 
	 dataget();
	 
	 		a1.setOnClickListener(this);
	 		a2.setOnClickListener(this);
	 		a3.setOnClickListener(this);
	 		a4.setOnClickListener(this);
		
		
	}

	private void dataget() {
		// TODO Auto-generated method stub
	
	
		if(count<5)
			{count=count+1;
		tv1.setText(count+" /5");}
		else
			testfinish();
			
		
		 db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
			
			
			c=db.query(lang+"_test", null, null, null, null, null, null);
			c=db.rawQuery("select * from "+ lang+"_test" +" where _id = " + number,null);	
			
			if (c != null ) 
			{
		     if  (c.moveToFirst()) 
		     	{
		           do {
		        		question = c.getString(c.getColumnIndex("question"));
		        		options1 = c.getString(c.getColumnIndex("options"));
		        		answer=c.getInt(c.getColumnIndex("answer"));
		        		
		           		}while (c.moveToNext());
		         }
			}
		

			tv2.setText(question);
			
			
			
			
			int temp = 1,temp1 = 0,temp2=0,temp3=0;
			
			for( int j=1; j<options1.length(); j++)
			{
				if(temp==1)
					{
						if(options1.charAt(j)=='_')
						{
							temp1=j;
							temp=temp+1;
						}
						
					}
				else if(temp==2)
				{
					if(options1.charAt(j)=='_')
					{
						temp2=j;
						temp=temp+1;
					}
					
				}
				else if(temp==3)
				{
					if(options1.charAt(j)=='_')
					{
						temp3=j;
						temp=temp+1;
					}
					
				}
				
				
			}
			
			
			String many1=options1.substring(0, temp1);
			String many2=options1.substring(temp1+1, temp2);
			String many3=options1.substring(temp2+1, temp3);
			String many4=options1.substring(temp3+1, options1.length());
		
		
			a1.setText(many1);
			a2.setText(many2);
			a3.setText(many3);
			a4.setText(many4);
			
	}

	private void testfinish() {
		// TODO Auto-generated method stub
		
		d1=new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		d1.setContentView(R.layout.result);

		TextView result = (TextView) d1.findViewById(R.id.result_textView1);

		result.setText(marks+" out of 5" );
		
		LinearLayout ll1=(LinearLayout)d1.findViewById(R.id.result_ll1);

		
		ll1.setOnClickListener(this);
		d1.show();
		d1.setOnDismissListener(this);
		
		
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
		
		
		case R.id.result_ll1:
		{
		
			finish();
			overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		}
		
		case R.id.ft_button1:
		{
			if(answer==1)
			{
				marks=marks+1;
			}
			
			
			int Low = 1;
			int High = 4;
			int number1=(rm.nextInt(High-Low) + Low);
			number=number+number1;
			
			dataget();
		}
		break;
		
		
		case R.id.ft_button2:
		{
			if(answer==2)
			{
				marks=marks+1;
			}
		
			int Low = 1;
			int High = 4;
			int number1=(rm.nextInt(High-Low) + Low);
			
			number=number+number1;
			dataget();
		}
		break;
		
		case R.id.ft_button3:
		{
			if(answer==3)
			{
				marks=marks+1;
			}
			
			int Low = 1;
			int High = 4;
			int number1=(rm.nextInt(High-Low) + Low);
			
			number=number+number1;
			dataget();
		}
		break;
		
		case R.id.ft_button4:
		{
			if(answer==4)
			{
				marks=marks+1;
			}
			
			int Low = 1;
			int High = 4;
			int number1=(rm.nextInt(High-Low) + Low);
			
			number=number+number1;
			dataget();
		}
		break;
		}
		
	}

	@Override
	public void onDismiss(DialogInterface arg0) {
		// TODO Auto-generated method stub
		finish();
		overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
	}
}
