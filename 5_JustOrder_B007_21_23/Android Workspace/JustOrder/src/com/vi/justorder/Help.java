package com.vi.justorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Help extends Activity {

	Button about;
	Intent homeit;
	TextView text;
	Bundle g;
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	     
	        setContentView(R.layout.help);
	        text=(TextView)findViewById(R.id.texth);
	        g = getIntent().getExtras();
	        homeit = new Intent(getBaseContext(), JustOrderMain.class);
	        about = (Button)findViewById(R.id.demo);
            about.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					Intent i=new Intent(Help.this,Info.class);
					i.putExtras(g);
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