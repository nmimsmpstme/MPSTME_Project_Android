package com.ara.aroundme;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Toast;

public class Emergency extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        
        View callP = findViewById(R.id.imageButton1);
        callP.setOnClickListener(this);
        View callA = findViewById(R.id.imageButton2);
        callA.setOnClickListener(this);
    }
    
    public void pol(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(this, MainActivity.class);
		startActivity(i);
		Toast.makeText(this,"Calling emergency police",Toast.LENGTH_SHORT).show();
 
	}
    
    private void callPolice()
    {
     String phoneCallUri = "tel:100";
     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
     phoneCallIntent.setData(Uri.parse(phoneCallUri));
     startActivity(phoneCallIntent);
    }
    private void callAmbulance()
    {
     String phoneCallUri = "tel:+919820454346";
     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
     phoneCallIntent.setData(Uri.parse(phoneCallUri));
     startActivity(phoneCallIntent);
    }

 @Override
 public void onClick(View v) {
  // TODO Auto-generated method stub
  switch(v.getId())
  {
   case R.id.imageButton1:
    callPolice();
    break;
   case R.id.imageButton2:
	    callAmbulance();
	    break;
   default:
    break;
  }
 }
}