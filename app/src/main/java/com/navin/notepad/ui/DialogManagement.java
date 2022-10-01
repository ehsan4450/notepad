package com.navin.notepad.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;

import com.navin.notepad.R;

public class DialogManagement {


    public static void showLogin(Activity activity) {

        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.login_layout,null);
        alert.setView(view);

        AppCompatButton btn_cancel = view.findViewById(R.id.btn_cancel);
        AppCompatButton btn_login = view.findViewById(R.id.btn_login);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity , "Fine" , Toast.LENGTH_LONG).show();
            }
        });

        alert.show();

    }
}
