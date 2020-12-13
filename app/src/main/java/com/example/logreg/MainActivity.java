package com.example.logreg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText felhasznalonev;
    private EditText jelszo;
    private Button bejelentkezes;
    private Button regisztracio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        regisztracio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this,
                        RegisterActvity.class);
                startActivity(register);
                finish();
            }
        });
        bejelentkezes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty((CharSequence) felhasznalonev) || TextUtils.isEmpty((CharSequence) jelszo))
                {
                    Toast.makeText(MainActivity.this, "Nem hagyhat uresen mezot", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent beleptet = new Intent(MainActivity.this,
                            LoggedInActivity.class);
                    startActivity(beleptet);
                    finish();
                }
            }

        })
    ;}

    private void init() {
        felhasznalonev = findViewById(R.id.felhasznalonev);
        jelszo = findViewById(R.id.jelszo);
        bejelentkezes = findViewById(R.id.bejelentkezes);
        regisztracio = findViewById(R.id.regisztracio);
    }
}


