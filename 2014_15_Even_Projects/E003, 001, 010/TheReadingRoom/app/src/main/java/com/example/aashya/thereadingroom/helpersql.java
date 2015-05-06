package com.example.aashya.thereadingroom; /**
 * Created by aashya on 27/02/15.
 */
    import android.content.Context;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.util.Log;

    public class helpersql extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "data.db";
        private static final String TABLE_WISH = "wish1";

        // Columns in table "wish"
        private static final String WISH_ID = "wish_id";
        private static final String WISH = "wish";

        // Create table "tasks"
        private static final String CREATE_TABLE_WISH = "CREATE TABLE " + TABLE_WISH + " ("
                + WISH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + WISH + " TEXT);";


        public helpersql(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_WISH);
        }



        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        }
    }


