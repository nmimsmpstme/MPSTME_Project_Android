package com.example.aashya.thereadingroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by aashya on 27/03/15.
 */
public class splash extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }   catch (InterruptedException e)
                {
                    e.printStackTrace();
                }finally {
                    Intent start=new Intent("com.example.aashya.thereadingroom.menu");
                    startActivity(start);
                }
            }
        };
        timer.start();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        finish();

    }

}
