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
import android.widget.TextView;
import android.widget.Toast;

public class Numbers extends Activity implements OnClickListener, OnInitListener {
	
	Button m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20;
	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
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
		setContentView(R.layout.numbers);
		Toast.makeText(this,"Click The Numbers To \n Hear Their Pronounciations", Toast.LENGTH_LONG).show();
		
		m1=(Button)findViewById(R.id.num_button1);
		m2=(Button)findViewById(R.id.num_button2);
		m3=(Button)findViewById(R.id.num_button3);
		m4=(Button)findViewById(R.id.num_button4);
		m5=(Button)findViewById(R.id.num_button5);
		m6=(Button)findViewById(R.id.num_button6);
		m7=(Button)findViewById(R.id.num_button7);
		m8=(Button)findViewById(R.id.num_button8);
		m9=(Button)findViewById(R.id.num_button9);
		m10=(Button)findViewById(R.id.num_button10);
		
		m11=(Button)findViewById(R.id.num_button11);
		m12=(Button)findViewById(R.id.num_button12);
		m13=(Button)findViewById(R.id.num_button13);
		m14=(Button)findViewById(R.id.num_button14);
		m15=(Button)findViewById(R.id.num_button15);
		m16=(Button)findViewById(R.id.num_button16);
		m17=(Button)findViewById(R.id.num_button17);
		m18=(Button)findViewById(R.id.num_button18);
		m19=(Button)findViewById(R.id.num_button19);
		m20=(Button)findViewById(R.id.num_button20);
		
		
		t1=(TextView)findViewById(R.id.num_tbutton1);
		t2=(TextView)findViewById(R.id.num_tbutton2);
		t3=(TextView)findViewById(R.id.num_tbutton3);
		t4=(TextView)findViewById(R.id.num_tbutton4);
		t5=(TextView)findViewById(R.id.num_tbutton5);
		t6=(TextView)findViewById(R.id.num_tbutton6);
		t7=(TextView)findViewById(R.id.num_tbutton7);
		t8=(TextView)findViewById(R.id.num_tbutton8);
		t9=(TextView)findViewById(R.id.num_tbutton9);
		t10=(TextView)findViewById(R.id.num_tbutton10);
		
		t11=(TextView)findViewById(R.id.num_tbutton11);
		t12=(TextView)findViewById(R.id.num_tbutton12);
		t13=(TextView)findViewById(R.id.num_tbutton13);
		t14=(TextView)findViewById(R.id.num_tbutton14);
		t15=(TextView)findViewById(R.id.num_tbutton15);
		t16=(TextView)findViewById(R.id.num_tbutton16);
		t17=(TextView)findViewById(R.id.num_tbutton17);
		t18=(TextView)findViewById(R.id.num_tbutton18);
		t19=(TextView)findViewById(R.id.num_tbutton19);
		t20=(TextView)findViewById(R.id.num_tbutton20);
		
		
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
		m13.setOnClickListener(this);
		m14.setOnClickListener(this);
		m15.setOnClickListener(this);
		m16.setOnClickListener(this);
		m17.setOnClickListener(this);
		m18.setOnClickListener(this);
		m19.setOnClickListener(this);
		m20.setOnClickListener(this);
		
		
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");
		 
		 m1.setBackgroundResource(R.drawable.n1);
		 m2.setBackgroundResource(R.drawable.n2);
		 m3.setBackgroundResource(R.drawable.n3);
		 m4.setBackgroundResource(R.drawable.n4);
		 m5.setBackgroundResource(R.drawable.n5);
		 m6.setBackgroundResource(R.drawable.n6);
		 m7.setBackgroundResource(R.drawable.n7);
		 m8.setBackgroundResource(R.drawable.n8);
		 m9.setBackgroundResource(R.drawable.n9);
		 m10.setBackgroundResource(R.drawable.n10);
		 
		 m11.setBackgroundResource(R.drawable.n11);
		 m12.setBackgroundResource(R.drawable.n12);
		 m13.setBackgroundResource(R.drawable.n13);
		 m14.setBackgroundResource(R.drawable.n14);
		 m15.setBackgroundResource(R.drawable.n15);
		 m16.setBackgroundResource(R.drawable.n16);
		 m17.setBackgroundResource(R.drawable.n17);
		 m18.setBackgroundResource(R.drawable.n18);
		 m19.setBackgroundResource(R.drawable.n19);
		 m20.setBackgroundResource(R.drawable.n20);
		 
