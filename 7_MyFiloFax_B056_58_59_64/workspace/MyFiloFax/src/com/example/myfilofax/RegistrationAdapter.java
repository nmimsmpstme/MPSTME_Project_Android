package com.example.myfilofax;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class RegistrationAdapter {

	SQLiteDatabase db;
    DBHelper d;
    Context context;
 
    public RegistrationAdapter(Context c) {
        context = c;
    }
 
    public RegistrationAdapter opnToRead() {
        d = new DBHelper(context, d.DBName, null, d.version);
        db = d.getReadableDatabase();
        return this;
 
    }
 
    public RegistrationAdapter opnToWrite() {
        d = new DBHelper(context,d.DBName, null, d.version);
        db = d.getWritableDatabase();
        return this;
 
    }
 
    public void Close() {
        db.close();
    }
 
    public long insertDetails(String task, String subject, String date , String time, String notes) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(d.KEY_TASK, task);
        contentValues.put(d.KEY_SBJ, subject);
        contentValues.put(d.KEY_DATE, date);
        contentValues.put(d.KEY_TIME, time);
        contentValues.put(d.KEY_NOT, notes);
        opnToWrite();
        long val = db.insert(d.tableName7, null,contentValues);
        Close();
        return val;

    }
 
    public Cursor queryName() {
       /// String[] cols = {d.KEY_ID,d.KEY_TASK,d.KEY_SBJ,d.KEY_DATE,d.KEY_TIME,d.KEY_NOT };
        opnToWrite();
        Cursor c = db.query(d.tableName7,null,null,null, null, null, null);
        return c;
        
    }
 
    public Cursor queryAll(int nameId) {
    	 String[] cols = { d.KEY_ID,d.KEY_TASK, d.KEY_SBJ,d.KEY_DATE,d.KEY_TIME,d.KEY_NOT };
    	 opnToWrite();
    	 Cursor c = db.query(d.tableName7, cols, d.KEY_ID + "=" + nameId, null, null, null, null);
    	 return c;
 
    }
 
    public long updateldetail(int rowId, String task, String subject, String date , String time, String notes) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(d.KEY_TASK, task);
        contentValues.put(d.KEY_SBJ, subject);
        contentValues.put(d.KEY_DATE, date);
        contentValues.put(d.KEY_TIME, time);
        contentValues.put(d.KEY_NOT, notes);
        opnToWrite();
        long val = db.update(d.tableName7, contentValues,d.KEY_ID + "=" + rowId, null);
        Close();
        return val;
    }
 
    public int deletOneRecord(int rowId) {
        // TODO Auto-generated method stub
        opnToWrite();
        int val = db.delete(d.tableName7,d.KEY_ID + "=" + rowId, null);
        Close();
        return val;
    }
 
}
