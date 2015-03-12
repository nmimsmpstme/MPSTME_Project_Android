package com.example.voice;

import android.app.Activity;
//import android.view.Menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
 
public class MainnewActivity extends Activity {
 
	Button button;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainnew);
		//addListenerOnButton();
	}
	
	public void swapto2(View v)
	{
		startActivity(new Intent(MainnewActivity.this,App2Activity.class));
	}
	
	/*public void addListenerOnButton() {
 
		final Context context = this;
 
		button = (Button)findViewById(R.id.ls);
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context,App2Activity.class);
                            startActivity(intent);   
                            
 
			}
 
		});
 
	}*/
 
}