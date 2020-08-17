package com.example.ayush.boom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ayush on 8/13/2016.
 */
public class DatabaseAdapter {
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table " + "LOGIN" + "( "
            + "ID" + " integer primary key autoincrement,"
            + "FNAME  text, LNAME text,EMAIL varchar,PASSWORD text, BDATE varchar); ";
    public SQLiteDatabase db;
    private final Context context;
    private DatabaseHelper dbHelper;

    public DatabaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    public DatabaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String firstName,String lastName,String email, String password, String bdate) {
        ContentValues newValues = new ContentValues();
        newValues.put("FNAME", firstName);
        newValues.put("LNAME", lastName);
        newValues.put("EMAIL", email);
        newValues.put("PASSWORD", password);
        newValues.put("BDATE", bdate);
        db.insert("LOGIN", null, newValues);

    }

    public int deleteEntry(String email) {

        String where = "EMAIL=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where,
                new String[] { email });
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String email) {
        Cursor cursor = db.query("LOGIN", null, " EMAIL=?",
                new String[] { email }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String email, String password) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("EMAIL", email);
        updatedValues.put("PASSWORD", password);

        String where = "EMAIL = ?";
        db.update("LOGIN", updatedValues, where, new String[] { email });
    }
}
