package com.vi.justorder;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Info extends Activity {

	Button gallery;
	Intent homeit;
	TextView text;
	Bundle g;
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	     
	        setContentView(R.layout.about);
	        g = getIntent().getExtras();
	        homeit = new Intent(getBaseContext(), JustOrderMain.class);
	        gallery=(Button)findViewById(R.id.gallery);
	        gallery.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					Intent i=new Intent(Info.this,Gallery.class);
					startActivity(i);
					
				}
			});

}
	@Override
	public void onBackPressed() {
		homeit.putExtras(g);
		startActivity(homeit);
	   return;
	}
}