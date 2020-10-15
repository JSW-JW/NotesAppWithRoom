package com.codingwithmitch.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "SomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


    }
}