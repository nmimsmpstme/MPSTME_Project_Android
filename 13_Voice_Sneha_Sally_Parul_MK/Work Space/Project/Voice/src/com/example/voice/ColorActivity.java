package com.example.voice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ColorActivity extends Activity implements OnClickListener {
	
	Button A,B,C,D,E,F,G,H,I,J,K,L;
	Intent play1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_color);
		A=(Button) findViewById(R.id.black);
		B=(Button) findViewById(R.id.blue);
		C=(Button) findViewById(R.id.brown);
		D=(Button) findViewById(R.id.gold);
		E=(Button) findViewById(R.id.green);
		F=(Button) findViewById(R.id.orange);
		G=(Button) findViewById(R.id.pink);
		H=(Button) findViewById(R.id.purple);
		I=(Button) findViewById(R.id.red);
		J=(Button) findViewById(R.id.silver);
		K=(Button) findViewById(R.id.white);
		L=(Button) findViewById(R.id.yellow);
		
		
		A.setOnClickListener(this);
		B.setOnClickListener(this);
		C.setOnClickListener(this);
		D.setOnClickListener(this);
		E.setOnClickListener(this);
		F.setOnClickListener(this);
		G.setOnClickListener(this);
		H.setOnClickListener(this);
		I.setOnClickListener(this);
		J.setOnClickListener(this);
		K.setOnClickListener(this);
		L.setOnClickListener(this);
		
			
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
switch (v.getId()){
		
		case R.id.black:
				play1=new Intent(this,colours.class);
				play1.putExtra("word", "black");
			startActivity(play1);
			
			break;
			
		case R.id.blue:
			 play1=new Intent(this,colours.class);
			play1.putExtra("word", "blue");
						startActivity(play1);
						break;
						
		case R.id.brown:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "brown");			
						startActivity(play1);
						break;
		case R.id.gold:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "gold");			
			startActivity(play1);
						break;
		case R.id.green:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "green");	
						startActivity(play1);
						break;
		case R.id.orange:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "orange");	
						startActivity(play1);
						break;
		case R.id.pink:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "pink");	
						startActivity(play1);
						break;
		case R.id.purple:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "purple");	
						startActivity(play1);
						break;
		case R.id.red:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "red");	
						startActivity(play1);
						break;
		case R.id.silver:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "silver");	
						startActivity(play1);
						break;
		case R.id.white:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "white");	
						startActivity(play1);
						break;
		case R.id.yellow:
			play1=new Intent(this,colours.class);
			play1.putExtra("word", "yellow");	
						startActivity(play1);
						break;
		
			}

}
}