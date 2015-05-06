package com.delta.attendancetracker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
{
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    return new DatePickerDialog(getActivity(), (CourseAttendance)getActivity(), i, j, k);
  }
}

