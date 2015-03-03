package com.example.recurso;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Days extends Activity implements OnClickListener, OnInitListener {
	
	Button m1,m2,m3,m4,m5,m6,m7;
	String lang;
	private TextToSpeech myTTS;

private int MY_DATA_CHECK_CODE = 0;
	
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.days);
		Toast.makeText(this,"Click The Buttons To \n Hear Their Pronounciations", Toast.LENGTH_LONG).show();
		m1=(Button)findViewById(R.id.day_button1);
		m2=(Button)findViewById(R.id.day_button2);
		m3=(Button)findViewById(R.id.day_button3);
		m4=(Button)findViewById(R.id.day_button4);
		m5=(Button)findViewById(R.id.day_button5);
		m6=(Button)findViewById(R.id.day_button6);
		m7=(Button)findViewById(R.id.day_button7);
		
		Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
		
		
		m1.setOnClickListener(this);
		m2.setOnClickListener(this);
		m3.setOnClickListener(this);
		m4.setOnClickListener(this);
		m5.setOnClickListener(this);
		m6.setOnClickListener(this);
		m7.setOnClickListener(this);
		
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");
		 
		 if(lang.equals("French"))
		 {
			 m1.setText("lundi");
			 m1.setBackgroundResource(R.drawable.fmon);
			 
			 m2.setText("mardi");
			 m2.setBackgroundResource(R.drawable.ftue);
			 
			 m3.setText("mercredi");
			 m3.setBackgroundResource(R.drawable.fwed);
			 
			 m4.setText("jeudi");
			 m4.setBackgroundResource(R.drawable.fthur);
			 
			 m5.setText("vendredi");
			 m5.setBackgroundResource(R.drawable.ffri);
			 
			 m6.setText("samedi");
			 m6.setBackgroundResource(R.drawable.fsat);
			 
			 m7.setText("dimanche");
			 m7.setBackgroundResource(R.drawable.fsun);
			 
		 }
		
		 if(lang.equals("German"))
		 {
			 m1.setText("Montag");
			 m1.setBackgroundResource(R.drawable.gmon);
			 
			 m2.setText("Dienstag");
			 m2.setBackgroundResource(R.drawable.gtue);
			 
			 m3.setText("Mittwoch");
			 m3.setBackgroundResource(R.drawable.gwed);
			 
			 m4.setText("Donnerstag");
			 m4.setBackgroundResource(R.drawable.gthur);
			 
			 m5.setText("Freitag");
			 m5.setBackgroundResource(R.drawable.gfri);
			 
			 m6.setText("Samstag");
			 m6.setBackgroundResource(R.drawable.gsat);
			 
			 m7.setText("Sonntag");
			 m7.setBackgroundResource(R.drawable.gsun);
			 
		 }
		 
		 if(lang.equals("Italian"))
		 {
			 m1.setText("lunedì");
			 m1.setBackgroundResource(R.drawable.imonday);
			 
			 m2.setText("martedì");
			 m2.setBackgroundResource(R.drawable.ituesday);
			 
			 m3.setText("mercoledì");
			 m3.setBackgroundResource(R.drawable.iwednesday);
			 
			 m4.setText("giovedì");
			 m4.setBackgroundResource(R.drawable.ithursday);
			 
			 m5.setText("venerdi");
			 m5.setBackgroundResource(R.drawable.ifriday);
			 
			 m6.setText("sabato");
			 m6.setBackgroundResource(R.drawable.isaturday);
			 
			 m7.setText("domenica");
			 m7.setBackgroundResource(R.drawable.isunday);
			 
		 }
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		int iidd=v.getId();
		final Button gghh=(Button)findViewById(iidd);
		String bstring=gghh.getText().toString();
		gghh.setAlpha((float) 0.5);
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		  @Override
		  public void run() {
		    gghh.setAlpha(1);
		  }
		}, 100);
		 
		 myTTS.speak(bstring, TextToSpeech.QUEUE_FLUSH, null);
		
		
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

	public void onInit(int initStatus) {

		if (initStatus == TextToSpeech.SUCCESS) {
			if(myTTS.isLanguageAvailable(Locale.FRENCH)==TextToSpeech.LANG_AVAILABLE && lang.equals("French"))
				myTTS.setLanguage(Locale.FRENCH);
			if(myTTS.isLanguageAvailable(Locale.GERMAN)==TextToSpeech.LANG_AVAILABLE && lang.equals("German"))
				myTTS.setLanguage(Locale.GERMAN);
			if(myTTS.isLanguageAvailable(Locale.ITALIAN)==TextToSpeech.LANG_AVAILABLE && lang.equals("Italian"))
				myTTS.setLanguage(Locale.ITALIAN);
			
		}
		else if (initStatus == TextToSpeech.ERROR) {
			Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
		}
	}
}

