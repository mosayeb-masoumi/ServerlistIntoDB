package com.example.test5.second;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

    private final static String DB_NAME = "database";
    private final static int DB_VERSION = 1;

    public static final String tableEmployees = "employees";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";


    public MyDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {

        mydb.execSQL("CREATE TABLE IF NOT EXISTS "+ tableEmployees + " (" +
                ID + " INTEGER PRIMARY KEY, " +
                NAME + " TEXT, " +
                EMAIL + " TEXT, " +
                PHONE + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb,
                          int oldVersion, int newVersion) {

    }
}
