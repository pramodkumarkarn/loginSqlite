package com.example.nirmal.loginsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

public class DBHandler extends AppCompatActivity {
    SQLiteDatabase database;
    public DBHandler(){
        database = openOrCreateDatabase("Student", Context.MODE_PRIVATE,null);
    }

    public void create_table(){
        String query = "CREATE TABLE IF NOT EXISTS users" + "(roll_no varchar(6) primary key, name varchar(20), " +
                "password varchar(20))";
        database.execSQL(query);
    }

    public void putData(String name, String roll, String pass){
        String string = "INSERT INTO users VALUES('" + roll + "','" + name + "','" + pass + "')";
        database.execSQL(string);
    }
}
