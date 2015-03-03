package com.example.recurso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Basics extends Activity {
	
	
	String bstring;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic);
		
	}

	public void jump (View v) {
		// TODO Auto-generated method stub
		
		int iidd=v.getId();
		final Button gghh=(Button)findViewById(iidd);
		bstring=gghh.getText().toString();
		
		gghh.setAlpha((float) 0.5);
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		  @Override
		  public void run() {
		    gghh.setAlpha(1);
		  }
		}, 100);	

		Intent in=getIntent();
		 String lang=in.getStringExtra("lang");
		if(bstring.equals("Alphabets"))
		{
			Intent play=new Intent(this,Alphabets.class);
			play.putExtra("lang", lang);
			play.putExtra("level", "basics");
			play.putExtra("number", "1");
			startActivity(play);
		}

		
		else if(bstring.equals("Months"))
		{
			Intent play=new Intent(this,months.class);
			play.putExtra("lang", lang);
			play.putExtra("level", "basics");
			play.putExtra("number", "1");
			startActivity(play);
		}
		else if(bstring.equals("Days"))
		{
			Intent play=new Intent(this,Days.class);
			play.putExtra("lang", lang);
			play.putExtra("level", "basics");
			play.putExtra("number", "1");
			startActivity(play);
		}
		
		else if(bstring.equals("Numbers"))
		{
			Intent play=new Intent(this,Numbers.class);
			play.putExtra("lang", lang);
			play.putExtra("level", "basics");
			play.putExtra("number", "1");
			startActivity(play);
		}
		overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		
	}
}
