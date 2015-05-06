package com.iot.classify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by Krishna on 3/21/2015.
 */
public class RDBAdapter {
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_SUBJECT="subject";
    public static final String KEY_PREFERREDTIME="preferredtime";
    public static final String KEY_POSTED = "datentime";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "RequestDB";
    private static final String DATABASE_TABLE = "Request";
    private static final int DATABASE_VERSION = 2;

    private final Context ourcontext;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public RDBAdapter(Context ctx) {
        ourcontext = ctx;
        DBHelper = new DatabaseHelper(ourcontext);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME +" VARCHAR NOT NULL, "+ KEY_PREFERREDTIME +" VARCHAR NOT NULL, "+KEY_SUBJECT+" VARCHAR NOT NULL, "+KEY_POSTED+" VARCHAR NOT NULL)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ",which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public RDBAdapter open() throws SQLException
    {
        db=DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        DBHelper.close();
    }

    public long insertRecord(String name,String subject,String preferredtime,String datentime)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME,name);
        initialValues.put(KEY_SUBJECT,subject);
        initialValues.put(KEY_PREFERREDTIME,preferredtime);
        initialValues.put(KEY_POSTED,datentime);
        return db.insert(DATABASE_TABLE,null,initialValues);
    }

    public String getData()
    {
        String columns[]= new String[]{KEY_ID,KEY_NAME,KEY_SUBJECT,KEY_PREFERREDTIME,KEY_POSTED};
        Cursor c = db.query(DATABASE_TABLE,columns,null,null,null,null,null);
        String result = "";

        int iRow = c.getColumnIndex(KEY_ID);
        int iName = c.getColumnIndex(KEY_NAME);
        int iSubject = c.getColumnIndex(KEY_SUBJECT);
        int iPreferredtime = c.getColumnIndex(KEY_PREFERREDTIME);
        int iDate = c.getColumnIndex(KEY_POSTED);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result=result+"Request number : "+c.getString(iRow)+"\nName : "+c.getString(iName)+"\nSubject : "+c.getString(iSubject)+"\nPreferred Time : "+c.getString(iPreferredtime)+"\nPosted On : "+c.getString(iDate)+"\n\n";
        }
        return result;
    }

    public boolean deleteRecord(String rowID)
    {
        return db.delete(DATABASE_TABLE,KEY_ID + "="+rowID,null)>0;
    }
}
