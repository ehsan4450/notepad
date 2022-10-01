package com.navin.notepad.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NoteDatabase extends SQLiteOpenHelper {

    public NoteDatabase(@Nullable Context context) {
        super(context, "Note.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "Create table tbl_note(id Integer PRIMARY KEY AUTOINCREMENT, title varchar(100)," +
                "description Text , dateNote varchar(50) , timeNote varchar(50) )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
