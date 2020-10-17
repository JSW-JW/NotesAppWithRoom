package com.codingwithmitch.notes.async;

import android.os.AsyncTask;
import android.util.Log;

import com.codingwithmitch.notes.models.Note;
import com.codingwithmitch.notes.persistence.NoteDao;

public class UpdateAsyncTask extends AsyncTask<Note, Void, Void> {

    private static final String TAG = "InsertAsyncTask";

    private NoteDao mNoteDao;
    public UpdateAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        Log.d(TAG, "doInBackground: thread : " + Thread.currentThread().getName()); // result : BackgroundThread
        mNoteDao.updateNotes(notes);
        return null;
    }


}
