package com.example.voice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.voice.App2Activity;
import com.example.voice.QuizActivity;
import com.example.voice.R;
import com.example.voice.dict;
import com.example.voice.games;
import com.example.voice.menu;

public class dictmenu extends Activity{
 
	Button picturedict,videodict;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dictmenu);
		
		picturedict=(Button)findViewById(R.id.picturedict);
		videodict=(Button)findViewById(R.id.videodict);
		
		
		/*lessons.setOnClickListener(this);
		games.setOnClickListener(this);
		quiz.setOnClickListener(this);*/
	}
	public void swapto12(View v)
	{
		//lessons
		startActivity(new Intent(dictmenu.this,dict.class));
	}
	public void swapto13(View v)
	{
		//games
		startActivity(new Intent(dictmenu.this,videodict.class));
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

 

	