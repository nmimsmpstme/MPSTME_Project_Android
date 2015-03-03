package com.example.recurso;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SecondPage extends Activity {
	
	Button fren,ger,spa;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn);
		
		fren=(Button)findViewById(R.id.lrn_btn11);
		ger=(Button)findViewById(R.id.lrn_btn22);
		spa=(Button)findViewById(R.id.lrn_btn33);
		
	}
	
	public void language(View v)
	{
	int iidd=v.getId();
	final Button gghh=(Button)findViewById(iidd);
	String bstring=gghh.getText().toString();
	gghh.setAlpha((float) 0.5);
	final Handler handler = new Handler();
	handler.postDelayed(new Runnable() {
	  @Override
	  public void run() {
	   gghh.setAlpha(1);
	  }
	}, 100);
	
	if(bstring.equals("French"))
	{
		Intent play=new Intent(this,level.class);
		play.putExtra("lang", "French");
		startActivity(play);
	}
	
	if(bstring.equals("German"))
	{
		Intent play=new Intent(this,level.class);
		play.putExtra("lang", "German");
		startActivity(play);	}
	
	if(bstring.equals("Italian"))
	{
		Intent play=new Intent(this,level.class);
		play.putExtra("lang", "Italian");
		startActivity(play);
	}
	
	overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
}
}