		 if(lang.equals("French"))
		 {

			 m1.setText("un");
			 m2.setText("deux");
			 m3.setText("trois");
			 m4.setText("quatre");
			 m5.setText("cinq");
			 m6.setText("six");
			 m7.setText("sept");
			 m8.setText("huit");
			 m9.setText("neuf");
			 m10.setText("dix");
			 
			 m11.setText("onze");
			 m12.setText("douze");
			 m13.setText("treize");
			 m14.setText("quatorze");
			 m15.setText("quinze");
			 m16.setText("seize");
			 m17.setText("dix sept");
			 m18.setText("dix huit");
			 m19.setText("dix neuf");
			 m20.setText("vingt");
			 
			 t1.setText("un");
			 t2.setText("deux");
			 t3.setText("trois");
			 t4.setText("quatre");
			 t5.setText("cinq");
			 t6.setText("six");
			 t7.setText("sept");
			 t8.setText("huit");
			 t9.setText("neuf");
			 t10.setText("dix");
			 
			 t11.setText("onze");
			 t12.setText("douze");
			 t13.setText("treize");
			 t14.setText("quatorze");
			 t15.setText("quinze");
			 t16.setText("seize");
			 t17.setText("dix sept");
			 t18.setText("dix huit");
			 t19.setText("dix neuf");
			 t20.setText("vingt");
			 
			 
		 }
		
		 if(lang.equals("German"))
		 {

			 m1.setText("eins");
			 m2.setText("zwei");
			 m3.setText("drei");
			 m4.setText("vier");
			 m5.setText("fünf");
			 m6.setText("sechs");
			 m7.setText("sieben");
			 m8.setText("acht");
			 m9.setText("neun");
			 m10.setText("zehn");
			 
			 m11.setText("elf");
			 m12.setText("zwölf");
			 m13.setText("dreizehn");
			 m14.setText("vierzehn");
			 m15.setText("fünfzehn");
			 m16.setText("sechszehn");
			 m17.setText("siebzehn");
			 m18.setText("achtzehn");
			 m19.setText("neunzehn");
			 m20.setText("zwanzig");
			
			 
			 t1.setText("eins");
			 t2.setText("zwei");
			 t3.setText("drei");
			 t4.setText("vier");
			 t5.setText("fünf");
			 t6.setText("sechs");
			 t7.setText("sieben");
			 t8.setText("acht");
			 t9.setText("neun");
			 t10.setText("zehn");
			 
			 t11.setText("elf");
			 t12.setText("zwölf");
			 t13.setText("dreizehn");
			 t14.setText("vierzehn");
			 t15.setText("fünfzehn");
			 t16.setText("sechszehn");
			 t17.setText("siebzehn");
			 t18.setText("achtzehn");
			 t19.setText("neunzehn");
			 t20.setText("zwanzig");
			
		 }
		 
		 if(lang.equals("Italian"))
		 {
			 m1.setText("uno");
			 m2.setText("due");
			 m3.setText("tre");
			 m4.setText("quattro");
			 m5.setText("cinque");
			 m6.setText("sei");
			 m7.setText("sette");
			 m8.setText("otto");
			 m9.setText("nove");
			 m10.setText("dieci");
			 
			 m11.setText("undici");
			 m12.setText("dodici");
			 m13.setText("tredici");
			 m14.setText("quattordici");
			 m15.setText("quindici");
			 m16.setText("sedici");
			 m17.setText("diciassette");
			 m18.setText("diciotto");
			 m19.setText("diciannove");
			 m20.setText("venti");
			 	 
			 
			 t1.setText("uno");
			 t2.setText("due");
			 t3.setText("tre");
			 t4.setText("quattro");
			 t5.setText("cinque");
			 t6.setText("sei");
			 t7.setText("sette");
			 t8.setText("otto");
			 t9.setText("nove");
			 t10.setText("dieci");
			 
			 t11.setText("undici");
			 t12.setText("dodici");
			 t13.setText("tredici");
			 t14.setText("quattordici");
			 t15.setText("quindici");
			 t16.setText("sedici");
			 t17.setText("diciassette");
			 t18.setText("diciotto");
			 t19.setText("diciannove");
			 t20.setText("venti");
			 
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

