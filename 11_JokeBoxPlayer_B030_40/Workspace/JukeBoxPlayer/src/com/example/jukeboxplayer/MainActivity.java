package com.example.jukeboxplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		Button songs = (Button) findViewById(R.id.button1);
		songs.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(),Playlists.class);
				
				startActivityForResult(intent,0);
			}
		});
		
		Button playlists = (Button) findViewById(R.id.button2);
		playlists.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(),Playlists.class);
			
				startActivityForResult(intent,0);
			}
		});
		
		Button albums = (Button) findViewById(R.id.button3);
		albums.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(),Albums.class);
			
				startActivityForResult(intent,0);
			}
		});
		
		Button artists = (Button) findViewById(R.id.button4);
		artists.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(),Artists.class);
				
				startActivityForResult(intent,0);
			}
		});
		
		Button genre = (Button) findViewById(R.id.button5);
		genre.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(),Genre.class);
			
				startActivityForResult(intent,0);
			}
		});
		
		Button editText1 = (Button) findViewById(R.id.editText1);
		editText1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(v.getContext(),YouTube.class);
			
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
