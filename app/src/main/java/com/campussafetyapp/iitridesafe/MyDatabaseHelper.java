package com.campussafetyapp.iitridesafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Reports.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_reports";
    private static final String COLUMN_ID = "_id";

    private static final String COLUMN_LOCATION = "title";
    private static final String COLUMN_MESSAGE = "message";
    private Context context;


    MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LOCATION + " TEXT, " +
                COLUMN_MESSAGE + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void insertData(String title, String message) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_LOCATION, title);
        values.put(COLUMN_MESSAGE, message);

        long result = db.insert(TABLE_NAME, null, values);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Submitted!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}