package com.example.ayush.boom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ayush on 5/11/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
   /* public  static final String DATABASE_NAME="ayu";
    public  static final String Table_NAME="stu";
    public  static final String COL_1="fname";
    public  static final String COL_2="lname";
    public  static final String COL_3="email";
    public  static final String COL_4="passwrd";
    public  static final String COL_5="bdate"; */

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseAdapter.DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");

        onCreate(db);


    }
   /* public boolean insertdate(String fname, String lname, String email, String passwrd, String bdate)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COL_1, fname);
        contentValues.put(COL_2, lname);
        contentValues.put( COL_3, email);
        contentValues.put(COL_4, passwrd);
        contentValues.put( COL_5, bdate);
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
    }*/
}

