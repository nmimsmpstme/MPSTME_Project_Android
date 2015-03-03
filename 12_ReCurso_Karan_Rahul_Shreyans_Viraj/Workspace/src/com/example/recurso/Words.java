package com.example.recurso;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Words extends Activity implements OnClickListener, TextWatcher, OnInitListener, OnItemSelectedListener{

private TextToSpeech myTTS;
private int MY_DATA_CHECK_CODE = 0;

AutoCompleteTextView enter_word;
Button translate,play1,play2;
TextView word,sentence,eng_sent;
SQLiteDatabase db;
LinearLayout layout_words;
Cursor c;
Spinner w_lang;
String[] language =new String[100];
int temp=0;

@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trans_words);

		Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);

        
		enter_word=(AutoCompleteTextView)findViewById(R.id.traword_actv1);
		translate=(Button)findViewById(R.id.traword_button1);
		word=(TextView)findViewById(R.id.traword_textView1);
		sentence=(TextView)findViewById(R.id.traword_textView2);
		eng_sent=(TextView)findViewById(R.id.traword_textView4);
		play1=(Button)findViewById(R.id.traword_button2);
		play2=(Button)findViewById(R.id.traword_button3);
		w_lang=(Spinner)findViewById(R.id.traword_spinner1);
		layout_words=(LinearLayout)findViewById(R.id.layout_words);
		
		translate.setOnClickListener(this);
		play1.setOnClickListener(this);
		play2.setOnClickListener(this);
		layout_words.setOnClickListener(this);
		String[] items = new String[]{"German","French","Italian"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
		w_lang.setAdapter(adapter);
		w_lang.setOnItemSelectedListener(this);
		
	if(temp<100)
	{
		for(int i=temp;i<100;i++)
		language[i]=".";
	}
	
	enter_word.addTextChangedListener(this);	

	  
		
	}
	@Override
	public void onClick(final View v) {
		// TODO Auto-generated method stub
		
		
switch (v.getId()){
		
		case R.id.layout_words:
			InputMethodManager inputManager = (InputMethodManager)
            getSystemService(Context.INPUT_METHOD_SERVICE); 

			inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
            InputMethodManager.HIDE_NOT_ALWAYS);
		break;
		

case R.id.traword_button1:
		{
			v.setAlpha((float) 0.5);
			final Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
			  @Override
			  public void run() {
			   v.setAlpha(1);
			  }
			}, 100);		
			String text=null;
			String text1=null;
			String text2=null;
			db = openOrCreateDatabase("WORDS", MODE_PRIVATE, null);
			
			c=db.query(w_lang.getSelectedItem().toString(), null, null, null, null, null, null);
			
			c=db.rawQuery("select * from "+ w_lang.getSelectedItem().toString() +" where english = '" + enter_word.getText().toString()+"'", null);
			if (c != null ) 
			{
		     if  (c.moveToFirst()) 
		     	{
		           do {
		        	   text=c.getString(c.getColumnIndex(w_lang.getSelectedItem().toString()));
		        	   text1=c.getString(c.getColumnIndex("sentence"));
		        	    text2 = c.getString(c.getColumnIndex("Eng_sent"));
		        	   
		           		}while (c.moveToNext());
		         }
			}
			c.close();
			db.close();
			eng_sent.setText(text2);
			word.setText(text);
			sentence.setText(text1);
		
			if(word.length()<1)
			{
				Toast.makeText(this, "word not available", Toast.LENGTH_SHORT).show();
			}
		
		}
break;

case R.id.traword_button2:
		{
			v.setAlpha((float) 0.5);
			final Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
			  @Override
			  public void run() {
			   v.setAlpha(1);
			  }
			}, 100);		
			if(myTTS.isLanguageAvailable(Locale.FRENCH)==TextToSpeech.LANG_AVAILABLE && w_lang.getSelectedItem().toString().equals("French"))
				myTTS.setLanguage(Locale.FRENCH);
			if(myTTS.isLanguageAvailable(Locale.GERMAN)==TextToSpeech.LANG_AVAILABLE && w_lang.getSelectedItem().toString().equals("German"))
				myTTS.setLanguage(Locale.GERMAN);
			if(myTTS.isLanguageAvailable(Locale.ITALIAN)==TextToSpeech.LANG_AVAILABLE && w_lang.getSelectedItem().toString().equals("Italian"))
				myTTS.setLanguage(Locale.ITALIAN);
			
			myTTS.speak(word.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
		}
break;

case R.id.traword_button3:
		{
			v.setAlpha((float) 0.5);
			final Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
			  @Override
			  public void run() {
			   v.setAlpha(1);
			  }
			}, 100);		
			if(myTTS.isLanguageAvailable(Locale.FRENCH)==TextToSpeech.LANG_AVAILABLE && w_lang.getSelectedItem().toString().equals("French"))
				myTTS.setLanguage(Locale.FRENCH);
			if(myTTS.isLanguageAvailable(Locale.GERMAN)==TextToSpeech.LANG_AVAILABLE && w_lang.getSelectedItem().toString().equals("German"))
				myTTS.setLanguage(Locale.GERMAN);
			if(myTTS.isLanguageAvailable(Locale.ITALIAN)==TextToSpeech.LANG_AVAILABLE && w_lang.getSelectedItem().toString().equals("Italian"))
				myTTS.setLanguage(Locale.ITALIAN);
			
			myTTS.speak(sentence.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
		}
break;
}		
	}
	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}
	@SuppressLint("DefaultLocale")
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
		
		temp=0;
		for(int i=temp;i<100;i++)
			language[i]=".";
		
		
		
		String text=null;
		
		if(!s.toString().equals(""))
		{
		db = openOrCreateDatabase("WORDS", MODE_PRIVATE, null);
		
		
		c=db.query(w_lang.getSelectedItem().toString(), null, null, null, null, null, null);
		
		c=db.rawQuery("select * from "+ w_lang.getSelectedItem().toString() +" where english like '" + s.toString().toLowerCase() + "%'", null);
		if (c != null ) 
		{
	
	     if  (c.moveToFirst()) 
	     	{
	           do {
	        	   text=c.getString(c.getColumnIndex("english"));
	        	   language[temp]=text;
	         	   temp=temp+1;
	         	   
	           		}while (c.moveToNext());
	         }
		}
		c.close();
		db.close();
		}
		enter_word.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, language));
		enter_word.setThreshold(1);
       enter_word.setTextColor(Color.RED); 
       
       
	
	}
	@Override
	
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
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		if(word.getText().toString().equals("")==false)
		{
			String text=null;
			String text1=null;
			String text2=null;
			
db = openOrCreateDatabase("WORDS", MODE_PRIVATE, null);
			
			c=db.query(w_lang.getSelectedItem().toString(), null, null, null, null, null, null);
			
			c=db.rawQuery("select * from "+ w_lang.getSelectedItem().toString() +" where english = '" + enter_word.getText().toString()+"'", null);
			if (c != null ) 
			{
		     if  (c.moveToFirst()) 
		     	{
		           do {
		        	   text=c.getString(c.getColumnIndex(w_lang.getSelectedItem().toString()));
		        	   text1=c.getString(c.getColumnIndex("sentence"));
		        	   text2=c.getString(c.getColumnIndex("Eng_sent"));
		           		}while (c.moveToNext());
		         }
			}
			c.close();
			db.close();
			word.setText(text);
			sentence.setText(text1);
			eng_sent.setText(text2);
			
			
		}
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}