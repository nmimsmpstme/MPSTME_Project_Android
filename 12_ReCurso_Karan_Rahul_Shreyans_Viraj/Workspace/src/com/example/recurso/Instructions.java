package com.example.recurso;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Instructions extends Activity implements OnClickListener{

	Button img,pre,next;
	int temph = 221;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instructions);
		
		img=(Button)findViewById(R.id.instr_image);
		pre=(Button)findViewById(R.id.instr_pre);
		next=(Button)findViewById(R.id.instr_next);
		
		pre.setOnClickListener(this);
		next.setOnClickListener(this);
		
		int resID = getResources().getIdentifier("h"+temph, "drawable", getPackageName());
		img.setBackgroundResource(resID );
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
			switch (v.getId())
			{
			
			case R.id.instr_pre:
				
				if(temph >= 222)
				{
					temph = temph-1;
					int resID = getResources().getIdentifier("h"+temph, "drawable", getPackageName());
					img.setBackgroundResource(resID );
					
				}
			break;
			
			case R.id.instr_next:
				if(temph<227)
				{
					temph=temph+1;
					int resID = getResources().getIdentifier("h"+temph, "drawable", getPackageName());
					img.setBackgroundResource(resID );
				}
				else if(temph==227)
				{
					finish();
				}
				break;	
				
			}
			
	}
}