package com.navin.notepad;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.navin.notepad.activties.AddNoteActivity;
import com.navin.notepad.database.NoteDatabase;
import com.navin.notepad.database.NoteDbAdapter;
import com.navin.notepad.ui.DialogManagement;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawer;
    FloatingActionButton fab_add;

    NoteDatabase noteDatabase;
    NoteDbAdapter noteDbAdapter;
    ListView lst_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteDatabase = new NoteDatabase(getApplicationContext());

        noteDbAdapter = new NoteDbAdapter(getApplicationContext());

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation);
        drawer = findViewById(R.id.drawer);
        fab_add = findViewById(R.id.fab_add);
        lst_data = findViewById(R.id.lst_data);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {

                    case R.id.item_setting:

                        Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                        startActivity(intent);
                        break;

                }

                return false;
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, toolbar,
                R.string.open, R.string.close);

        toggle.syncState();

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , AddNoteActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        List<String> stringList =  noteDbAdapter.showAllNotes();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,
                stringList);
        lst_data.setAdapter(arrayAdapter);

    }


    //overflow

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {


            case R.id.item_about:

                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);

                break;

            case R.id.item_contact:

                //Intent intent1 = new Intent(Intent.ACTION_VIEW , Uri.parse("tel:09122222222"));
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:09122222222"));
                startActivity(intent1);

                break;

            case R.id.item_exit:

                //finish();

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Exit");
                alert.setMessage("Are you sure to exit?");
                alert.setIcon(android.R.drawable.ic_delete);

                alert.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alert.setNeutralButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alert.show();

                break;

            case R.id.item_website:

                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://android-learn.ir"));
                startActivity(intent2);
                break;

            case R.id.item_rate:

                AlertDialog.Builder alertRate = new AlertDialog.Builder(MainActivity.this);
                alertRate.setView(R.layout.rate_dialog);
                alertRate.show();

                break;

            case R.id.item_login :

                DialogManagement.showLogin(MainActivity.this);

                break;

        }

        return super.onOptionsItemSelected(item);
    }
}