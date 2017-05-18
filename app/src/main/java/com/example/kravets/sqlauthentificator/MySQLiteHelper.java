package com.example.kravets.sqlauthentificator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;

/**
 * Created by Kravets on 16.05.2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "softGroup.db";
    private static final String TABLE_NAME = "users";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASSWORD + " TEXT" + ")";

    SQLiteDatabase db;


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void addUser(User user) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from users";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());

        db.insert(TABLE_NAME, null, values);
      //  db.execSQL("INSERT INTO users VALUES (NULL, '" + user.getEmail() + "', '" + user.getPassword() + "')");
        db.close(); // Closing database connection
    }


    public String searchPass(String strName) {
       db=this.getReadableDatabase();
        String query = "SELECT email, password FROM" + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b="not found";
        if (cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);

                if(a.equals(strName))
                {
                b=cursor.getString(1);
                break;
                }
            }
            while (cursor.moveToNext());
        }
    return b;
    }
}
