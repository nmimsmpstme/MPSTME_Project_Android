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
public class ENDBAdapter {
    public static final String KEY_ID = "id";
    public static final String KEY_COMMITTEE = "committee";
    public static final String KEY_EVENTNAME = "name";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_DATE = "edatentime";
    public static final String KEY_POSTED ="datentime";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "EventDB";
    private static final String DATABASE_TABLE = "EventNotif";
    private static final int DATABASE_VERSION = 1;

    private final Context ourcontext;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ENDBAdapter(Context ctx) {
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

            db.execSQL("CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_COMMITTEE +" VARCHAR NOT NULL, " + KEY_EVENTNAME + " VARCHAR NOT NULL, "+KEY_DESCRIPTION+" VARCHAR NOT NULL, "+KEY_DATE+" VARCHAR NOT NULL, "+KEY_POSTED+" VARCHAR NOT NULL)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ",which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public ENDBAdapter open() throws SQLException
    {
        db=DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        DBHelper.close();
    }

    public long insertRecord(String committee,String event,String description,String edatentime,String datentime)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_COMMITTEE,committee);
        initialValues.put(KEY_EVENTNAME,event);
        initialValues.put(KEY_DESCRIPTION,description);
        initialValues.put(KEY_DATE,edatentime);
        initialValues.put(KEY_POSTED,datentime);
        return db.insert(DATABASE_TABLE,null,initialValues);
    }

    public String getData()
    {
        String columns[]= new String[]{KEY_ID,KEY_COMMITTEE,KEY_EVENTNAME,KEY_DESCRIPTION,KEY_DATE,KEY_POSTED};
        Cursor c = db.query(DATABASE_TABLE,columns,null,null,null,null,null);
        String result = "";
        int iRow = c.getColumnIndex(KEY_ID);
        int iCommittee = c.getColumnIndex(KEY_COMMITTEE);
        int iName = c.getColumnIndex(KEY_EVENTNAME);
        int iDescription = c.getColumnIndex(KEY_DESCRIPTION);
        int iDate = c.getColumnIndex(KEY_DATE);
        int iPost = c.getColumnIndex(KEY_POSTED);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result="Committee : "+c.getString(iCommittee)+"\nEvent : "+c.getString(iName)+"\nDescription : "+c.getString(iDescription)+"\nDate & Time : "+c.getString(iDate)+"\nPosted on : "+c.getString(iPost)+"\n\n"+result;
        }
        return result;
    }

    public boolean deleteRecord(long rowId)
    {
        return db.delete(DATABASE_TABLE,KEY_ID + "="+rowId,null)>0;
    }
}
