package com.navin.notepad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.navin.notepad.R;
import com.navin.notepad.model.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteVH>{

    List<Note> noteList;
    LayoutInflater inflater;
    public NoteAdapter(Context context, List<Note> noteList) {
    this.noteList = noteList;
    inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.note_row,null);

        return new NoteVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVH holder, int position) {


        Note note = noteList.get(position);

        holder.txt_title.setText(note.getTitle());
        holder.txt_description.setText(note.getDescription());



    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class NoteVH extends  RecyclerView.ViewHolder {

        AppCompatTextView txt_description;
        AppCompatTextView txt_title;

        public NoteVH(@NonNull View itemView) {
            super(itemView);
            txt_description = itemView.findViewById(R.id.txt_description);
            txt_title = itemView.findViewById(R.id.txt_title);
        }
    }

}
