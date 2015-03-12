package com.example.voice;



import com.example.voice.QuizActivity;

import android.app.Activity;
import android.view.View.OnClickListener;
//import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class App2Activity extends Activity{
 
	Button lessons,games,dictionary,quiz;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		
		lessons=(Button)findViewById(R.id.lessons);
		dictionary=(Button)findViewById(R.id.dictionary);
		games=(Button)findViewById(R.id.games);
		quiz=(Button)findViewById(R.id.quiz);
		
		/*lessons.setOnClickListener(this);
		games.setOnClickListener(this);
		quiz.setOnClickListener(this);*/
	}
	public void swapto3(View v)
	{
		//lessons
		startActivity(new Intent(App2Activity.this,menu.class));
	}
	public void swapto7(View v)
	{
		//games
		startActivity(new Intent(App2Activity.this,games.class));
	}
	public void swapto8(View v)
	{
		//quiz
		startActivity(new Intent(App2Activity.this,QuizActivity.class));
	}
	public void swapto9(View v)
			{
		//dictionary
		startActivity(new Intent(App2Activity.this,dictmenu.class));
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

 

	