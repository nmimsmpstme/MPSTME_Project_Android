package com.example.recurso;

import java.util.Locale;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity implements OnClickListener, OnInitListener, OnDismissListener {
	
	SQLiteDatabase db,db1;
	Cursor c,d;
	int what_to_disp=0,number,count; 
	String lang,name,level,sentence,answer,voice,manywords,answer1;
	TextView tv1,tv2,tv3,tv11,tv12,tv13,tv14,tvtop;
	EditText et1;
	Button btn1,btn2,btn3,btn4;
	LinearLayout ll1,ll3,ll4;
	Dialog d1,d2;
	int rr,gg,bb;
	 
	
	 
	private TextToSpeech myTTS;
	private int MY_DATA_CHECK_CODE = 0;

	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		
		new AlertDialog.Builder(Game.this)  
		.setMessage("Leaving this chapter now will delete all your progress for this chapter. \n " +
				"You will need to start all over again.")  
		.setCancelable(false)  
		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {  
		    public void onClick(DialogInterface dialog, int which)   
		    {  
		          
		    	db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		    	finish();  
		    	overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
		    }  
		})    
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {  
		      public void onClick(DialogInterface dialog, int which)   
		      {  
		    	  dialog.dismiss();  
		      }  
		}).show();  
		
		
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");
		 name=in.getStringExtra("name");
		 level=in.getStringExtra("level");
		 String number1=in.getStringExtra("number");
		 
		 number=Integer.parseInt(number1);
		 
		 
		 
		 db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
			
			
			c=db.query(lang+"_"+name, null, null, null, null, null, null);
			c=db.rawQuery("select * from "+ lang+"_"+name +" where _id = " + number,null);	
			
			if (c != null ) 
			{
		     if  (c.moveToFirst()) 
		     	{
		           do {
		        		what_to_disp = c.getInt(c.getColumnIndex("typ"));
		
		           		}while (c.moveToNext());
		         }
			}
		
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
			db.close();
			
			db = openOrCreateDatabase("TEMP", MODE_PRIVATE, null);
			
			
			c=db.query("color", null, null, null, null, null, null);
			c=db.rawQuery("select * from color ",null);	
			
			if (c != null ) {
			     if  (c.moveToFirst()) {
			           do {
			        
			        	   rr=c.getInt(c.getColumnIndex("rr"));
			        	   gg=c.getInt(c.getColumnIndex("gg"));
			        	   bb=c.getInt(c.getColumnIndex("bb"));
			           
			           }while (c.moveToNext());
			         }
			    }


			c.close();
			db.close();
		
		
			if(what_to_disp==0 )
			{
				finish();
				overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
			}
			
			
		if(what_to_disp==1 )
		{
			setContentView(R.layout.game_trans);	
			tvtop=(TextView)findViewById(R.id.gametrans_tv1);
	        tvtop.setText("Lesson "+number+" of "+ count);
			ll1=(LinearLayout)findViewById(R.id.game_trans_layout);
	        ll1.setOnClickListener(this);
	        ll1.setBackgroundColor(Color.rgb(rr, gg, bb));
			convert_to_german();
			
			
		}
		
		if(what_to_disp==2)
		{
			setContentView(R.layout.game_trans);	
			tvtop=(TextView)findViewById(R.id.gametrans_tv1);
			tvtop.setText("Lesson "+number+" of "+ count);
	        
			ll1=(LinearLayout)findViewById(R.id.game_trans_layout);
	        ll1.setOnClickListener(this);
	        ll1.setBackgroundColor(Color.rgb(rr, gg, bb));
			convert_to_german();
		}
		
		
		if(what_to_disp==3 )
		{
			setContentView(R.layout.game_sound);	
			
			tvtop=(TextView)findViewById(R.id.gamesou_textView1);
			tvtop.setText("Lesson "+number+" of "+ count);
	        
			Intent checkTTSIntent = new Intent();
	        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
	        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
	        ll3=(LinearLayout)findViewById(R.id.game_sound_layout);
	        ll3.setOnClickListener(this);
	        ll3.setBackgroundColor(Color.rgb(rr, gg, bb));
			press_to_play();		}

		if(what_to_disp==4 )
		{
			setContentView(R.layout.game_select);
			tvtop=(TextView)findViewById(R.id.gamesel_tv1);
			tvtop.setText("Lesson "+number+" of "+ count);
			ll4=(LinearLayout)findViewById(R.id.gamesel_ll1);
			ll4.setBackgroundColor(Color.rgb(rr, gg, bb));
			
			set_on_buttons();
		}
		
	}

	private void press_to_play() {
		// TODO Auto-generated method stub
		tv2=(TextView)findViewById(R.id.gamesou_textView2);
		
		btn1=(Button)findViewById(R.id.gamesou_button1);
		btn2=(Button)findViewById(R.id.gamesou_button2);
		btn3=(Button)findViewById(R.id.gamesou_button3);
		et1=(EditText)findViewById(R.id.gamesou_editText1);
		
		db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		c=db.query(lang+"_"+name, null, null, null, null, null, null);
		c=db.rawQuery("select * from "+ lang+"_"+name +" where _id = " + number,null);	
		
		if (c != null ) 
		{				
	     if  (c.moveToFirst()) 
	     	{
	           do {
	        	   		voice=c.getString(c.getColumnIndex("english"));
	        	   		answer=c.getString(c.getColumnIndex("German"));
	        	   		sentence=c.getString(c.getColumnIndex("sentence"));
	        	   		tv2.setText(c.getString(c.getColumnIndex("sentence")));
	           		}while (c.moveToNext());
	         }
		}
c.close();
		db.close();
	
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
	}

	private void set_on_buttons() {
		// TODO Auto-generated method stub
		tv2=(TextView)findViewById(R.id.gamesel_tv2);
		
		btn1=(Button)findViewById(R.id.gamesel_btn1);
		btn2=(Button)findViewById(R.id.gamesel_btn2);
		btn3=(Button)findViewById(R.id.gamesel_btn3);
		btn4=(Button)findViewById(R.id.gamesel_btn4);
		
		tv11=(TextView)findViewById(R.id.gamesel_tv11);
		tv12=(TextView)findViewById(R.id.gamesel_tv12);
		tv13=(TextView)findViewById(R.id.gamesel_tv13);
		tv14=(TextView)findViewById(R.id.gamesel_tv14);
		
		String word=null;
		db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		
		
		c=db.query(lang+"_"+name, null, null, null, null, null, null);
		c=db.rawQuery("select * from "+ lang+"_"+name +" where _id = " + number,null);	
		
		if (c != null ) 
		{
	     if  (c.moveToFirst()) 
	     	{
	           do {
	        	   		word=c.getString(c.getColumnIndex("english"));
	        	   		answer=c.getString(c.getColumnIndex("German"));
	        	   		sentence=c.getString(c.getColumnIndex("sentence"));
	        	   		tv2.setText(c.getString(c.getColumnIndex("sentence")));
	        	   		manywords=c.getString(c.getColumnIndex("manywords"));
	           		}while (c.moveToNext());
	         }
		}
c.close();
		db.close();
	
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		
		
		String img1=word.substring(0, 4);
		String img2=word.substring(4, 8);
		String img3=word.substring(8, 12);
		String img4=word.substring(12, 16);
		
		int temp = 1,temp1 = 0,temp2=0,temp3=0;
		
		for( int j=1; j<manywords.length(); j++)
		{
			if(temp==1)
				{
					if(manywords.charAt(j)=='_')
					{
						temp1=j;
						temp=temp+1;
					}
					
				}
			else if(temp==2)
			{
				if(manywords.charAt(j)=='_')
				{
					temp2=j;
					temp=temp+1;
				}
				
			}
			else if(temp==3)
			{
				if(manywords.charAt(j)=='_')
				{
					temp3=j;
					temp=temp+1;
				}
				
			}
		
			
		}
		
		
		String many1=manywords.substring(0, temp1);
		String many2=manywords.substring(temp1+1, temp2);
		String many3=manywords.substring(temp2+1, temp3);
		String many4=manywords.substring(temp3+1, manywords.length());
	
	
		tv11.setText(many1);
		tv12.setText(many2);
		tv13.setText(many3);
		tv14.setText(many4);
	
		if(Integer.parseInt(answer)==1)
		{
			voice=img1;
			answer1=many1;
		}
		if(Integer.parseInt(answer)==2)
		{
			voice=img2;
			answer1=many2;
		}
		if(Integer.parseInt(answer)==3)
		{
			voice=img3;
			answer1=many3;
		}
		if(Integer.parseInt(answer)==4)
		{
			voice=img4;
			answer1=many4;
		}
		
		int resID = getResources().getIdentifier(img1, "drawable", getPackageName());
		btn1.setBackgroundResource(resID );
		resID = getResources().getIdentifier(img2, "drawable", getPackageName());
		btn2.setBackgroundResource(resID );
		resID = getResources().getIdentifier(img3, "drawable", getPackageName());
		btn3.setBackgroundResource(resID );
		resID = getResources().getIdentifier(img4, "drawable", getPackageName());
		btn4.setBackgroundResource(resID );

	}

	private void convert_to_german() {
		// TODO Auto-generated method stub
		
		tv1=(TextView)findViewById(R.id.gametrans_tv1);
		tv2=(TextView)findViewById(R.id.gametrans_tv2);
		tv3=(TextView)findViewById(R.id.gametrans_tv3);
		et1=(EditText)findViewById(R.id.gametrans_ed1);
		btn1=(Button)findViewById(R.id.gametrans_btn1);
		
		
		 
		 db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
			
			
			c=db.query(lang+"_"+name, null, null, null, null, null, null);
			c=db.rawQuery("select * from "+ lang+"_"+name +" where _id = " + number,null);	
			
			if (c != null ) 
			{
		     if  (c.moveToFirst()) 
		     	{
		           do {
		        		tv2.setText(c.getString(c.getColumnIndex("sentence")));
		        		tv3.setText(c.getString(c.getColumnIndex("english")));
		        		voice=c.getString(c.getColumnIndex("english"));
		        		sentence=c.getString(c.getColumnIndex("sentence"));
		        		answer=c.getString(c.getColumnIndex("German"));
		           		}while (c.moveToNext());
		         }
			}
	c.close();
			db.close();
		
			btn1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		
		case R.id.dialwr_ll1:
			d1.dismiss();
			break;
		
		case R.id.dialrem_ll1:
			d2.dismiss();
			break;
		
		
		case R.id.game_sound_layout:
			InputMethodManager inputManager = (InputMethodManager)
            getSystemService(Context.INPUT_METHOD_SERVICE); 

			inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
            InputMethodManager.HIDE_NOT_ALWAYS);
			break;
		
		case R.id.game_trans_layout:
			InputMethodManager inputManager1 = (InputMethodManager)
            getSystemService(Context.INPUT_METHOD_SERVICE); 

			inputManager1.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
            InputMethodManager.HIDE_NOT_ALWAYS);
			break;
		
		
		case R.id.gametrans_btn1:
			if(answer.equals(et1.getText().toString()))
			{
				Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
				dbcorrect();
				check_the_answer();		
			}
			else
				wrongselect();	
			break;
		
		
		case R.id.gamesel_btn1:
			if(answer.equals("1"))
			{
				Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
				remember();		
			}
			else
				wrongselect();					
			break;
			
		case R.id.gamesel_btn2:
			if(answer.equals("2"))
			{
				Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
				remember();		
			}
			else
				wrongselect();	
			break;
			
		case R.id.gamesel_btn3:
			if(answer.equals("3"))
			{
				Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
				remember();		
			}
			else
				wrongselect();	
			break;

		case R.id.gamesel_btn4:
			if(answer.equals("4"))
			{
				Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
				remember();
				
				
			}
			else
				wrongselect();	
			break;
			
		case R.id.gamesou_button1:
			myTTS.setSpeechRate(1);
			myTTS.speak(voice, TextToSpeech.QUEUE_FLUSH, null);
			
		break;
			
		case R.id.gamesou_button2:
			myTTS.setSpeechRate((float)0.5);
			myTTS.speak(voice, TextToSpeech.QUEUE_FLUSH, null);
			
			
		break;

		case R.id.gamesou_button3:
			if(answer.equals(et1.getText().toString()))
			{
				dbcorrect();
				check_the_answer();	
				myTTS.shutdown();
			}
			else
				wrongselect();	
				
	
		break;
	
		}
	}

	private void remember() {
		// TODO Auto-generated method stub

		if(what_to_disp==4)
		{

			d2=new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
			d2.setContentView(R.layout.dialog_remember);
			
			TextView question = (TextView) d2.findViewById(R.id.dialrem_tv3);
			TextView qword = (TextView) d2.findViewById(R.id.dialrem_tv4);
			TextView ans = (TextView) d2.findViewById(R.id.dialrem_tv6);
			TextView te=(TextView) d2.findViewById(R.id.dialrem_tv1);
			LinearLayout ll2=(LinearLayout)d2.findViewById(R.id.dialrem_ll1);
			
			te.setText("Remember");
			question.setText(sentence+"");
			int resID = getResources().getIdentifier(voice, "drawable", getPackageName());
			qword.setBackgroundResource(resID);
			ans.setText(answer1+"");
			
			
			ll2.setOnClickListener(this);
			d2.show();
			d2.setOnDismissListener(this);
		}
		
	}
	private void wrongselect() {
		// TODO Auto-generated method stub
		
		d1=new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		d1.setContentView(R.layout.dialog_wrong);
		
		TextView question = (TextView) d1.findViewById(R.id.dialwr_tv3);
		TextView qword = (TextView) d1.findViewById(R.id.dialwr_tv4);
		TextView ans = (TextView) d1.findViewById(R.id.dialwr_tv6);
		LinearLayout ll1=(LinearLayout)d1.findViewById(R.id.dialwr_ll1);

		if(what_to_disp==4)
		{
			question.setText(sentence+"");
			int resID = getResources().getIdentifier(voice, "drawable", getPackageName());
			qword.setBackgroundResource(resID);
			ans.setText(answer1+"");
			
		}
		else
		{	
			question.setText(sentence+"");
			qword.setText(voice+"");
			ans.setText(answer+"");
			
		}
		ll1.setOnClickListener(this);
		d1.show();
		d1.setOnDismissListener(this);
		
		
	}

	private void dbcorrect() {
		// TODO Auto-generated method stub
		
		db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		
		
		c=db.query(lang+"_"+name, null, null, null, null, null, null);
		c=db.rawQuery("UPDATE " + lang + "_" + name + " SET status = 1 where _id = " + number,null);
		if (c != null ) 
		{
	     if  (c.moveToFirst()) 
	     	{
	           do {
	        
	        	   
	        	   }while (c.moveToNext());
	         }
		}

		c.close();
		db.close();
		

		
	}
	
	
	private void check_the_answer() {
	
		Intent play=new Intent(this,Game.class);
		play.putExtra("lang", lang);
		play.putExtra("name", name);
		play.putExtra("level", level);
		number=number+1;
		
		String hello=Integer.toString(number);
		play.putExtra("number", hello);
		finish();
		startActivity(play);
		overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == MY_DATA_CHECK_CODE) {
			if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {


				myTTS = new TextToSpeech(this, this);
			}
			else {

				Intent installTTSIntent = new Intent();
				installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
				startActivity(installTTSIntent);
			}
		}
	
	}

	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub

		if(myTTS.isLanguageAvailable(Locale.FRENCH)==TextToSpeech.LANG_AVAILABLE && lang.equals("French"))
			myTTS.setLanguage(Locale.FRENCH);
		if(myTTS.isLanguageAvailable(Locale.GERMAN)==TextToSpeech.LANG_AVAILABLE && lang.equals("German"))
			myTTS.setLanguage(Locale.GERMAN);
		if(myTTS.isLanguageAvailable(Locale.ITALIAN)==TextToSpeech.LANG_AVAILABLE && lang.equals("Italian"))
			myTTS.setLanguage(Locale.ITALIAN);
		
	
		
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		// TODO Auto-generated method stub
		if(what_to_disp==4)
		{
			dbcorrect();
			check_the_answer();	
		}
		else
		{
		check_the_answer();
		}
	}	


}
