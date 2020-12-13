package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "loginregist";
    private static final String TABLE_NAME = "felhasznalo";
    public static final String COL_1 = "id";
    public static final String COL_2 = "email";
    public static final String COL_3 = "felhnev";
    public static final String COL_4 = "jelszo";
    public static final String COL_5 = "teljesnev";


    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_NAME + "(" + COL_1
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT,"  + COL_3 + " TEXT,"  + COL_4 + " TEXT,"  + COL_5 + " TEXT"  +");";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean adatRogzites(String email, String felhnev, String jelszo, String teljesnev){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, felhnev);
        contentValues.put(COL_4, jelszo);
        contentValues.put(COL_5, teljesnev);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

}
