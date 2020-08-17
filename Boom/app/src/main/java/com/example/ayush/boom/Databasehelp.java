package com.example.ayush.boom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ayush on 5/11/2016.
 */
public class Databasehelp extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME="stud";
    public  static final String Table_NAME="tbl";
    public  static final String COL_1="name";
    public  static final String COL_2="age";
    public  static final String COL_3="number";
    public  static final String COL_4="gender";
    public  static final String COL_5="location";
    public  static final String COL_6="address";

    public Databasehelp(Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_NAME + "(name TEXT, age VARCHAR, number VARCHAR, gender TEXT, location TEXT, address VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + Table_NAME);
        onCreate(db);


    }
    public boolean insertdate(String name, String age, String number, String gender, String location, String address)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COL_1, name);
        contentValues.put(COL_2, age);
        contentValues.put( COL_3, number);
        contentValues.put(COL_4, gender);
        contentValues.put( COL_5, location);
        contentValues.put(COL_6, address);
        long result=   db.insert(Table_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getalldata(){

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + Table_NAME,null);
        return  res;
    }
}