package com.perasia.mylibrary.provider;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LiAdvertiseDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = LiAdvertiseDatabaseHelper.class.getSimpleName();

    public LiAdvertiseDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
