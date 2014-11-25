package com.example.myfilofax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle splashActivity) {
		// TODO Auto-generated method stub
		super.onCreate(splashActivity);
		setContentView(R.layout.activity_splash);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(3000);
				}
				catch(InterruptedException e){
					e.printStackTrace(); 
				}
				finally{
 					Intent openMainActivity = new Intent("com.example.myfilofax.MainActivity");
					startActivity(openMainActivity);
				}
			}
		}; 
		timer. start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}

