package com.example.android_hw4;

import android.database.Cursor;

public class Note {
    public int id;
    public String title;
    public String content;

    public Note(){}
    public Note(int i, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static String TABLE_NAME = "Notes";
    public static String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT, content TEXT)";

    public Note(Cursor c) {
        id = c.getInt(0);
        title = c.getString(1);
        content = c.getString(2);
    }

    public String getSQLInsertString(){
        return "INSERT INTO " + TABLE_NAME +
                " (title, content) VALUES('" + title + "','" + content + "')";
    }

    public static String SELECT_ALL =
            "SELECT * FROM " + TABLE_NAME;

    public String toString(){
        return id + ", " + title + ", " + content;
    }
}
