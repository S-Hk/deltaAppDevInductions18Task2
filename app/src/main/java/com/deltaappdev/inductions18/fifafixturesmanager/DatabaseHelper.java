package com.deltaappdev.inductions18.fifafixturesmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "matchFixtures.db";
    public static final String TABLE_NAME = "fixtures_table";

    public static final String COL_ID = "ID";
    public static final String COL_TEAMA = "TEAMA";
    public static final String COL_TEAMB = "TEAMB";
    public static final String COL_VENUE = "VENUE";
    public static final String COL_DATE = "DATE";
    public static final String COL_TIME = "TIME";
    public static final String COL_TAI = "T_A_Img";
    public static final String COL_TBI = "T_B_Img";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase(); //for checking
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS  "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TEAMA TEXT, TEAMB TEXT, VENUE TEXT, DATE TEXT, TIME TEXT, T_A_I BLOG, T_B_I BLOG)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
        */
    }


    public void queryData(String sql){
        SQLiteDatabase database = this.getReadableDatabase();
        database.execSQL(sql);
    }



    public void insertData(String tAN, String tBN, String venue, String mdate, String mtime, byte[] imageA, byte[] imageB) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "INSERT INTO "+ TABLE_NAME + " VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();


        statement.bindString(1,tAN);
        statement.bindString(2,tBN);
        statement.bindString(3,venue);
        statement.bindString(4,mdate);
        statement.bindString(5,mtime);

        statement.bindBlob(6,imageA);
        statement.bindBlob(7,imageB);

        statement.executeInsert();


        /*
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TEAMA, tAN);
        contentValues.put(COL_TEAMB, tBN);
        contentValues.put(COL_TEAMA, tAN);

        */
    }

    public void insertDatamatchFixture(matchFixtures m) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "INSERT INTO "+ TABLE_NAME + " VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();


        statement.bindString(1,m.getTeamName(true));
        statement.bindString(2,m.getTeamName(false));
        statement.bindString(3,m.getMatchVenue());
        statement.bindString(4,m.getMatchDate());
        statement.bindString(5,m.getMatchTime());

        statement.bindBlob(6,m.getTeamImage(true));
        statement.bindBlob(7,m.getTeamImage(false));

        statement.executeInsert();


        /*
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TEAMA, tAN);
        contentValues.put(COL_TEAMB, tBN);
        contentValues.put(COL_TEAMA, tAN);

        */
    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery(sql, null);
    }
}
