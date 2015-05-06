package com.example.smitd.appproject;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by smitD on 3/18/2015.
 */
public class Config
{
   static  SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(projectmain.p.getApplicationContext());
static void addf(int x)
{
    int fc = SP.getInt("fc", 0);
    SharedPreferences.Editor e = SP.edit();
    e.putInt("food_"+fc+1 ,x);
    e.putInt("fc",fc+1);
    e.apply();
    e.commit();
}
    static void addd(int x)
    {
        int fc = SP.getInt("fc", 0);
        SharedPreferences.Editor e = SP.edit();
        e.putInt("drink_"+fc+1 ,x);
        e.putInt("fc",fc+1);
        e.apply();
        e.commit();
    }
    static void addfu(int x)
    {
        int fc = SP.getInt("fc", 0);
        SharedPreferences.Editor e = SP.edit();
        e.putInt("fuel_"+fc+1 ,x);
        e.putInt("fc",fc+1);
        e.apply();
        e.commit();
    }
    static void addh(int x)
    {
        int fc = SP.getInt("fc", 0);
        SharedPreferences.Editor e = SP.edit();
        e.putInt("hotel_"+fc+1 ,x);
        e.putInt("fc",fc+1);
        e.apply();
        e.commit();
    }
    static int[] getf()
    {
       int fc = SP.getInt("fc", 0);
       int[] food= new int[fc];
       for(int t=0;t<fc;t++)
       {
           food[t] = SP.getInt("food_"+t+1,0);
       }
        return food;
    }
    static int[] getd()
    {
        int fc = SP.getInt("fc", 0);
        int[] drink= new int[fc];
        for(int t=0;t<fc;t++)
        {
            drink[t] = SP.getInt("drink_"+t+1,0);
        }
        return drink;
    }
    static int[] getfu()
    {
        int fc = SP.getInt("fc", 0);
        int[] fuel= new int[fc];
        for(int t=0;t<fc;t++)
        {
            fuel[t] = SP.getInt("fuel_"+t+1,0);
        }
        return fuel;
    }
    static int[] geth()
    {
        int fc = SP.getInt("fc", 0);
        int[] hotel= new int[fc];
        for(int t=0;t<fc;t++)
        {
            hotel[t] = SP.getInt("hotel_"+t+1,0);
        }
        return hotel;
    }
  static void clearf()
  {
      SharedPreferences.Editor e = SP.edit();
      e.putInt("fc",0);
      e.apply();
      e.commit();
  }
}
