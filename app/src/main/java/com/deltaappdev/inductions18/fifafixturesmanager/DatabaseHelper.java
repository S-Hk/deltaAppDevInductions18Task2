package com.deltaappdev.inductions18.fifafixturesmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "matchFixtures.db";
    public static final String TABLE_NAME = "fixtures_table";
    public static final String COL_ID = "ID";
    public static final String COL_TEAMA = "TEAMA";
    public static final String COL_TEAMB = "TEAMB";
    public static final String COL_VENUE = "VENUE";
    public static final String COL_5 = "";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase(); //for checking
    }


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TEAMA TEXT, TEAMB TEXT, VENUE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String tAN, String tBN, String venue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TEAMA, tAN);
        contentValues.put(COL_TEAMB, tBN);
        contentValues.put(COL_TEAMA, tAN);

        return false;
    }
}
