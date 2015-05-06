package com.drunktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

public class Step_4_Activity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	Handler handler = new Handler();
	private static int count=0;
	final Runnable r = new Runnable() {
	    public void run() {
	    	if(count==5)
	    	{
	    		startActivity(new Intent(Step_4_Activity.this, Step_5_Activity.class));
	        	finish();
	    	}
	    	else
	    	{
	    		startActivity(new Intent(Step_4_Activity.this, Drunk_Activity.class));
	        	finish();
	    	}
	    }
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.step_4);
	}

	@Override
	public void onClick(View v) {
		
			if(v.getId()==R.id.start_button)
			{
				v.setVisibility(View.INVISIBLE);
				findViewById(R.id.mainBubbleLayout).setVisibility(View.VISIBLE);
				handler.postDelayed(r, 5000);
			}
			else
			{
				count++;
				v.setVisibility(View.INVISIBLE);
			}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}