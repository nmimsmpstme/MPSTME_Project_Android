package com.example.recurso;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Alphabets extends Activity implements OnInitListener{
	
	private TextToSpeech myTTS;
	
private int MY_DATA_CHECK_CODE = 0;
String lang;

@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
}



	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.letters);
		
		 Toast.makeText(this,"Click The Letters To \n Hear Their Pronounciations", Toast.LENGTH_LONG).show();
		 Intent in=getIntent();
		 lang=in.getStringExtra("lang");
	
	    Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
        
	}
	
	public void alphabets(View v)
		{
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

