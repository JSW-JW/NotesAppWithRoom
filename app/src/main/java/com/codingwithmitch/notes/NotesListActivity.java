package com.codingwithmitch.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.codingwithmitch.notes.adapters.NotesRecyclerAdapter;
import com.codingwithmitch.notes.models.Note;
import com.codingwithmitch.notes.utils.VerticalSpacingItemDecorator;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity implements NotesRecyclerAdapter.OnNoteListener {

    private static final String TAG = "NotesListActivity";

    // Ui components
    private RecyclerView mRecyclerView;
    private NotesRecyclerAdapter mNotesRecyclerAdapter;

    // vars
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNotesRecyclerAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        mRecyclerView = findViewById(R.id.recycler_view);

        initRecyclerView();
        insertFakeNotes();

        setSupportActionBar((Toolbar)findViewById(R.id.note_toolbar));
        setTitle("Notes");
    }

    private void insertFakeNotes() {
        for(int i=0; i < 1000; i++) {
            Note note = new Note();
            note.setTitle("Title # " + i);
            note.setContent("Content # : " + i);
            note.setTimestamp("Dec 14 2020");
            mNotes.add(note);
        }
        mNotesRecyclerAdpater.notifyDataSetChanged();
    }

    private void initRecyclerView(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mNotesRecyclerAdpater = new NotesRecyclerAdapter(mNotes, this);
        mRecyclerView.setAdapter(mNotesRecyclerAdpater);
    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick: clicked." + position);
    }
}