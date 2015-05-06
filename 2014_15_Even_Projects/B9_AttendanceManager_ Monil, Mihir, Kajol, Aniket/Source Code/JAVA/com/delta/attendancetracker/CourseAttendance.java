package com.delta.attendancetracker;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class CourseAttendance extends FragmentActivity
  implements DatePickerDialog.OnDateSetListener
{
  StableArrayAdapter adapter;
  TextView attendance;
  ListView classesmissed;
  String courseName;
  StringBuilder currentdate1 = new StringBuilder();
  int dd;
  TextView estimated;
  JSONObject extra;
  String extras;
  Button heldminus;
  Button heldplus;
  private int listPosition = -1;
  ArrayList<String> missedlist = new ArrayList();
  Button missedminus;
  Button missedplus;
  int mm;
  TextView nClassesHeld;
  TextView nClassesMissed;
  int position;
  TextView reqd;
  int yy;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    Intent localIntent = getIntent();
    this.extras = localIntent.getStringExtra("details");
    this.position = localIntent.getIntExtra("position", -1);
    Object localObject = new JSONArray();
    this.classesmissed = ((ListView)findViewById(2131230747));
    this.nClassesHeld = ((TextView)findViewById(2131230731));
    this.nClassesMissed = ((TextView)findViewById(2131230737));
    this.reqd = ((TextView)findViewById(2131230742));
    this.attendance = ((TextView)findViewById(2131230743));
    this.estimated = ((TextView)findViewById(2131230746));
    this.heldplus = ((Button)findViewById(2131230734));
    this.heldminus = ((Button)findViewById(2131230733));
    this.missedplus = ((Button)findViewById(2131230740));
    this.missedminus = ((Button)findViewById(2131230739));
    this.missedlist = new ArrayList();
    while (true)
    {
      int i;
      try
      {
        this.extra = new JSONObject(this.extras);
        this.nClassesHeld.setText(this.extra.getString("classesHeld"));
        this.nClassesMissed.setText(this.extra.getString("classesMissed"));
        this.reqd.setText(this.extra.getString("required"));
        this.courseName = this.extra.getString("name");
        getActionBar().setTitle(this.courseName);
        JSONArray localJSONArray = this.extra.getJSONArray("datesMissed");
        localObject = localJSONArray;
        i = 0;
        if (i >= ((JSONArray)localObject).length())
        {
          this.adapter = new StableArrayAdapter(this, 17367043, this.missedlist);
          this.classesmissed.setAdapter(this.adapter);
          this.classesmissed.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
            {
              CourseAttendance.this.listPosition = paramInt;
              CourseAttendance.this.showDatePickerDialog(paramView);
            }
          });
          this.heldplus.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramView)
            {
              int i = 1 + Integer.parseInt(CourseAttendance.this.nClassesHeld.getText().toString());
              Object localObject = new String();
              try
              {
                String str = CourseAttendance.this.extra.getString("total");
                localObject = str;
                float f = Integer.parseInt((String)localObject);
                if (i <= f)
                  CourseAttendance.this.nClassesHeld.setText(Integer.toString(i));
                CourseAttendance.this.update();
                return;
              }
              catch (JSONException localJSONException)
              {
                while (true)
                  localJSONException.printStackTrace();
              }
            }
          });
          this.heldminus.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramView)
            {
              int i = -1 + Integer.parseInt(CourseAttendance.this.nClassesHeld.getText().toString());
              int j = Integer.parseInt(CourseAttendance.this.nClassesMissed.getText().toString());
              if ((i >= 0) && (i >= j))
                CourseAttendance.this.nClassesHeld.setText(Integer.toString(i));
              CourseAttendance.this.update();
            }
          });
          this.missedplus.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramView)
            {
              int i = 1 + Integer.parseInt(CourseAttendance.this.nClassesMissed.getText().toString());
              if (i <= Integer.parseInt(CourseAttendance.this.nClassesHeld.getText().toString()))
              {
                CourseAttendance.this.nClassesMissed.setText(Integer.toString(i));
                Calendar localCalendar = Calendar.getInstance();
                CourseAttendance.this.yy = localCalendar.get(1);
                CourseAttendance.this.mm = localCalendar.get(2);
                CourseAttendance.this.dd = localCalendar.get(5);
                StringBuilder localStringBuilder = new StringBuilder().append(CourseAttendance.this.dd).append(" ").append("/").append(" ").append(1 + CourseAttendance.this.mm).append(" /").append(" ").append(CourseAttendance.this.yy);
                CourseAttendance.this.missedlist.add(localStringBuilder.toString());
                CourseAttendance.this.adapter = new CourseAttendance.StableArrayAdapter(CourseAttendance.this, CourseAttendance.this, 17367043, CourseAttendance.this.missedlist);
                CourseAttendance.this.adapter.notifyDataSetChanged();
                CourseAttendance.this.classesmissed.setAdapter(CourseAttendance.this.adapter);
                CourseAttendance.this.classesmissed.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
                  {
                    CourseAttendance.this.listPosition = paramInt;
                    CourseAttendance.this.showDatePickerDialog(paramView);
                  }
                });
              }
              CourseAttendance.this.update();
            }
          });
          this.missedminus.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramView)
            {
              int i = -1 + Integer.parseInt(CourseAttendance.this.nClassesMissed.getText().toString());
              if (i >= 0)
              {
                CourseAttendance.this.nClassesMissed.setText(Integer.toString(i));
                if (CourseAttendance.this.missedlist.size() != 0)
                {
                  CourseAttendance.this.missedlist.remove(-1 + CourseAttendance.this.missedlist.size());
                  CourseAttendance.this.adapter.notifyDataSetChanged();
                }
                CourseAttendance.this.adapter = new CourseAttendance.StableArrayAdapter(CourseAttendance.this, CourseAttendance.this, 17367043, CourseAttendance.this.missedlist);
                CourseAttendance.this.classesmissed.setAdapter(CourseAttendance.this.adapter);
                CourseAttendance.this.classesmissed.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
                  {
                    CourseAttendance.this.listPosition = paramInt;
                    CourseAttendance.this.showDatePickerDialog(paramView);
                  }
                });
              }
              CourseAttendance.this.update();
            }
          });
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      try
      {
        this.missedlist.add(((JSONArray)localObject).getString(i));
        i++;
      }
      catch (JSONException localJSONException2)
      {
        while (true)
          localJSONException2.printStackTrace();
      }
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165186, paramMenu);
    return true;
  }

  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    this.currentdate1 = new StringBuilder().append(paramInt3).append(" ").append("/").append(" ").append(paramInt2 + 1).append("/").append(" ").append(paramInt1);
    this.missedlist.set(this.listPosition, this.currentdate1.toString());
    this.adapter = new StableArrayAdapter(this, 17367043, this.missedlist);
    this.classesmissed.setAdapter(this.adapter);
    this.classesmissed.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        CourseAttendance.this.listPosition = paramInt;
        CourseAttendance.this.showDatePickerDialog(paramView);
      }
    });
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131230751:
    }
    System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIIi");
    while (true)
    {
      int i;
      int j;
      try
      {
        JSONArray localJSONArray1 = new JSONArray();
        JSONArray localJSONArray2 = new JSONArray(Prefs.getMyStringPref(this, "Courses"));
        i = localJSONArray2.length();
        if (localJSONArray2 == null)
          continue;
        j = 0;
        break label132;
        Prefs.setMyStringPref(this, "Courses", localJSONArray1.toString());
        finish();
        break;
        if (j == this.position)
          continue;
        localJSONArray1.put(localJSONArray2.get(j));
        j++;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        break;
      }
      label132: if (j < i)
        continue;
    }
    return true;
  }

  protected void onPause()
  {
    super.onPause();
    updateSharedPref();
  }

  protected void onResume()
  {
    super.onResume();
    update();
  }

  public void showDatePickerDialog(View paramView)
  {
    new DatePickerFragment().show(getSupportFragmentManager(), "datePicker");
  }

  public void update()
  {
    System.out.println("In update");
    float f1 = Integer.parseInt(this.nClassesHeld.getText().toString());
    float f2 = Integer.parseInt(this.nClassesMissed.getText().toString());
    System.out.println(f1 + " " + f2);
    float f3 = Integer.parseInt(this.reqd.getText().toString());
    System.out.println(f3);
    float f4 = 100.0F - 100.0F * (f2 / f1);
    System.out.println(f4);
    if (f1 != 0.0D)
      this.attendance.setText(Float.toString(f4));
    while (true)
    {
      Object localObject = new String();
      try
      {
        String str = this.extra.getString("total");
        localObject = str;
        float f5 = Integer.parseInt((String)localObject);
        System.out.println("Total ::::::::: " + f5);
        float f6 = 100.0F * ((f5 - f2) / f5);
        this.estimated.setText(Float.toString(f6));
        return;
        this.attendance.setText("0");
      }
      catch (JSONException localJSONException)
      {
        while (true)
          localJSONException.printStackTrace();
      }
    }
  }

  // ERROR //
  public void updateSharedPref()
  {
    // Byte code:
    //   0: new 135	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 377	org/json/JSONObject:<init>	()V
    //   7: pop
    //   8: aload_0
    //   9: ldc_w 284
    //   12: invokestatic 290	com/delta/attendancetracker/Prefs:getMyStringPref	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_2
    //   16: new 92	org/json/JSONArray
    //   19: dup
    //   20: invokespecial 93	org/json/JSONArray:<init>	()V
    //   23: astore_3
    //   24: new 135	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 377	org/json/JSONObject:<init>	()V
    //   31: pop
    //   32: aload_2
    //   33: ifnull +33 -> 66
    //   36: new 92	org/json/JSONArray
    //   39: dup
    //   40: aload_2
    //   41: invokespecial 291	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: iconst_0
    //   47: istore 6
    //   49: aload 5
    //   51: invokevirtual 176	org/json/JSONArray:length	()I
    //   54: istore 8
    //   56: iload 6
    //   58: iload 8
    //   60: if_icmplt +44 -> 104
    //   63: aload 5
    //   65: astore_3
    //   66: aload_0
    //   67: ldc_w 284
    //   70: aload_3
    //   71: invokevirtual 292	org/json/JSONArray:toString	()Ljava/lang/String;
    //   74: invokestatic 296	com/delta/attendancetracker/Prefs:setMyStringPref	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   77: getstatic 275	java/lang/System:out	Ljava/io/PrintStream;
    //   80: new 48	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 379
    //   87: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_3
    //   91: invokevirtual 292	org/json/JSONArray:toString	()Ljava/lang/String;
    //   94: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 282	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   103: return
    //   104: getstatic 275	java/lang/System:out	Ljava/io/PrintStream;
    //   107: iload 6
    //   109: invokevirtual 381	java/io/PrintStream:println	(I)V
    //   112: aload 5
    //   114: iload 6
    //   116: invokevirtual 385	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   119: ldc 155
    //   121: invokevirtual 145	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: aload_0
    //   125: getfield 157	com/delta/attendancetracker/CourseAttendance:courseName	Ljava/lang/String;
    //   128: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifeq +160 -> 291
    //   134: getstatic 275	java/lang/System:out	Ljava/io/PrintStream;
    //   137: ldc_w 390
    //   140: invokevirtual 282	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   143: aload 5
    //   145: iload 6
    //   147: invokevirtual 385	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   150: ldc 142
    //   152: aload_0
    //   153: getfield 107	com/delta/attendancetracker/CourseAttendance:nClassesHeld	Landroid/widget/TextView;
    //   156: invokevirtual 342	android/widget/TextView:getText	()Ljava/lang/CharSequence;
    //   159: invokeinterface 345 1 0
    //   164: invokevirtual 393	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload 5
    //   170: iload 6
    //   172: invokevirtual 385	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   175: ldc 151
    //   177: aload_0
    //   178: getfield 110	com/delta/attendancetracker/CourseAttendance:nClassesMissed	Landroid/widget/TextView;
    //   181: invokevirtual 342	android/widget/TextView:getText	()Ljava/lang/CharSequence;
    //   184: invokeinterface 345 1 0
    //   189: invokevirtual 393	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   192: pop
    //   193: getstatic 275	java/lang/System:out	Ljava/io/PrintStream;
    //   196: new 48	java/lang/StringBuilder
    //   199: dup
    //   200: ldc_w 395
    //   203: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: aload_0
    //   207: getfield 56	com/delta/attendancetracker/CourseAttendance:missedlist	Ljava/util/ArrayList;
    //   210: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 282	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   219: new 92	org/json/JSONArray
    //   222: dup
    //   223: invokespecial 93	org/json/JSONArray:<init>	()V
    //   226: astore 11
    //   228: iconst_0
    //   229: istore 12
    //   231: iload 12
    //   233: aload_0
    //   234: getfield 56	com/delta/attendancetracker/CourseAttendance:missedlist	Ljava/util/ArrayList;
    //   237: invokevirtual 401	java/util/ArrayList:size	()I
    //   240: if_icmplt +24 -> 264
    //   243: aload 5
    //   245: iload 6
    //   247: invokevirtual 385	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   250: ldc 168
    //   252: aload 11
    //   254: invokevirtual 393	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   257: pop
    //   258: aload 5
    //   260: astore_3
    //   261: goto -195 -> 66
    //   264: aload 11
    //   266: aload_0
    //   267: getfield 56	com/delta/attendancetracker/CourseAttendance:missedlist	Ljava/util/ArrayList;
    //   270: iload 12
    //   272: invokevirtual 402	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   275: checkcast 353	java/lang/String
    //   278: invokevirtual 403	java/lang/String:toString	()Ljava/lang/String;
    //   281: invokevirtual 307	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   284: pop
    //   285: iinc 12 1
    //   288: goto -57 -> 231
    //   291: iinc 6 1
    //   294: goto -245 -> 49
    //   297: astore 7
    //   299: aload 7
    //   301: invokevirtual 216	org/json/JSONException:printStackTrace	()V
    //   304: goto -238 -> 66
    //   307: astore 7
    //   309: aload 5
    //   311: astore_3
    //   312: goto -13 -> 299
    //
    // Exception table:
    //   from	to	target	type
    //   36	46	297	org/json/JSONException
    //   49	56	307	org/json/JSONException
    //   104	228	307	org/json/JSONException
    //   231	258	307	org/json/JSONException
    //   264	285	307	org/json/JSONException
  }

  public void updatedate(String paramString, int paramInt)
  {
    this.missedlist.set(paramInt, paramString);
    this.adapter.notifyDataSetChanged();
    this.classesmissed.setAdapter(this.adapter);
  }

  private class StableArrayAdapter extends ArrayAdapter<String>
  {
    HashMap<String, Integer> mIdMap = new HashMap();

    public StableArrayAdapter(int paramList, List<String> arg3)
    {
      super(i, localList);
      for (int j = 0; ; j++)
      {
        if (j >= localList.size())
          return;
        this.mIdMap.put((String)localList.get(j), Integer.valueOf(j));
      }
    }

    public long getItemId(int paramInt)
    {
      String str = (String)getItem(paramInt);
      return ((Integer)this.mIdMap.get(str)).intValue();
    }

    public boolean hasStableIds()
    {
      return true;
    }
  }
}

