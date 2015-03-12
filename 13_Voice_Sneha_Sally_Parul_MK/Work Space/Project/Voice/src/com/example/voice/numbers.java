package com.example.voice;

import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;
 
public class numbers extends Activity implements OnClickListener {
 
	/*Button button; */ 
	ViewFlipper flippy;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.numbers);
		flippy = (ViewFlipper)findViewById(R.id.viewFlipper1);
		flippy.setOnClickListener(this);
		
	}
	
 
public void onClick(View arg0)
{
	
/*Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();	 */
flippy.showNext();
}
}