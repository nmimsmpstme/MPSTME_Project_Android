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

public class months extends Activity implements OnClickListener, OnInitListener {
	
	Button m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12;
	String lang;
	private TextToSpeech myTTS;
	//status check code
private int MY_DATA_CHECK_CODE = 0;
	
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.months);
		Toast.makeText(this,"Click The Buttons To \n Hear Their Pronounciations", Toast.LENGTH_LONG).show();
		m1=(Button)findViewById(R.id.mon_button1);
		m2=(Button)findViewById(R.id.mon_button2);
		m3=(Button)findViewById(R.id.mon_button3);
		m4=(Button)findViewById(R.id.mon_button4);
		m5=(Button)findViewById(R.id.mon_button5);
		m6=(Button)findViewById(R.id.mon_button6);
		m7=(Button)findViewById(R.id.mon_button7);
		m8=(Button)findViewById(R.id.mon_button8);
		m9=(Button)findViewById(R.id.mon_button9);
		m10=(Button)findViewById(R.id.mon_button10);
		m11=(Button)findViewById(R.id.mon_button11);
		m12=(Button)findViewById(R.id.mon_button12);
		
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
		m8.setOnClickListener(this);
		m9.setOnClickListener(this);
		m10.setOnClickListener(this);
		m11.setOnClickListener(this);
		m12.setOnClickListener(this);
		
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");
		 
		 if(lang.equals("French"))
		 {
			 m1.setText("janvier");
			 m1.setBackgroundResource(R.drawable.fjan);
			 
			 m2.setText("février");
			 m2.setBackgroundResource(R.drawable.ffeb);
			 
			 m3.setText("mars");
			 m3.setBackgroundResource(R.drawable.fmar);
			 
			 m4.setText("avril");
			 m4.setBackgroundResource(R.drawable.fapril);
			 
			 m5.setText("mai");
			 m5.setBackgroundResource(R.drawable.fmay);
			 
			 m6.setText("juin");
			 m6.setBackgroundResource(R.drawable.fjune);
			 
			 m7.setText("juillet");
			 m7.setBackgroundResource(R.drawable.fjuly);
			 
			 m8.setText("août");
			 m8.setBackgroundResource(R.drawable.faug);
			 
			 m9.setText("septembre");
			 m9.setBackgroundResource(R.drawable.fsept);
			 
			 m10.setText("octobre");
			 m10.setBackgroundResource(R.drawable.foct);
			 
			 m11.setText("novembre");
			 m11.setBackgroundResource(R.drawable.fnov);
			 
			 m12.setText("décembre");
			 m12.setBackgroundResource(R.drawable.fdec);
			  
		 }
		
		 
		 if(lang.equals("German"))
		 {
			 m1.setText("Januar");
			 m1.setBackgroundResource(R.drawable.g1);
			 
			 m2.setText("Februar");
			 m2.setBackgroundResource(R.drawable.g2);
			 
			 m3.setText("März");
			 m3.setBackgroundResource(R.drawable.g3);
			 
			 m4.setText("April");
			 m4.setBackgroundResource(R.drawable.g4);
			 
			 m5.setText("Mai");
			 m5.setBackgroundResource(R.drawable.g5);
			 
			 m6.setText("Juni");
			 m6.setBackgroundResource(R.drawable.g6);
			 
			 m7.setText("Juli");
			 m7.setBackgroundResource(R.drawable.g7);
			 
			 m8.setText("August");
			 m8.setBackgroundResource(R.drawable.g8);
			 
			 m9.setText("September");
			 m9.setBackgroundResource(R.drawable.g9);
			 
			 m10.setText("Oktober");
			 m10.setBackgroundResource(R.drawable.g10);
			 
			 m11.setText("November");
			 m11.setBackgroundResource(R.drawable.g11);
			 
			 m12.setText("Dezember");
			 m12.setBackgroundResource(R.drawable.g12);
			  
		 }
		

		 if(lang.equals("Italian"))
		 {
			 m1.setText("gennaio");
			 m1.setBackgroundResource(R.drawable.ijan);
			 
			 m2.setText("febbraio");
			 m2.setBackgroundResource(R.drawable.ifeb);
			 
			 m3.setText("marzo");
			 m3.setBackgroundResource(R.drawable.imar);
			 
			 m4.setText("aprile");
			 m4.setBackgroundResource(R.drawable.iapril);
			 
			 m5.setText("maggio");
			 m5.setBackgroundResource(R.drawable.imay);
			 
			 m6.setText("giugno");
			 m6.setBackgroundResource(R.drawable.ijun);
			 
			 m7.setText("luglio");
			 m7.setBackgroundResource(R.drawable.ijul);
			 
			 m8.setText("agosto");
			 m8.setBackgroundResource(R.drawable.iaug);
			 
			 m9.setText("settembre");
			 m9.setBackgroundResource(R.drawable.isept);
			 
			 m10.setText("ottobre");
			 m10.setBackgroundResource(R.drawable.ioct);
			 
			 m11.setText("novembre");
			 m11.setBackgroundResource(R.drawable.inov);
			 
			 m12.setText("dicembre");
			 m12.setBackgroundResource(R.drawable.idec);
			  
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

