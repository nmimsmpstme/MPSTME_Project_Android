package com.delta.attendancetracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity
{
  JSONArray cList = new JSONArray();
  ListView lv;
  TextView tvempty;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    this.lv = ((ListView)findViewById(2131230749));
    this.tvempty = ((TextView)findViewById(16908292));
    this.lv.setEmptyView(this.tvempty);
    Toast.makeText(this, "Long press a course to edit", 0).show();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165188, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131230752:
    }
    startActivity(new Intent(this, AddCourse.class));
    return true;
  }

  protected void onResume()
  {
    super.onResume();
    String str = Prefs.getMyStringPref(this, "Courses");
    try
    {
      this.cList = new JSONArray(str);
      int i = this.cList.length();
      arrayOfString = new String[i];
      j = 0;
      if (j >= i)
      {
        localArrayList = new ArrayList();
        k = 0;
        if (k < arrayOfString.length)
          break label164;
        StableArrayAdapter localStableArrayAdapter = new StableArrayAdapter(this, 17367043, localArrayList);
        this.lv.setAdapter(localStableArrayAdapter);
        this.lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
          {
            Log.v("long clicked", "pos: " + paramInt);
            Intent localIntent = new Intent(MainActivity.this, CourseAttendance.class);
            try
            {
              localIntent.putExtra("details", MainActivity.this.cList.getString(paramInt));
              localIntent.putExtra("position", paramInt);
              System.out.println("JSON SHARED : " + MainActivity.this.cList.getString(paramInt));
              MainActivity.this.startActivity(localIntent);
              return;
            }
            catch (JSONException localJSONException)
            {
              while (true)
                localJSONException.printStackTrace();
            }
          }
        });
        this.lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
          {
            Log.v("long clicked", "pos: " + paramInt);
            Intent localIntent = new Intent(MainActivity.this, EditCourse.class);
            try
            {
              localIntent.putExtra("details", MainActivity.this.cList.getString(paramInt));
              MainActivity.this.startActivity(localIntent);
              return true;
            }
            catch (JSONException localJSONException)
            {
              while (true)
                localJSONException.printStackTrace();
            }
          }
        });
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      while (true)
      {
        String[] arrayOfString;
        int j;
        ArrayList localArrayList;
        int k;
        localJSONException1.printStackTrace();
        continue;
        try
        {
          arrayOfString[j] = this.cList.getJSONObject(j).getString("name");
          j++;
        }
        catch (JSONException localJSONException2)
        {
          while (true)
            localJSONException2.printStackTrace();
        }
        label164: localArrayList.add(arrayOfString[k]);
        k++;
      }
    }
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

