package com.example.recurso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class level extends Activity implements OnClickListener {
	
	Button basic,inter,advanced,test;
	String bstring;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level);
	
		basic=(Button)findViewById(R.id.btnlevel1);
		inter=(Button)findViewById(R.id.btnlevel2);
		advanced=(Button)findViewById(R.id.btnlevel3);
		test=(Button)findViewById(R.id.btnlevel4);
		
		basic.setOnClickListener(this);
		inter.setOnClickListener(this);
		advanced.setOnClickListener(this);
		test.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
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
		if(bstring.equals("Basics"))
		{
			Intent play=new Intent(this,tabbed_pane.class);
			play.putExtra("lang", lang);
			play.putExtra("level", "0");
			startActivity(play);
		}
		
		if(bstring.equals("Intermediate"))
		{
			Intent play=new Intent(this,tabbed_pane.class);
			play.putExtra("lang", lang);
			play.putExtra("level", "1");
			startActivity(play);
	
		}
		
		if(bstring.equals("Advanced"))
		{
			Intent play=new Intent(this,tabbed_pane.class);
			play.putExtra("lang", lang);
			play.putExtra("level", "2");
			startActivity(play);
		}
		
		if(bstring.equals("Quiz"))
		{
			
			Intent play=new Intent(this,Test.class);
			play.putExtra("lang", lang);
			startActivity(play);
			
		}
		overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
	}
}
