package com.navin.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Log.e("LifeCycle About","onCreate");

        AppCompatButton btn_cv = findViewById(R.id.btn_cv);

        btn_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext() , ResumeActivity.class);

                startActivity(intent);

            }
        });

        //Lambda expression

        AppCompatButton btn_education = findViewById(R.id.btn_education);

        btn_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                System.out.println("Hello");
                Log.e("About" , "Hello");
                Log.d("About d" , "Hello");
                Log.w("About w" , "Hello");
                Log.i("About i" , "Hello");

                Toast.makeText(getApplicationContext(), "Android Developer" , Toast.LENGTH_LONG).show();

            }
        });




    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle About","onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle About","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle About","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle About","onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle About","onStart");
    }
}