package org.mazzarellialessio.studenttimetable;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDBManager {
	
	public static MyDBHelper dbh;
	
	public MyDBManager(Context c) {
		dbh = new MyDBHelper(c);
	}
	
	public void insertIntoSubjects(String SName, String STeacher, String SColor) {
		SQLiteDatabase db = dbh.getWritableDatabase();
		try {
			ContentValues values = new ContentValues();
			values.put("SName", SName);
			values.put("STeacher", STeacher);
			values.put("SColor", SColor);
			db.insert("Subjects", "", values);
		} finally {
			if(db!= null)
				db.close();
		}
	}
	
	public void updateSubjects(String SName, String STeacher, String SColor) {
		SQLiteDatabase db = dbh.getWritableDatabase();
		try {
			ContentValues values = new ContentValues();
			values.put("STeacher", STeacher);
			values.put("SColor", SColor);
			db.update("Subjects", values, "SName='"+SName+"'", null);
		} finally {
			if(db!= null)
				db.close();
		}
	}
	
	public void deleteSubjects(String SName) {
		SQLiteDatabase db = dbh.getWritableDatabase();
		try {
			db.delete("Subjects", "SName='"+SName+"'", null);
			db.delete("Hours", "SName='"+SName+"'", null);
		} finally {
			if(db!= null)
				db.close();
		}
	}
	
	public void updateHours(String OLDSName, String OLDHClass, int OLDHDay, String OLDHStart, String OLDHEnd,
			String SName, int HDay, String HClass, String HStart, String HEnd) {
		
		SQLiteDatabase db = dbh.getWritableDatabase();
		try {
			ContentValues values = new ContentValues();
			values.put("SName", SName);
			values.put("HDay", HDay);
			values.put("HClass", HClass);
			values.put("HStart", HStart);
			values.put("HEnd", HEnd);
			db.update("Hours", values, "SName='"+OLDSName+"'" +
					"AND HClass='"+OLDHClass+"'" +
					"AND HDay='"+OLDHDay+"'" +
					"AND HStart='"+OLDHStart+"'" +
					"AND HEnd='"+OLDHEnd+"'", null);
		} finally {
			if(db!= null)
				db.close();
		}
		
	}
	
	public ArrayList<HashMap<String, Object>> selectSubjects() {
		SQLiteDatabase db = dbh.getReadableDatabase();
		try {
			ArrayList<HashMap<String, Object>> results =
				new ArrayList<HashMap<String, Object>>();
			Cursor c = db.rawQuery("select * from Subjects",null);
			if (c.getCount() > 0) {
				c.moveToFirst();
				do {
					HashMap<String,Object> resultsMap =
						new HashMap<String, Object>();
					resultsMap.put("SName" , c.getString(c.getColumnIndex("SName")));
					resultsMap.put("STeacher" , c.getString(c.getColumnIndex("STeacher")));
					resultsMap.put("SColor" , c.getString(c.getColumnIndex("SColor")));
					results.add(resultsMap);
				} while(c.moveToNext());
			}
			c.close();
			return results;
		} finally {
			if(db!= null)
				db.close();
		}
	}
	
	public void insertIntoHours(String SName, int HDay, String HClass, String HStart, String HEnd) {
		SQLiteDatabase db = dbh.getWritableDatabase();
		try {
			ContentValues values = new ContentValues();
			values.put("SName", SName);
			values.put("HDay", HDay);
			values.put("HClass", HClass);
			values.put("HStart", HStart);
			values.put("HEnd", HEnd);
			db.insert("Hours", "", values);
		} finally {
			if(db!= null)
				db.close();
		}
	}
	
	public void deleteHour(String SName, int HDay, String HClass, String HStart, String HEnd) {
		SQLiteDatabase db = dbh.getWritableDatabase();
		try {
			db.delete("Hours",
					"SName = '"+SName+"' " +
					"AND HDay = '"+HDay+"' " +
					"AND HClass = '"+HClass+"' " +
					"AND HStart = '"+HStart+"' " +
					"AND HEnd = '"+HEnd+"' ", null);
		} finally {
			if(db!= null)
				db.close();
		}
	}
	
	public void deleteAllHours() {
		SQLiteDatabase db = dbh.getWritableDatabase();
		try {
			db.delete("Hours", null, null);
		} finally {
			if(db!= null)
				db.close();
		}
	}
	
	public ArrayList<HashMap<String, Object>> selectAllFromDay(int HDay) {
		SQLiteDatabase db = dbh.getReadableDatabase();
		try {
			ArrayList<HashMap<String, Object>> results =
				new ArrayList<HashMap<String, Object>>();
			Cursor c = db.rawQuery("select * from Subjects, Hours where Subjects.SName=Hours.SName and HDay="+HDay+" order by HStart",null);			
			if (c.getCount() > 0) {
			c.moveToFirst();
				do {
					HashMap<String,Object> resultsMap =
						new HashMap<String, Object>();
					resultsMap.put("SName" , c.getString(c.getColumnIndex("SName")));
					resultsMap.put("STeacher" , c.getString(c.getColumnIndex("STeacher")));
					resultsMap.put("HClass" , c.getString(c.getColumnIndex("HClass")));
					resultsMap.put("HStart" , c.getString(c.getColumnIndex("HStart")));
					resultsMap.put("HEnd" , c.getString(c.getColumnIndex("HEnd")));
					resultsMap.put("SColor" , c.getString(c.getColumnIndex("SColor")));
					results.add(resultsMap);
				} while(c.moveToNext());
			}
			c.close();
			return results;
		} finally {
			if(db!= null)
				db.close();
		}
	}
}