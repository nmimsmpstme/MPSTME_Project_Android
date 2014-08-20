package org.mazzarellialessio.studenttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

	private static final String DBName = "studenttimetable.db";
	private static final int DBVersion = 1;
	
	public MyDBHelper(Context context) {
		super(context, DBName, null, DBVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String query = "CREATE TABLE Subjects"
			+ "(SName TEXT PRIMARY KEY,"
			+ "STeacher TEXT,"
			+ "SColor TEXT"
			+ ");";
		db.execSQL(query);
		query = "CREATE TABLE Hours"
			+ "(_id INTEGER AUTO_INCREMENT PRIMARY KEY,"
			+ "SName TEXT,"
			+ "HDay INTEGER,"
			+ "HClass INTEGER,"
			+ "HStart TEXT,"
			+ "HEnd TEXT"
			+ ");";
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS Hours");
		db.execSQL("DROP TABLE IF EXISTS Subjects");
		onCreate(db);
	}
}