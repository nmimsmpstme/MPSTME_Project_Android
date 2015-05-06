package com.drunktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Drunk_Activity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	//private static Fragment activeFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_drunk);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_DIAL);
		startActivity(intent);
		finish();
        System.exit(0);
	}
}