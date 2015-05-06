package com.drunktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Step_3_Activity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	private Button okBtn;
	Handler handler = new Handler();
	private static int count=0;
	final Runnable r = new Runnable() {
	    public void run() {
	    	switch (count) {
			case 0:
				okBtn.setBackgroundColor(getResources().getColor(R.color.red));
				okBtn.setTag(0);
				break;
			case 1:
				okBtn.setBackgroundColor(getResources().getColor(R.color.blue));
				okBtn.setTag(1);
				break;
			case 2:
				okBtn.setBackgroundColor(getResources().getColor(R.color.green));
				okBtn.setTag(2);
				break;
			case 3:
				okBtn.setBackgroundColor(getResources().getColor(R.color.white));
				okBtn.setTag(3);
				break;

			default:
				okBtn.setBackgroundColor(getResources().getColor(R.color.white));
				okBtn.setTag(0);
				break;
			}
	    	count++;
	    	if(count!=5){
	    		handler.postDelayed(this, 1000);
	    	}
	    	else{
	    		startActivity(new Intent(Step_3_Activity.this, Drunk_Activity.class));
	    		finish();
	    	}
	    }
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.step_3);
		okBtn = (Button) findViewById(R.id.ok_button);
		handler.postDelayed(r, 1000);
	}

	@Override
	public void onClick(View v) {
		if(((Integer)v.getTag())==3)
		{
			//Toast.makeText(Step_3_Activity.this, "Passed Screen test \n Next, MCQ test \n Coming soon !", Toast.LENGTH_LONG).show();
			handler.removeCallbacks(r);
			startActivity(new Intent(Step_3_Activity.this, Step_4_Activity.class));
    		finish();
		}
		else
		{
			startActivity(new Intent(Step_3_Activity.this, Drunk_Activity.class));
        	finish();
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}
	
	

	
}