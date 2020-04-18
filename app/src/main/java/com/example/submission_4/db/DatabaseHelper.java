package com.example.submission_4.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbSubmission4";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_MOVIEFAV = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.MovieFavColumns.TABLE_NAME,
            DatabaseContract.MovieFavColumns._ID,
            DatabaseContract.MovieFavColumns.TITLE,
            DatabaseContract.MovieFavColumns.DESCRIPTION,
            DatabaseContract.MovieFavColumns.PHOTO
    );

    private static final String SQL_CREATE_TABLE_TVFAV = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TvFavColumns.TABLE_NAME,
            DatabaseContract.TvFavColumns._ID,
            DatabaseContract.TvFavColumns.TITLE,
            DatabaseContract.TvFavColumns.DESCRIPTION,
            DatabaseContract.TvFavColumns.PHOTO
    );

    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_MOVIEFAV);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_TVFAV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.MovieFavColumns.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TvFavColumns.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


}
