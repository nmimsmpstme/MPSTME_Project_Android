package com.example.myfilofax;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DBHelper extends SQLiteOpenHelper{
     
    public SQLiteDatabase DB;
    public String DBPath;
    public static String DBName = "DB";
    public static final int version = '4';
    public static Context currentContext;
    
    public static String tableName = "Abc";
    public static String tableName4 = "Img";
    public static String tableName7 = "Pattt";
    public static final String KEY_PASS = "password";
    public static final String KEY_NAME = "name";
    public static final String KEY_PH_NO = "phone";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_TASK = "task";
    public static final String KEY_SBJ = "subject";
    public static final String KEY_NOT = "notes";
    public static final String KEY_DATE = "date";
    public static final String KEY_TIME = "time";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_ID = "_id";
    public static final String Imp ="CREATE TABLE IF NOT EXISTS " + tableName7 +
            "("  + KEY_ID + " integer primary key autoincrement, " + KEY_TASK +" VARCHAR," + KEY_SBJ + " VARCHAR,"+ KEY_DATE + " DATETIME,"
            + KEY_TIME + " DATETIME," + KEY_NOT + " VARCHAR);";     
    
    public DBHelper(Context context) {
        super(context, DBName, null, version);
        currentContext = context;
        DBPath = "/data/data/" + context.getPackageName() + "/databases/";
        createDatabase();
 
    }
    public DBHelper(Context context, String name,CursorFactory factory, int version) {
        super(context, name, factory, version);

 // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    	DB.execSQL(Imp);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
       DB.execSQL("drop table" + tableName7);
       onCreate(DB);
    }
 
    private void createDatabase() {
        boolean dbExists = checkDbExists();
         
        if (dbExists) {
            // do nothing
        } else {
            DB = currentContext.openOrCreateDatabase(DBName, 0, null);
            DB.execSQL("CREATE TABLE IF NOT EXISTS " +
                    tableName +
                    "("  + KEY_ID + " integer primary key autoincrement, " + KEY_NAME +" VARCHAR," + KEY_PASS + " VARCHAR,"
                + KEY_EMAIL + " VARCHAR," +KEY_PH_NO+ "INTEGER)");
            DB.execSQL("CREATE TABLE IF NOT EXISTS " +
                    tableName7 +
                    "("  + KEY_ID + " integer primary key autoincrement, " + KEY_TASK +" VARCHAR," + KEY_SBJ + " VARCHAR,"+ KEY_DATE + " DATETIME,"
                    + KEY_TIME + " DATETIME," + KEY_NOT + " VARCHAR)");               
            DB.execSQL("CREATE TABLE IF NOT EXISTS " +
                    tableName4 +
                    "("  + KEY_ID + " integer primary key autoincrement, " + KEY_IMAGE +" blob)");               
        
        }
         
         
    }
 
    private boolean checkDbExists() {
        SQLiteDatabase checkDB = null;
 
        try {
            String myPath = DBPath + DBName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY);
 
        } catch (SQLiteException e) {
 
            // database does't exist yet.
 
        }
 
        if (checkDB != null) {
 
            checkDB.close();
 
        }
 
        return checkDB != null ? true : false;
    }
    
    public Cursor GetAllRows()
    {
    	Cursor c = DB.rawQuery("SELECT * FROM Pattt", null);
    	return c ;
    }
}