package com.example.alarm;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Matheq extends Activity {
	
	Button b;
	TextView t;
	EditText e;
	
	int n1,n2,oper,ans;
	char op;
	Random rand= new Random();
	
	public void Submit(View v)
	{
		
		if(e.getText().length()==0)
		{
			Toast.makeText(this,"Enter valid number.",Toast.LENGTH_LONG).show();
		}
		int input = Integer.parseInt(e.getText().toString());
		if(input==ans)
		{
			
			Toast.makeText(this, "Answer is correct.", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this, Captcha.class);
			startActivity(intent);
			finish();
		}
		else
		{
			Toast.makeText(this, "Answer is incorrect. Please try again", Toast.LENGTH_LONG).show();
			function();
	
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_matheq);
		e=(EditText)findViewById(R.id.editText1);
		b=(Button)findViewById(R.id.button1);
		t=(TextView)findViewById(R.id.textView1);
		function();
		}

	private void function() {
		// TODO Auto-generated method stub
		n1=(int)(11*Math.random()+1);
		n2=(int)(11*Math.random()+1);
		
		oper=rand.nextInt(4)+1;
		
		switch(oper)
		{
			case 1:
				op='+';
				ans=n1+n2;
				t.setText("What is "+n1+" + "+n2+" ?");
				break;
			case 2:
				op='-';
				ans=n1-n2;
				t.setText("What is "+n1+" - "+n2+" ?");
				break;
			case 3:
				op='*';
				ans=n1*n2;
				t.setText("What is "+n1+" * "+n2+" ?");
				break;
			case 4:
				op='/';
				ans=n1/n2;
				t.setText("What is "+n1+" / "+n2+" ?");
				break;
	}
}
}
