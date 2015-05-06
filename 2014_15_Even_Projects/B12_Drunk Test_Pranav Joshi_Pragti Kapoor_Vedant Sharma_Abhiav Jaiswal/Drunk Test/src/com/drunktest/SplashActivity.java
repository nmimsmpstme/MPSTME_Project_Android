package com.drunktest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;


public class SplashActivity extends ActionBarActivity {

	private final Handler handler = new Handler();
	private ImageView img;

	private final Runnable startActivityRunnable = new Runnable() {

	    @Override
	    public void run() {
	        Intent intent = new Intent();
	        intent.setClass(SplashActivity.this,Step_1_Activity.class);
	        startActivity(intent);
	        finish();
	    }
	}; 

	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.splash);
	    
	    img = (ImageView) findViewById (R.id.image);

	    //setContentView(img);
	}

	@Override
	protected void onResume() {
	    super.onResume();

	    Animation fadeIn = new AlphaAnimation(0, 1);
	    fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
	    fadeIn.setDuration(2000);

	    Animation fadeOut = new AlphaAnimation(1, 0);
	    fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
	    fadeOut.setStartOffset(2500);
	    fadeOut.setDuration(2000);

	    AnimationSet animation = new AnimationSet(false); //change to false
	    animation.addAnimation(fadeIn);
	    animation.addAnimation(fadeOut);
	    animation.setFillAfter(true);

	    img.startAnimation(animation);

	    handler.postDelayed(startActivityRunnable, 5000);
	}

	public void onPause()
	{
	    super.onPause();
	    handler.removeCallbacks(startActivityRunnable);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
	}
}
