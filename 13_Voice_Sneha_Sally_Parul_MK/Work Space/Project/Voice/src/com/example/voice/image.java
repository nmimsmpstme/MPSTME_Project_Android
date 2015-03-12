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

public class image extends Activity  {
	
	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
setContentView(R.layout.image_main);
iv=(ImageView)findViewById(R.id.imageView1);
Intent in=getIntent();
String word=in.getStringExtra("word");

if(word.equals("a"))
{
	iv.setBackgroundResource(R.drawable.a);
}
if(word.equals("b"))
{
	iv.setBackgroundResource(R.drawable.b);
}
if(word.equals("c"))
{
	iv.setBackgroundResource(R.drawable.c);
}
if(word.equals("d"))
{
	iv.setBackgroundResource(drawable.d);
}
if(word.equals("e"))
{
	iv.setBackgroundResource(drawable.e);
}
if(word.equals("f"))
{
	iv.setBackgroundResource(drawable.f);
}
if(word.equals("g"))
{
	iv.setBackgroundResource(drawable.g);
}
if(word.equals("h"))
{
	iv.setBackgroundResource(drawable.h);
}
if(word.equals("i"))
{
	iv.setBackgroundResource(drawable.i);
}
if(word.equals("j"))
{
	iv.setBackgroundResource(drawable.j);
}
if(word.equals("k"))
{
	iv.setBackgroundResource(drawable.k);
}
if(word.equals("l"))
{
	iv.setBackgroundResource(drawable.l);
}
if(word.equals("m"))
{
	iv.setBackgroundResource(drawable.m);
}
if(word.equals("n"))
{
	iv.setBackgroundResource(drawable.n);
}
if(word.equals("o"))
{
	iv.setBackgroundResource(drawable.o);
}
if(word.equals("p"))
{
	iv.setBackgroundResource(drawable.p);
}
if(word.equals("q"))
{
	iv.setBackgroundResource(drawable.q);
}
if(word.equals("r"))
{
	iv.setBackgroundResource(drawable.r);
}
if(word.equals("s"))
{
	iv.setBackgroundResource(drawable.s);
}
if(word.equals("t"))
{
	iv.setBackgroundResource(drawable.t);
}
if(word.equals("u"))
{
	iv.setBackgroundResource(drawable.u);
}
if(word.equals("v"))
{
	iv.setBackgroundResource(drawable.v);
}
if(word.equals("w"))
{
	iv.setBackgroundResource(drawable.w);
}
if(word.equals("x"))
{
	iv.setBackgroundResource(drawable.x);
}
if(word.equals("y"))
{
	iv.setBackgroundResource(drawable.y);
}
if(word.equals("z"))
{
	iv.setBackgroundResource(drawable.z);
}


		
	} 
	

}
