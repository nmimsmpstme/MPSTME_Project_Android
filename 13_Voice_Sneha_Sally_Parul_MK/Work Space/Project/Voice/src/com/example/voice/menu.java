package com.example.voice;



import android.app.Activity;
import android.view.View.OnClickListener;
//import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class menu extends Activity{
 
	Button button, Numbers, Letters, Colours;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		Numbers=(Button)findViewById(R.id.Numbers);
		Letters=(Button)findViewById(R.id.Letters);
		Colours=(Button)findViewById(R.id.Colours);
		
		/*lessons.setOnClickListener(this);
		games.setOnClickListener(this);
		quiz.setOnClickListener(this);*/
	}
	public void swapto4(View v)
	{
		startActivity(new Intent(menu.this,numbers.class));
	}
	public void swapto5(View v)
	{
		startActivity(new Intent(menu.this,letteractivity.class));
	}
	public void swapto6(View v)
	{
		startActivity(new Intent(menu.this,ColorActivity.class));
	} 
/*public void onClick(View v)
{
int iidd=v.getId();
Button gghh=(Button)findViewById(iidd);
String bstring=gghh.getText().toString();


if(bstring.equals("Lessons"))//Over here write the text on your button
{
	Intent play=new Intent(this,numbers.class);
	startActivity(play);
}

if(bstring.equals("games"))
{
	Intent play=new Intent(this,App2Activity.class);
	startActivity(play);	}

if(bstring.equals("quiz"))
{
	Intent play=new Intent(this,App2Activity.class);
	startActivity(play);
}
}*/

}

 

	