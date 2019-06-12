package com.example.android_hw4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Button EditButton= (Button) findViewById(R.id.EditNoteButton);
        Button DonationsButton= (Button) findViewById(R.id.DonationsButton);
        ListView mListView = (ListView) findViewById(R.id.simpleListView);
    }
}
