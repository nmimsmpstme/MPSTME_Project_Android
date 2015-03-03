package com.example.recurso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Advanced extends Activity{

		String bstring;
		String lang;
		Dialog d1;
		int total=0,count;

	

		@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub
			super.onBackPressed();
			overridePendingTransition(R.anim.back_down_in,R.anim.back_down_out);
		}
		
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advanced);
		
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");

		
	}
	
	public void jumpjump(View v) {
		// TODO Auto-generated method stub
		
		int iidd=v.getId();
		final Button gghh=(Button)findViewById(iidd);
		bstring=gghh.getText().toString();
		gghh.setAlpha((float) 0.5);
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		  @Override
		  public void run() {
		    gghh.setAlpha(1);
		  }
		}, 100);
		

		Intent in=getIntent();
		 String lang=in.getStringExtra("lang");
		if(bstring.equals("Pro"))
		{
			
			gghh.setAlpha((float) 0.5);	
			CopyReadAssets(lang+"_Pronouns.pdf");
				
		}
}
	
	

	public void jump (View v) {
		// TODO Auto-generated method stub
		
		int iidd=v.getId();
		final Button gghh=(Button)findViewById(iidd);
		bstring=gghh.getText().toString();
		gghh.setAlpha((float) 0.5);
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		  @Override
		  public void run() {
		    gghh.setAlpha(1);
		  }
		}, 100);
		

		if(bstring.equals("Politics"))
		{
			Intent play=new Intent(this,AdvGame.class);
			play.putExtra("lang", lang);
			play.putExtra("name", bstring);
			play.putExtra("number", "1");
			startActivity(play);
			
			overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		}
		
		if(bstring.equals("Feelings"))
		{
			Intent play=new Intent(this,AdvGame.class);
			play.putExtra("lang", lang);
			play.putExtra("name", bstring);
			play.putExtra("number", "1");
			startActivity(play);
			overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		}
		
		if(bstring.equals("Professions"))
		{
			Intent play=new Intent(this,AdvGame.class);
			play.putExtra("lang", lang);
			play.putExtra("name", bstring);
			play.putExtra("number", "1");
			startActivity(play);
			overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		}

		if(bstring.equals("conversation1"))
		{
			Intent play=new Intent(this,Conversation.class);
			play.putExtra("lang", lang);
			play.putExtra("name", bstring);
			play.putExtra("number", "1");
			startActivity(play);
			overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
		}
		
		
	}	
	private void CopyReadAssets(String str)  {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        
        File file = new File(getFilesDir(), str);
        try
        {
            in = assetManager.open(str);
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e)
        {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/"+str),
                "application/pdf");

        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }

    public void progresss (View v) {
		// TODO Auto-generated method stub
		

		d1=new Dialog(this,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		d1.setContentView(R.layout.progress);
		
		total=0;
		TextView p1 = (TextView)d1.findViewById(R.id.prog_textView1);
		int temp=retrieve("Politics");
		p1.setText("Politics= "+temp+"%");
		
		total=0;
		TextView room = (TextView)d1.findViewById(R.id.prog_textView2);
		room.setText("Feelings= "+retrieve("Feelings")+"%");
		
		total=0;
		TextView profession = (TextView)d1.findViewById(R.id.prog_textView3);
		profession.setText("Profession= "+retrieve("Professions")+"%");
		
		d1.show();
		}
    private int retrieve(String name) {
		// TODO Auto-generated method stub
		SQLiteDatabase db;
		Cursor c;
	
db = openOrCreateDatabase(lang, MODE_PRIVATE, null);
		
		
		c=db.query(lang+"_"+name, null, null, null, null, null, null);
		c=db.rawQuery("select * from "+ lang+"_"+name,null);	
		
		if (c != null ) 
		{
	     if  (c.moveToFirst()) 
	     	{
	           do {
	        		count=c.getCount();
	        		}while (c.moveToNext());
	         }
		}
		
		c.close();
		
		
		c=db.query(lang+"_"+name, null, null, null, null, null, null);
		for(int h=1;h<=count;h++)
		{
			
			c=db.rawQuery("select status from "+ lang+"_"+name+" where _id = "+h,null);	
			if (c != null ) 
			{
		     if  (c.moveToFirst()) 
		     	{
		           do {
		        		total=total+c.getInt((c.getColumnIndex("status")));
		           		}while (c.moveToNext());
		         }
			}
			
		}
		c.close();
		db.close();

		total=(total*100)/count;
		
return total;
	}


}