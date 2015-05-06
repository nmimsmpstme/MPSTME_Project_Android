package com.delta.attendancetracker;

import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditCourse extends Activity
{
  EditText code;
  JSONArray datesMissed;
  JSONObject details;
  Button edit;
  RadioButton lab;
  EditText name;
  EditText required;
  RadioGroup rg;
  RadioButton theory;
  EditText total;

  // ERROR //
  public void editCourse(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: new 30	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 31	org/json/JSONObject:<init>	()V
    //   7: pop
    //   8: new 33	java/lang/String
    //   11: dup
    //   12: invokespecial 34	java/lang/String:<init>	()V
    //   15: pop
    //   16: getstatic 40	java/lang/System:out	Ljava/io/PrintStream;
    //   19: new 42	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 44
    //   25: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload 6
    //   30: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 60	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   39: iload 5
    //   41: ldc 61
    //   43: if_icmpne +107 -> 150
    //   46: aload_0
    //   47: ldc 63
    //   49: invokestatic 69	com/delta/attendancetracker/Prefs:getMyStringPref	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 10
    //   54: new 71	org/json/JSONArray
    //   57: dup
    //   58: invokespecial 72	org/json/JSONArray:<init>	()V
    //   61: astore 11
    //   63: new 30	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 31	org/json/JSONObject:<init>	()V
    //   70: pop
    //   71: aload 10
    //   73: ifnull +35 -> 108
    //   76: new 71	org/json/JSONArray
    //   79: dup
    //   80: aload 10
    //   82: invokespecial 73	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   85: astore 13
    //   87: iconst_0
    //   88: istore 14
    //   90: aload 13
    //   92: invokevirtual 77	org/json/JSONArray:length	()I
    //   95: istore 16
    //   97: iload 14
    //   99: iload 16
    //   101: if_icmplt +52 -> 153
    //   104: aload 13
    //   106: astore 11
    //   108: aload_0
    //   109: ldc 63
    //   111: aload 11
    //   113: invokevirtual 78	org/json/JSONArray:toString	()Ljava/lang/String;
    //   116: invokestatic 82	com/delta/attendancetracker/Prefs:setMyStringPref	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   119: getstatic 40	java/lang/System:out	Ljava/io/PrintStream;
    //   122: new 42	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 84
    //   128: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload 11
    //   133: invokevirtual 78	org/json/JSONArray:toString	()Ljava/lang/String;
    //   136: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokevirtual 60	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   145: aload_0
    //   146: invokevirtual 87	com/delta/attendancetracker/EditCourse:finish	()V
    //   149: return
    //   150: goto -104 -> 46
    //   153: getstatic 40	java/lang/System:out	Ljava/io/PrintStream;
    //   156: iload 14
    //   158: invokevirtual 90	java/io/PrintStream:println	(I)V
    //   161: aload 13
    //   163: iload 14
    //   165: invokevirtual 94	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   168: ldc 95
    //   170: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   173: aload 6
    //   175: invokevirtual 103	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   178: ifeq +123 -> 301
    //   181: getstatic 40	java/lang/System:out	Ljava/io/PrintStream;
    //   184: ldc 105
    //   186: invokevirtual 60	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   189: aload 13
    //   191: iload 14
    //   193: invokevirtual 94	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   196: ldc 95
    //   198: aload_1
    //   199: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload 13
    //   205: iload 14
    //   207: invokevirtual 94	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   210: ldc 111
    //   212: aload_2
    //   213: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload 13
    //   219: iload 14
    //   221: invokevirtual 94	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   224: ldc 112
    //   226: aload_3
    //   227: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   230: pop
    //   231: aload 13
    //   233: iload 14
    //   235: invokevirtual 94	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   238: ldc 113
    //   240: aload 4
    //   242: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 13
    //   248: iload 14
    //   250: invokevirtual 94	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   253: ldc 114
    //   255: aload 7
    //   257: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   260: pop
    //   261: iload 5
    //   263: ldc 61
    //   265: if_icmpne +29 -> 294
    //   268: ldc 115
    //   270: astore 22
    //   272: aload 13
    //   274: iload 14
    //   276: invokevirtual 94	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   279: ldc 117
    //   281: aload 22
    //   283: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   286: pop
    //   287: aload 13
    //   289: astore 11
    //   291: goto -183 -> 108
    //   294: ldc 118
    //   296: astore 22
    //   298: goto -26 -> 272
    //   301: iinc 14 1
    //   304: goto -214 -> 90
    //   307: astore 15
    //   309: aload 15
    //   311: invokevirtual 121	org/json/JSONException:printStackTrace	()V
    //   314: goto -206 -> 108
    //   317: astore 15
    //   319: aload 13
    //   321: astore 11
    //   323: goto -14 -> 309
    //
    // Exception table:
    //   from	to	target	type
    //   76	87	307	org/json/JSONException
    //   90	97	317	org/json/JSONException
    //   153	261	317	org/json/JSONException
    //   272	287	317	org/json/JSONException
  }

  // ERROR //
  protected void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 125	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: ldc 126
    //   8: invokevirtual 129	com/delta/attendancetracker/EditCourse:setContentView	(I)V
    //   11: aload_0
    //   12: new 71	org/json/JSONArray
    //   15: dup
    //   16: invokespecial 72	org/json/JSONArray:<init>	()V
    //   19: putfield 131	com/delta/attendancetracker/EditCourse:datesMissed	Lorg/json/JSONArray;
    //   22: aload_0
    //   23: invokevirtual 135	com/delta/attendancetracker/EditCourse:getIntent	()Landroid/content/Intent;
    //   26: ldc 136
    //   28: invokevirtual 141	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: new 30	org/json/JSONObject
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 142	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: putfield 144	com/delta/attendancetracker/EditCourse:details	Lorg/json/JSONObject;
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 144	com/delta/attendancetracker/EditCourse:details	Lorg/json/JSONObject;
    //   49: ldc 114
    //   51: invokevirtual 148	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   54: putfield 131	com/delta/attendancetracker/EditCourse:datesMissed	Lorg/json/JSONArray;
    //   57: aload_0
    //   58: aload_0
    //   59: ldc 149
    //   61: invokevirtual 153	com/delta/attendancetracker/EditCourse:findViewById	(I)Landroid/view/View;
    //   64: checkcast 155	android/widget/EditText
    //   67: putfield 157	com/delta/attendancetracker/EditCourse:name	Landroid/widget/EditText;
    //   70: aload_0
    //   71: aload_0
    //   72: ldc 158
    //   74: invokevirtual 153	com/delta/attendancetracker/EditCourse:findViewById	(I)Landroid/view/View;
    //   77: checkcast 155	android/widget/EditText
    //   80: putfield 160	com/delta/attendancetracker/EditCourse:code	Landroid/widget/EditText;
    //   83: aload_0
    //   84: aload_0
    //   85: ldc 161
    //   87: invokevirtual 153	com/delta/attendancetracker/EditCourse:findViewById	(I)Landroid/view/View;
    //   90: checkcast 155	android/widget/EditText
    //   93: putfield 163	com/delta/attendancetracker/EditCourse:total	Landroid/widget/EditText;
    //   96: aload_0
    //   97: aload_0
    //   98: ldc 164
    //   100: invokevirtual 153	com/delta/attendancetracker/EditCourse:findViewById	(I)Landroid/view/View;
    //   103: checkcast 155	android/widget/EditText
    //   106: putfield 166	com/delta/attendancetracker/EditCourse:required	Landroid/widget/EditText;
    //   109: aload_0
    //   110: aload_0
    //   111: ldc 167
    //   113: invokevirtual 153	com/delta/attendancetracker/EditCourse:findViewById	(I)Landroid/view/View;
    //   116: checkcast 169	android/widget/RadioGroup
    //   119: putfield 171	com/delta/attendancetracker/EditCourse:rg	Landroid/widget/RadioGroup;
    //   122: aload_0
    //   123: aload_0
    //   124: ldc 61
    //   126: invokevirtual 153	com/delta/attendancetracker/EditCourse:findViewById	(I)Landroid/view/View;
    //   129: checkcast 173	android/widget/RadioButton
    //   132: putfield 175	com/delta/attendancetracker/EditCourse:theory	Landroid/widget/RadioButton;
    //   135: aload_0
    //   136: aload_0
    //   137: ldc 176
    //   139: invokevirtual 153	com/delta/attendancetracker/EditCourse:findViewById	(I)Landroid/view/View;
    //   142: checkcast 173	android/widget/RadioButton
    //   145: putfield 178	com/delta/attendancetracker/EditCourse:lab	Landroid/widget/RadioButton;
    //   148: aload_0
    //   149: aload_0
    //   150: ldc 179
    //   152: invokevirtual 153	com/delta/attendancetracker/EditCourse:findViewById	(I)Landroid/view/View;
    //   155: checkcast 181	android/widget/Button
    //   158: putfield 183	com/delta/attendancetracker/EditCourse:edit	Landroid/widget/Button;
    //   161: aload_0
    //   162: getfield 183	com/delta/attendancetracker/EditCourse:edit	Landroid/widget/Button;
    //   165: new 185	com/delta/attendancetracker/EditCourse$1
    //   168: dup
    //   169: aload_0
    //   170: invokespecial 188	com/delta/attendancetracker/EditCourse$1:<init>	(Lcom/delta/attendancetracker/EditCourse;)V
    //   173: invokevirtual 192	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   176: aload_0
    //   177: getfield 157	com/delta/attendancetracker/EditCourse:name	Landroid/widget/EditText;
    //   180: aload_0
    //   181: getfield 144	com/delta/attendancetracker/EditCourse:details	Lorg/json/JSONObject;
    //   184: ldc 95
    //   186: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual 196	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
    //   192: aload_0
    //   193: getfield 160	com/delta/attendancetracker/EditCourse:code	Landroid/widget/EditText;
    //   196: aload_0
    //   197: getfield 144	com/delta/attendancetracker/EditCourse:details	Lorg/json/JSONObject;
    //   200: ldc 111
    //   202: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   205: invokevirtual 196	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
    //   208: aload_0
    //   209: getfield 163	com/delta/attendancetracker/EditCourse:total	Landroid/widget/EditText;
    //   212: aload_0
    //   213: getfield 144	com/delta/attendancetracker/EditCourse:details	Lorg/json/JSONObject;
    //   216: ldc 112
    //   218: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   221: invokevirtual 196	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
    //   224: aload_0
    //   225: getfield 166	com/delta/attendancetracker/EditCourse:required	Landroid/widget/EditText;
    //   228: aload_0
    //   229: getfield 144	com/delta/attendancetracker/EditCourse:details	Lorg/json/JSONObject;
    //   232: ldc 113
    //   234: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokevirtual 196	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
    //   240: aload_0
    //   241: getfield 144	com/delta/attendancetracker/EditCourse:details	Lorg/json/JSONObject;
    //   244: ldc 117
    //   246: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: ldc 115
    //   251: invokevirtual 103	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: ifeq +20 -> 274
    //   257: aload_0
    //   258: getfield 175	com/delta/attendancetracker/EditCourse:theory	Landroid/widget/RadioButton;
    //   261: iconst_1
    //   262: invokevirtual 200	android/widget/RadioButton:setSelected	(Z)V
    //   265: return
    //   266: astore_3
    //   267: aload_3
    //   268: invokevirtual 121	org/json/JSONException:printStackTrace	()V
    //   271: goto -214 -> 57
    //   274: aload_0
    //   275: getfield 178	com/delta/attendancetracker/EditCourse:lab	Landroid/widget/RadioButton;
    //   278: iconst_1
    //   279: invokevirtual 200	android/widget/RadioButton:setSelected	(Z)V
    //   282: return
    //   283: astore 4
    //   285: aload 4
    //   287: invokevirtual 121	org/json/JSONException:printStackTrace	()V
    //   290: return
    //
    // Exception table:
    //   from	to	target	type
    //   32	57	266	org/json/JSONException
    //   176	265	283	org/json/JSONException
    //   274	282	283	org/json/JSONException
  }
}

