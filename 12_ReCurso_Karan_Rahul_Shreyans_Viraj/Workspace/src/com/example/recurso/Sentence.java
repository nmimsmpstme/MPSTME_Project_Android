package com.example.recurso;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;



public class Sentence  extends Activity implements OnClickListener, OnItemSelectedListener{

	Button translate;
	Spinner w_lang;
	String language;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trans_sentence);
		
		translate=(Button)findViewById(R.id.trsen_button1);
		w_lang=(Spinner)findViewById(R.id.trsen_spinner1);
		
		translate.setOnClickListener(this);
		String[] items = new String[]{"German","French","Italian"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
		w_lang.setAdapter(adapter);
		w_lang.setOnItemSelectedListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if(language.equals("German"))
		{
			Intent viewIntent =
		          new Intent("android.intent.action.VIEW",
		            Uri.parse("http://translation.babylon.com/english/to-german/"));
		          startActivity(viewIntent);
		}
		if(language.equals("French"))
		{
			Intent viewIntent =
		          new Intent("android.intent.action.VIEW",
		            Uri.parse("http://translation.babylon.com/english/to-french/"));
		          startActivity(viewIntent);
		}
		if(language.equals("Italian"))
		{
			Intent viewIntent =
		          new Intent("android.intent.action.VIEW",
		            Uri.parse("http://translation.babylon.com/english/to-italian/"));
		          startActivity(viewIntent);
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		language=w_lang.getSelectedItem().toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}



		 
