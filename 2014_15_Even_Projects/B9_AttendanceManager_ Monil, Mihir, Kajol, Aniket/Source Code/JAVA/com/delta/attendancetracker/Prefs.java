package com.delta.attendancetracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Prefs
{
  public static void delPref(Context paramContext, String paramString)
  {
    getPrefs(paramContext).edit().remove(paramString).commit();
  }

  public static void deletePref(Context paramContext)
  {
    getPrefs(paramContext).edit().clear().commit();
  }

  public static Boolean getMyBoolPref(Context paramContext, String paramString)
  {
    return Boolean.valueOf(getPrefs(paramContext).getBoolean(paramString, false));
  }

  public static String getMyStringPref(Context paramContext, String paramString)
  {
    return getPrefs(paramContext).getString(paramString, "default");
  }

  private static SharedPreferences getPrefs(Context paramContext)
  {
    return paramContext.getSharedPreferences("myprefs", 0);
  }

  public static void setMyBoolPref(Context paramContext, String paramString, Boolean paramBoolean)
  {
    getPrefs(paramContext).edit().putBoolean(paramString, paramBoolean.booleanValue()).commit();
  }

  public static void setMyStringPref(Context paramContext, String paramString1, String paramString2)
  {
    getPrefs(paramContext).edit().putString(paramString1, paramString2).commit();
  }
}

