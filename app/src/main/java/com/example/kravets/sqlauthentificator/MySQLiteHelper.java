package com.example.kravets.sqlauthentificator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kravets on 16.05.2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SoftGroup";
    private static final String TABLE_FOR_USERS = "Users";

    private static final String ID = "_id";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";



    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_FOR_USERS + "("
                + ID + " INTEGER PRIMARY KEY," + EMAIL + " TEXT,"
                + PASSWORD + " TEXT" + ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EMAIL, user.getEmail());
        values.put(PASSWORD, user.getPassword());

        db.insert(TABLE_FOR_USERS, null, values);
        db.execSQL("INSERT INTO Students VALUES (NULL, '" + user.getEmail() + "', '" + user.getPassword() + "')");
        db.close(); // Closing database connection
    }





}
