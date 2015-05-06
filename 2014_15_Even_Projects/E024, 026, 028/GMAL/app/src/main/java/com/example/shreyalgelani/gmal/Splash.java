package com.example.shreyalgelani.gmal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Shreyal Gelani on 14-03-2015.
 */
public class Splash extends Activity
{
    @Override
    protected void onCreate(Bundle slashactivity)
    {
        super.onCreate(slashactivity);
        setContentView(R.layout.splash);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }   catch (InterruptedException e)
                {
                e.printStackTrace();
                }finally {
                    Intent start=new Intent("com.example.shreyalgelani.gmal.GMAL_LOGIN");
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
