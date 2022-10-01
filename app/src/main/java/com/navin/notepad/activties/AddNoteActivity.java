package com.navin.notepad.activties;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.navin.notepad.R;
import com.navin.notepad.database.NoteDbAdapter;
import com.navin.notepad.model.Note;

import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {


    NoteDbAdapter noteDbAdapter;
    AppCompatImageView img_back;
    AppCompatEditText edt_title;
    AppCompatEditText edt_description;
    AppCompatButton btn_date;
    AppCompatButton btn_time;
    AppCompatButton btn_save;

    Calendar calendar;


    String date="";
    String time="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        img_back = findViewById(R.id.img_back);
        edt_title = findViewById(R.id.edt_title);
        edt_description = findViewById(R.id.edt_description);
        btn_date = findViewById(R.id.btn_date);
        btn_time = findViewById(R.id.btn_time);
        btn_save = findViewById(R.id.btn_save);
        noteDbAdapter = new NoteDbAdapter(getApplicationContext());
        calendar= Calendar.getInstance();//singleton

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Note note = new Note();
                note.setTitle(edt_title.getText().toString());
                note.setDescription(edt_description.getText().toString());
                note.setTime(time);
                note.setDate(date);
               long result =  noteDbAdapter.insertNote(note);

               if(result>0) {

                   Snackbar snackbar;
                   snackbar = Snackbar.make(view, getResources().getString(R.string.add_note_success), Snackbar.LENGTH_SHORT);
                   View snackBarView = snackbar.getView();
                   snackBarView.setBackgroundColor(getResources().getColor(R.color.green_500));
                   TextView textView =   snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
                   textView.setTextColor(getResources().getColor(R.color.white));
                   snackbar.show();

                 //  Snackbar.make(view,,Snackbar.LENGTH_LONG).show();

                   //Toast.makeText(getApplicationContext(),"Added Note Successfully" , Toast.LENGTH_LONG).show();
               }else {

                   Snackbar snackbar;
                   snackbar = Snackbar.make(view,getResources().getString( R.string.add_note_error), Snackbar.LENGTH_SHORT);
                   View snackBarView = snackbar.getView();
                   snackBarView.setBackgroundColor(getResources().getColor(R.color.red_700));
                   TextView textView =   snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
                   textView.setTextColor(getResources().getColor(R.color.white));
                   snackbar.show();

                  // Snackbar.make(view,"Error In Adding New Note",Snackbar.LENGTH_LONG).show();
                  // Toast.makeText(getApplicationContext(),"Error In Adding New Note" , Toast.LENGTH_LONG).show();
               }


            }
        });

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(AddNoteActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        date = i+"/"+i1+"/"+i2;

                        btn_date.setText(date);


                    }
                },year,month,day);
                dialog.show();


            }
        });

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //time

                TimePickerDialog dialog = new TimePickerDialog(AddNoteActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        time  =  i+":"+i1;
                        btn_time.setText(time);
                    }
                },calendar.get(Calendar.HOUR) , calendar.get(Calendar.MINUTE),true);

                dialog.show();

            }
        });


    }
}