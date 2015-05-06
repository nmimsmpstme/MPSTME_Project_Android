package com.akul.splitfare;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ConfigHandler 
{
	
	static SharedPreferences settings= PreferenceManager.getDefaultSharedPreferences(Reglogin.r.getApplicationContext());
	static void setuid(String uid)
	{
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("uid", uid);
		editor.commit();
	}
	static String getuid()
	{
		return settings.getString("uid", ""+-1);
	}
	static void setcurr(String curr)
	{
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("curr", curr);
		editor.commit();
	}
	static String getcurr()
	{
		return settings.getString("curr", "₹");
	}
	static void setn(String n)
	{
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("name", n);
		editor.commit();
	}
	static String getn()
	{
		return settings.getString("name", ""+-1);
	}
	static void setd(boolean d)
	{
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("dark", d);
		editor.commit();
	}
	static boolean getd()
	{
		return settings.getBoolean("dark",false);
	}
	static void setacc(int a)
	{
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt("accent", a);
		editor.commit();
	}
	static int getacc()
	{
		return settings.getInt("accent",0);
	}
	static int getColorres()
	{
		int c = R.color.red_500;
		switch(getacc())
	    {
	      case 0:
	      {
	        c = R.color.red_500;
	            break;
	      }
	      case 1:
	      {
	        c = R.color.blue_500;
	            break;
	      }
	      case 2:
	      {
	        c = R.color.green_500;
	            break;
	      }
	      case 3:
	      {
	        c = R.color.indigo_500;
	            break;
	      }
	      case 4:
	      {
	        c = R.color.pink_500;
	            break;
	      }
	      case 5:
	      {
	        c = R.color.purple_500;
	            break;
	      }
	      case 6:
	      {
	        c = R.color.teal_500;
	            break;
	      }
	    }
		return c;
	}
	static int getstyle()
	{
		int s = R.style.AppTheme;
		if(!getd())
		{
		switch(getacc())
		{
			case 0:
			{
				s = R.style.LTred;
						break;
			}
			case 1:
			{
				s = R.style.LTblue;
						break;
			}
			case 2:
			{
				s = R.style.LTgreen;
						break;
			}
			case 3:
			{
				s = R.style.LTindigo;
						break;
			}
			case 4:
			{
				s = R.style.LTpink;
						break;
			}
			case 5:
			{
				s = R.style.LTpurple;
						break;
			}
			case 6:
			{
				s = R.style.LTteal;
						break;
			}

		}
		}
		else
		{
			  switch(getacc())
			    {
			      case 0:
			      {
			        s = R.style.DTred;
			            break;
			      }
			      case 1:
			      {
			        s = R.style.DTblue;
			            break;
			      }
			      case 2:
			      {
			        s = R.style.DTgreen;
			            break;
			      }
			      case 3:
			      {
			        s = R.style.DTindigo;
			            break;
			      }
			      case 4:
			      {
			        s = R.style.DTpink;
			          //s = R.style.Theme_AppCompat;
			    	  break;
			      }
			      case 5:
			      {
			        s = R.style.DTpurple;
			            break;
			      }
			      case 6:
			      {
			        s = R.style.DTteal;
			            break;
			      }
			    }
		}
		return s;
	}
}
