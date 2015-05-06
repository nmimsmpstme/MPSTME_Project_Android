package com.delta.attendancetracker;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.io.PrintStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddCourse extends Activity
{
  Button add;
  EditText courseCode;
  EditText courseName;
  EditText percentRequired;
  RadioGroup radioButtonGroup;
  EditText totalClasses;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    this.add = ((Button)findViewById(2131230728));
    this.courseName = ((EditText)findViewById(2131230720));
    this.courseCode = ((EditText)findViewById(2131230722));
    this.totalClasses = ((EditText)findViewById(2131230723));
    this.percentRequired = ((EditText)findViewById(2131230724));
    this.radioButtonGroup = ((RadioGroup)findViewById(2131230725));
    this.add.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        String str1 = AddCourse.this.courseName.getText().toString();
        String str2 = AddCourse.this.courseCode.getText().toString();
        String str3 = AddCourse.this.totalClasses.getText().toString();
        String str4 = AddCourse.this.percentRequired.getText().toString();
        int i = AddCourse.this.radioButtonGroup.getCheckedRadioButtonId();
        if ((str1.length() == 0) || (str2.length() == 0) || (str3.length() == 0) || (str4.length() == 0))
        {
          Toast.makeText(AddCourse.this, "Please fill all fields!", 0).show();
          return;
        }
        if (Integer.parseInt(str4) > 100)
        {
          Toast.makeText(AddCourse.this, "Required % cannot be greater than 100!", 0).show();
          return;
        }
        AddCourse.this.storeCourse(str1, str2, str3, str4, i);
      }
    });
  }

  public void storeCourse(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = new String();
    System.out.println("In Button Click");
    try
    {
      System.out.println("In Try");
      localJSONObject.put("name", paramString1);
      localJSONObject.put("id", paramString2);
      localJSONObject.put("total", paramString3);
      localJSONObject.put("required", paramString4);
      localJSONObject.put("classesHeld", "0");
      localJSONObject.put("classesMissed", "0");
      localJSONObject.put("datesMissed", new JSONArray());
      if (paramInt == 2131230726)
      {
        str1 = "theory";
        localJSONObject.put("type", str1);
      }
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        System.out.println("Course :::::::: " + localJSONObject.getString("name"));
        new StringBuilder(String.valueOf(paramString1)).append(str1).toString();
        str2 = Prefs.getMyStringPref(this, "Courses");
        localObject = new JSONArray();
        if (str2 == null);
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          while (true)
          {
            String str2;
            JSONArray localJSONArray = new JSONArray(str2);
            Object localObject = localJSONArray;
            ((JSONArray)localObject).put(localJSONObject);
            Prefs.setMyStringPref(this, "Courses", ((JSONArray)localObject).toString());
            System.out.println("Courses ::: " + ((JSONArray)localObject).toString());
            finish();
            return;
            str1 = "lab";
            continue;
            localJSONException1 = localJSONException1;
            localJSONException1.printStackTrace();
          }
          localJSONException2 = localJSONException2;
          localJSONException2.printStackTrace();
        }
        catch (JSONException localJSONException3)
        {
          while (true)
            localJSONException3.printStackTrace();
        }
      }
    }
  }
}

