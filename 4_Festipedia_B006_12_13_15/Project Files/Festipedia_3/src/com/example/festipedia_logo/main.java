package com.example.festipedia_logo;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;


//import android.support.v7.view.*;
import android.support.v4.*;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class main extends Activity {
Button button1;
	Drawable back;
	//NetworkInfo activeNetwork;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*ConnectivityManager cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
		 activeNetwork=cm.getActiveNetworkInfo();
		if((activeNetwork==null && activeNetwork.isConnectedOrConnecting())==false){
			Toast nonetwork = Toast.makeText(this, "No network", Toast.LENGTH_SHORT);
			nonetwork.show();
		}	
		else{*/
		
		getActionBar().hide();
		
		 int num=(int)Math.ceil(Math.random() * 6);
		 switch(num)
		 {
		 case 1: back=getResources().getDrawable(R.drawable.f1);
		 break;
		 case 2: back=getResources().getDrawable(R.drawable.f2);
		 break;
		 case 3: back=getResources().getDrawable(R.drawable.f3);
		 break;
		 case 4: back=getResources().getDrawable(R.drawable.f4);
		 break;
		 case 5: back=getResources().getDrawable(R.drawable.f5);
		 break;
		 case 6: back=getResources().getDrawable(R.drawable.f6);
		 break;
		 default:back=getResources().getDrawable(R.drawable.f5);
		 break;
		 }
		 setContentView(R.layout.splash_page);
		RelativeLayout r1=(RelativeLayout)findViewById(R.id.relative_layout);
		 r1.setBackground(back);
		 /*

			button1 = (Button) findViewById(R.id.button1);
			
			button1.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View view) {
							// Launching All products Activity
							
							Intent i = new Intent(getApplicationContext(), mainpageact.class);
							i.putExtra("loc", loc);
							startActivity(i);
							finish();
						}
					});

			spinner.setOnItemSelectedListener(new YourItemSelectedListener());
	
*/
			    
			Thread timer=new Thread()
			{
				public void run(){
					try{
						sleep(4000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					finally{
						Intent i = new Intent(main.this, mainpage.class);
						//i.putExtra("loc", loc);
						finish();
						startActivity(i);
					}
				}
			};
			timer.start();





	}
	//}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/*public class YourItemSelectedListener implements OnItemSelectedListener {

	    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
	         loc = parent.getItemAtPosition(pos).toString();
	    }

	    public void onNothingSelected(AdapterView parent) {
	        // Do nothing.
	    }
	}*/
}

