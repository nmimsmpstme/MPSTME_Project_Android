package com.drunktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Step_5_Activity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	private RadioGroup rg1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.step_5);
		rg1 = (RadioGroup) findViewById(R.id.rGroup);
	}

	@Override
	public void onClick(View v) {

		if (rg1.getCheckedRadioButtonId() == -1) 
		{
			Toast.makeText(Step_5_Activity.this, "Please answer the question !", Toast.LENGTH_LONG).show();
		} 
		else 
		{
			if(rg1.getCheckedRadioButtonId() == R.id.opt2)
			{
				startActivity(new Intent(Step_5_Activity.this, Not_Drunk_Activity.class));
	        	finish();
			}
			else
			{
				startActivity(new Intent(Step_5_Activity.this, Drunk_Activity.class));
	        	finish();
			}
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}
}