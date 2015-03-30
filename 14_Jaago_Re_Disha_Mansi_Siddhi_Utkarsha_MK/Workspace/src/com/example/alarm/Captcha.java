package com.example.alarm;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Captcha extends Activity {
	
	Button b;
	EditText e;
	TextView t; 
	
	String word;
	char []arr=new char[5];
	int i,small,cap;
	Random rand=new Random();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.captcha);
		b=(Button)findViewById(R.id.button1);
		e=(EditText)findViewById(R.id.editText1);
		t=(TextView)findViewById(R.id.textView1);
		logic();
	}

	public void logic() {
		// TODO Auto-generated method stub
		int j;
		for(j=0;j<5;j++)
		{
			i=rand.nextInt(2)+1;
			small=rand.nextInt(29)+97;
			cap=rand.nextInt(29)+65;
			switch(i)
			{
			case 1:
				arr[j]=(char) small;
				break;
			case 2:
				arr[j]=(char) cap;
				break;
			}
		}
		word= new String(arr);
		t.setText(""+word);
	}
	
	public void Submit(View v)
	{
		int x;
		String s=new String();
		s=e.getText().toString();
		if(e.getText().length()==0)
		{
			Toast.makeText(this,"Enter a valid input.",Toast.LENGTH_LONG).show();
			return;
		}
		x=s.compareTo(word);
		if(x==0)
		{
			Toast.makeText(this,"Good Morning!Have a nice day!",Toast.LENGTH_LONG).show();
			Intent i=new Intent(this,Activity_Buzzer.class);
			startActivity(i);
			finish();
		}
		else
		{
			Toast.makeText(this,"Answer is incorrect.",Toast.LENGTH_LONG).show();
			e.setText("");
			logic();
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.captcha_main, menu);
		return true;
	}

}
