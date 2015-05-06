package com.drunktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class HomeActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	//private static Fragment activeFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_home);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(HomeActivity.this, Step_2_Activity.class));
		finish();
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}
}