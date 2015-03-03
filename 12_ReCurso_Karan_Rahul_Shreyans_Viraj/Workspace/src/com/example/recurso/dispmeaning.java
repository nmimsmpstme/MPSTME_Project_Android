package com.example.recurso;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class dispmeaning extends Activity implements OnClickListener{

	SQLiteDatabase db;
	Cursor c;
	TextView eng,language,esent,langsent,one,two,page;
	String lang,level,eng1,language1,esent1,langsent1;;
	int number,total;
	Button pre,next;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_meanings);
		
		eng=(TextView)findViewById(R.id.dmg_eng_word);
		language=(TextView)findViewById(R.id.dmg_lang_word);
		esent=(TextView)findViewById(R.id.dmg_sent_sent);
		langsent=(TextView)findViewById(R.id.dmg_lang_sent_sent);
		page=(TextView)findViewById(R.id.dmg_page);
		
		pre=(Button)findViewById(R.id.dmg_button1);
		next=(Button)findViewById(R.id.dmg_button2);
		
		one=(TextView)findViewById(R.id.dmg_lang);
		two=(TextView)findViewById(R.id.dmg_lang_sent);
		
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");
		 level=in.getStringExtra("level");
		 String number1=in.getStringExtra("number");
		 number=Integer.parseInt(number1);
		
		 pre.setOnClickListener(this);
		next.setOnClickListener(this);
		 
		one.setText(lang+"");
		two.setText(lang+"\n"+"Sentence");
		
	
	db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		
		
		c=db.query(lang+"_articles", null, null, null, null, null, null);
		c=db.rawQuery("select * from "+ lang+"_articles" ,null);	
		
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
	
	private void datadata() {
		// TODO Auto-generated method stub
		db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		
		
		c=db.query(lang+"_articles", null, null, null, null, null, null);
		c=db.rawQuery("select * from "+ lang+"_articles" +" where _id = " + number,null);	
		
		if (c != null ) 
		{
	     if  (c.moveToFirst()) 
	     	{
	           do {
	        		
	        	   eng1=c.getString(c.getColumnIndex("English"));
	        	   language1=c.getString(c.getColumnIndex(lang));
	        	   esent1=c.getString(c.getColumnIndex("Sentence"));
	        	   langsent1=c.getString(c.getColumnIndex("langsent"));
	        	   	
	           		}while (c.moveToNext());
	         }
		}
		
		c.close();
		db.close();
	
		eng.setText(eng1);
		language.setText(language1);
		esent.setText(esent1);
		langsent.setText(langsent1);
		page.setText("Page "+ number + "/"+total);
		
		if(language1.equals(null))
		{
			
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
		
		
		case R.id.dmg_button1:
			if(number>1)
			{
				number=number-1;
				datadata();
			}
		break;
		
		case R.id.dmg_button2:
			if(number<total)
			{
				number=number+1;
				datadata();
			}
		break;
			
		}	
	}
}
