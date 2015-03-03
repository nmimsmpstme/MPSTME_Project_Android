package com.example.recurso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Translate extends Activity implements OnClickListener{

	Button words,sentence;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.translate);
		
		words=(Button)findViewById(R.id.tra_button1);
		sentence=(Button)findViewById(R.id.tra_button2);
		
		words.setOnClickListener(this);
		sentence.setOnClickListener(this);
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
		
		if(bstring.equals("Words"))
		{
			Intent play=new Intent(this,Words.class);
			
			startActivity(play);
		}
		if(bstring.equals("Sentence"))
		{
			Intent play=new Intent(this,Sentence.class);
			
			startActivity(play);
		}
		overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
	}
}
