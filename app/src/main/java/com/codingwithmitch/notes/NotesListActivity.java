package com.codingwithmitch.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.codingwithmitch.notes.adapters.NotesRecyclerAdapter;
import com.codingwithmitch.notes.models.Note;
import com.codingwithmitch.notes.utils.VerticalSpacingItemDecorator;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity implements
        NotesRecyclerAdapter.OnNoteListener,
        View.OnClickListener {

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

        (findViewById(R.id.fab)).setOnClickListener(this);

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

        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra("selected_note", mNotes.get(position));
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab: {
                Intent intent = new Intent(this, NoteActivity.class);
                startActivity(intent);
            }
        }
    }
}