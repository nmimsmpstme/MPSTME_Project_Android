package com.drunktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Step_2_Activity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	private RadioGroup rg1, rg2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.step_2);
     // Init Widget GUI
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(rg1.getCheckedRadioButtonId()!=-1 && rg2.getCheckedRadioButtonId()!=-1){
			// Get Selected Radio Button and display output
	        if(rg1.getCheckedRadioButtonId()==R.id.radio1 && rg2.getCheckedRadioButtonId()==R.id.radio12)
	        {
	        	//Toast.makeText(Step_2_Activity.this, "Passed Math's test \n Next, screen test \n Coming soon !", Toast.LENGTH_LONG).show();
	        	startActivity(new Intent(Step_2_Activity.this, Step_3_Activity.class));
	    		finish();
	        }
	        else
	        {
	        	startActivity(new Intent(Step_2_Activity.this, Drunk_Activity.class));
	        	finish();
	        }
	        
		}
		else
		{
			Toast.makeText(Step_2_Activity.this, "Answer both questions above !", Toast.LENGTH_LONG).show();
		}
		
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}
}