package com.example.android_hw4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class EditNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        int id=getIntent().getIntExtra("id",10);
        Bundle bundle=getIntent().getExtras();
        String title=bundle.getString("title");
        String content=bundle.getString("content");
        Log.d("test","id is "+id+" title is +"+title+" content is "+content);
    }
}
