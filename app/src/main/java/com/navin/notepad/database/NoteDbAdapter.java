package com.navin.notepad.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.navin.notepad.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDbAdapter extends NoteDatabase {

    public NoteDbAdapter(@Nullable Context context) {
        super(context);
    }

    public long insertNote(Note note) {


        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", note.getTitle());
        contentValues.put("description", note.getDescription());
        contentValues.put("dateNote", note.getDate());
        contentValues.put("timeNote", note.getTime());

        return db.insert("tbl_note", null, contentValues);


    }


    public List<String> showAllNotes() {

        List<String> stringList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from tbl_note ", null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String desc = cursor.getString(2);
            String date = cursor.getString(3);
            String time = cursor.getString(4);
            stringList.add(title);
        }


        return stringList;

    }



    public List<Note> showAll() {

        List<Note> noteList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from tbl_note ", null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String desc = cursor.getString(2);
            String date = cursor.getString(3);
            String time = cursor.getString(4);
            Note note = new Note();
            note.setDate(date);
            note.setTime(time);
            note.setTitle(title);
            note.setId(id);
            note.setDescription(desc);
            noteList.add(note);
        }


        return noteList;

    }


}
