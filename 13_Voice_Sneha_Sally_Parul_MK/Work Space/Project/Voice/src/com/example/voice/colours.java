package com.example.voice;

import com.example.voice.R.drawable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class colours extends Activity  {
	
	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
setContentView(R.layout.colours);
iv=(ImageView)findViewById(R.id.imageView1);
Intent in=getIntent();
String word=in.getStringExtra("word");

if(word.equals("black"))
{
	iv.setBackgroundResource(R.drawable.black);
}
if(word.equals("blue"))
{
	iv.setBackgroundResource(R.drawable.blue);
}
if(word.equals("brown"))
{
	iv.setBackgroundResource(R.drawable.brown);
}
if(word.equals("gold"))
{
	iv.setBackgroundResource(drawable.gold);
}
if(word.equals("green"))
{
	iv.setBackgroundResource(drawable.green);
}
if(word.equals("orange"))
{
	iv.setBackgroundResource(drawable.orange);
}
if(word.equals("pink"))
{
	iv.setBackgroundResource(drawable.pink);
}
if(word.equals("purple"))
{
	iv.setBackgroundResource(drawable.purple);
}
if(word.equals("red"))
{
	iv.setBackgroundResource(drawable.red);
}
if(word.equals("silver"))
{
	iv.setBackgroundResource(drawable.silver);
}
if(word.equals("white"))
{
	iv.setBackgroundResource(drawable.white);
}
if(word.equals("yellow"))
{
	iv.setBackgroundResource(drawable.yellow);
}
		
	} 
	

}



/* package com.example.voice;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;
 
public class colours extends Activity implements OnClickListener {
 

	ViewFlipper flippy;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colours);
		flippy = (ViewFlipper)findViewById(R.id.viewFlipper1);
		flippy.setOnClickListener(this);
		
	}
	
 
public void onClick(View arg0)
{
	
flippy.showNext();
}
} */
