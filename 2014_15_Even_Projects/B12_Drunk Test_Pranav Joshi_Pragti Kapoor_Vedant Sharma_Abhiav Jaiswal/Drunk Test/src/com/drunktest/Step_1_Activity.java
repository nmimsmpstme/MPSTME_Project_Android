package com.drunktest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Step_1_Activity extends Activity {
    /** Called when the activity is first created. */
	private RadioGroup rg1;
	private RadioButton rb1, rb2, rb3, rb4;
	private TextView txtQuestion;
	private int ansNo;
	private Button ok_button;
	private int [] rbIds = new int[]{R.id.radio0, R.id.radio1, R.id.radio2, R.id.radio3};
	private int [] images = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,
			R.drawable.img4, R.drawable.img5, R.drawable.img6};
	private ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_1);

        SharedPreferences	sharedPref = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		Bootstrap.queCount = sharedPref.getInt("count", 0);
		imageView = (ImageView) findViewById(R.id.image);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        txtQuestion = (TextView) findViewById(R.id.txt_question);
        rb1 = (RadioButton) findViewById(R.id.radio0);
        rb2 = (RadioButton) findViewById(R.id.radio1);
        rb3 = (RadioButton) findViewById(R.id.radio2);
        rb4 = (RadioButton) findViewById(R.id.radio3);
        ok_button = (Button) findViewById(R.id.ok_button);
        ok_button.setOnClickListener(onClickListener);
        ansNo = Bootstrap.answers[Bootstrap.queCount];
        ok_button.setTag(ansNo);
        
        txtQuestion.setText(Bootstrap.questionsArray[Bootstrap.queCount]);
        rb1.setText(Bootstrap.answerOptionsArray[Bootstrap.queCount][0]);
        rb2.setText(Bootstrap.answerOptionsArray[Bootstrap.queCount][1]);
        rb3.setText(Bootstrap.answerOptionsArray[Bootstrap.queCount][2]);
        rb4.setText(Bootstrap.answerOptionsArray[Bootstrap.queCount][3]);
        imageView.setImageResource(images[Bootstrap.queCount]);
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	if(Bootstrap.queCount>=5)
    	{
    		Bootstrap.queCount = 0;
    	}
    	else
    	{
    		Bootstrap.queCount++;
    	}
    	SharedPreferences	sharedPref = PreferenceManager
    				.getDefaultSharedPreferences(getApplicationContext());
    		Editor editor = sharedPref.edit();
    		//sharedPref.getString(key, defaultValue);
    		editor.putInt("count", Bootstrap.queCount);
    		editor.commit();
    }
    
    private OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(rg1.getCheckedRadioButtonId()!=-1){
				// Get Selected Radio Button and display output
		        if(rg1.getCheckedRadioButtonId()==rbIds[ansNo-1])
		        {
		        	
		        	//Toast.makeText(Step_2_Activity.this, "Passed Math's test \n Next, screen test \n Coming soon !", Toast.LENGTH_LONG).show();
		        	startActivity(new Intent(Step_1_Activity.this, HomeActivity.class));
		    		finish();
		        }
		        else
		        {
		        	startActivity(new Intent(Step_1_Activity.this, Drunk_Activity.class));
		        	finish();
		        }
		        
			}
			else
			{
				Toast.makeText(Step_1_Activity.this, "Answer the question above !", Toast.LENGTH_LONG).show();
			}
		}
	};

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}
}