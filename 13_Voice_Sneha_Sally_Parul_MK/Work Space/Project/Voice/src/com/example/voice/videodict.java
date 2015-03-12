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

public class videodict extends Activity{
 
	Button vidone,vidtwo,vidthree;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.videodict);
		
		vidone=(Button)findViewById(R.id.vidone);
		vidtwo=(Button)findViewById(R.id.vidtwo);
		vidthree=(Button)findViewById(R.id.vidthree);
		
		
		/*lessons.setOnClickListener(this);
		games.setOnClickListener(this);
		quiz.setOnClickListener(this);*/
	}
	public void swapto14(View v)
	{
		//lessons
		startActivity(new Intent(videodict.this,videoone.class));
	}
	public void swapto15(View v)
	{
		//games
		startActivity(new Intent(videodict.this,videotwo.class));
	}
	public void swapto16(View v)
	{
		//games
		startActivity(new Intent(videodict.this,videothree.class));
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

 

	