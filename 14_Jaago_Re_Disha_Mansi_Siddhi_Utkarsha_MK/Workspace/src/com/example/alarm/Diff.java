package com.example.alarm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Diff extends Activity{
	
		Button b1;
		int result_code=0;
		EditText text;
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.diff);
				b1=(Button)findViewById(R.id.button1);
				text=(EditText)findViewById(R.id.editText1);
		}
		
		
		
		public void Submit(View v)
		{
				
					if(text.getText().length()==0)
					{
							Toast.makeText(this,"Please enter a valid number.",Toast.LENGTH_LONG).show();
							return;
					}
					
					int inputValue=Integer.parseInt(text.getText().toString());
					
					if(inputValue==10)
					{
							Toast.makeText(this,"Correct Answer!", Toast.LENGTH_LONG).show();
							Intent i=new Intent(this, Captcha.class);
							startActivity(i);
							finish();
							
						
					}
					
					else
					{
							Toast.makeText(this,"Wrong Answer.Please enter again!",Toast.LENGTH_LONG).show();
							return;
					}
				
				
				
		}
}
