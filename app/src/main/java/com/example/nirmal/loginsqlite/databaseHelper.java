package com.example.nirmal.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "users";
    private static final String TBL_NAME = "user";

    private static final String column1 = "uname";
    private static final String column2 = "roll";
    private static final String column3 = "password";

    public databaseHelper(Context context){
        super(context,DB_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String string = "CREATE TABLE IF NOT EXISTS "+TBL_NAME + "(" + column1 + " TEXT," + column2
                + " TEXT," + column3 + " TEXT" + ")";
        db.execSQL(string);
    }

    public void addUser(Users users){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column1,users.getUsername());
        contentValues.put(column2,users.getPassword());
        db.insert(TBL_NAME,null,contentValues);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TBL_NAME); //Drop older table if exists
        onCreate(db);
    }
}
