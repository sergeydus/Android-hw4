package com.example.android_hw4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;

    public DBHelper(Context context) {
        super(context, "db2", null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Note.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //change db according to version
    }

    public boolean updateData(String id,String title,String content,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("title",title);
        contentValues.put("content",content);
        db.update("Notes", contentValues, "id = ?",new String[] { id });
        return true;
    }

}
