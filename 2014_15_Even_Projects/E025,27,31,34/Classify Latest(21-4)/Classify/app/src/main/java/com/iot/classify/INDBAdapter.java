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
public class INDBAdapter {
    public static final String KEY_ID = "id";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_POSTED = "datentime";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "InstututeDB";
    private static final String DATABASE_TABLE = "InstituteNotif";
    private static final int DATABASE_VERSION = 2;

    private final Context ourcontext;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public INDBAdapter(Context ctx) {
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
            db.execSQL("CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_MESSAGE +" VARCHAR NOT NULL, "+KEY_POSTED+" VARCHAR NOT NULL)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ",which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public INDBAdapter open() throws SQLException
    {
        db=DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        DBHelper.close();
    }

    public long insertRecord(String message,String datentime)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_MESSAGE,message);
        initialValues.put(KEY_POSTED,datentime);
        return db.insert(DATABASE_TABLE,null,initialValues);
    }

    public String getData()
    {
        String columns[]= new String[]{KEY_ID,KEY_MESSAGE,KEY_POSTED};
        Cursor c = db.query(DATABASE_TABLE,columns,null,null,null,null,null);
        String result = "";

        int iRow = c.getColumnIndex(KEY_ID);
        int iMessage = c.getColumnIndex(KEY_MESSAGE);
        int iDate = c.getColumnIndex(KEY_POSTED);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result="Message : "+c.getString(iMessage)+"\nPosted On : "+c.getString(iDate)+"\n\n"+result;
        }
        return result;
    }

    public boolean deleteRecord(long rowId)
    {
        return db.delete(DATABASE_TABLE,KEY_ID + "="+rowId,null)>0;
    }
}
