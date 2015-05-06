package com.example.shreyalgelani.gmal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Shreyal Gelani on 21-04-2015.
 */
public class FM1 {

    public static final String key_from="_from";
    public static final String key_to="_to";
    public static final String key_reason="_reason";
    public static final String key_leave="_leave";

    public static final String key_status="_status";

    private static final String Database_name="gmaldb";
    private static final String Database_table="form";
    private static final int Database_version=1;
    private DbHelper helper;
    private final Context ourcontext;
    private SQLiteDatabase ourdatabase;

    public long createEntry(String fromd, String tod, String reas, String ld, int srd, String Status) {
        ContentValues cv = new ContentValues();

        cv.put(key_from,fromd);
        cv.put(key_to,tod);
        cv.put(key_reason,reas);
        cv.put(key_leave,srd);

        cv.put(key_status,Status);
       return ourdatabase.insert(Database_table,null,cv);

    }

    public String getfrom() {
        String[] columns = new String[]{key_from,key_to,key_reason,key_leave,key_status};
            Cursor c = ourdatabase.query(Database_table,columns,null,null,null,null,null);
        c.moveToFirst();
        String name = c.getString(0);
        return  name;
            }

    public String getfrom1() {
        String[] columns = new String[]{key_from,key_to,key_reason,key_leave,key_status};
        Cursor cQ = ourdatabase.query(Database_table,columns,null,null,null,null,null);
        cQ.moveToFirst();
        String name1 = cQ.getString(1);
        return  name1;
    }

    public String getfrom2() {
        String[] columns = new String[]{key_from,key_to,key_reason,key_leave,key_status};
        Cursor cQ1 = ourdatabase.query(Database_table,columns,null,null,null,null,null);
        cQ1.moveToFirst();
        String name2 = cQ1.getString(2);
        return  name2;
    }

    public String getfrom3() {
        String[] columns = new String[]{key_from,key_to,key_reason,key_leave,key_status};
        Cursor c = ourdatabase.query(Database_table,columns,null,null,null,null,null);
        c.moveToFirst();
        String name3 = c.getString(3);
        return  name3;
    }

    public String getfrom4() {
        String[] columns = new String[]{key_from,key_to,key_reason,key_leave,key_status};
        Cursor c = ourdatabase.query(Database_table,columns,null,null,null,null,null);
        c.moveToFirst();
        String name4 = c.getString(4);
        return  name4;
    }


    private static class DbHelper extends SQLiteOpenHelper
    {
        public DbHelper(Context context)
        {
            super(context,Database_name,null,Database_version);


        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL("CREATE TABLE " + Database_table + " (" + key_from + " TEXT NOT NULL, " + key_to + " TEXT NOT NULL, " + key_reason + " TEXT NOT NULL, " + key_leave + " INTEGER NOT NULL, " + key_status + " TEXT NOT NULL);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Database_table);
            onCreate(db);

        }
    }

    public FM1(Context c)
    {
        ourcontext=c;

    }
    public FM1 open() throws SQLException
    {
        helper = new DbHelper(ourcontext);
        ourdatabase = helper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        helper.close();
    }


}
