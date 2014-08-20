package com.example.scoreit;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton login=(ImageButton) findViewById(R.id.imagebutton1);
        
        login.setOnClickListener(new ImageButton.OnClickListener(){

        	@Override
        	 public void onClick(View v) {

        	 Intent myIntent=new Intent(MainActivity.this,MyActivity.class);
        	 
        	 startActivity(myIntent);

        	 }});
        
        
ImageButton login1=(ImageButton) findViewById(R.id.imagebutton2);
        
        login1.setOnClickListener(new ImageButton.OnClickListener(){

        	@Override
        	 public void onClick(View v) {

        	 Intent myIntent=new Intent(MainActivity.this,PlayStore.class);
        	 
        	 startActivity(myIntent);

        	 }});

    }


  
    
}
