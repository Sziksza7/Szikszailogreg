package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActvity extends AppCompatActivity {

    private EditText felhasznalonev;
    private EditText jelszo;
    private EditText email;
    private EditText teljesnev;
    private Button regisztracio;
    private Button vissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_actvity);
        init();
        vissza.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent visszalep = new Intent(RegisterActvity.this,
                        MainActivity.class);
                startActivity(visszalep);
                finish();
            }
        });
        regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty((CharSequence) felhasznalonev) || TextUtils.isEmpty((CharSequence) jelszo) || TextUtils.isEmpty((CharSequence) email) || TextUtils.isEmpty((CharSequence) teljesnev))
                {
                    Toast.makeText(RegisterActvity.this, "Nem hagyhat uresen mezot", Toast.LENGTH_SHORT).show();
                }

                DBHelper h = new DBHelper(null, null, null, 1);
                h.adatRogzites(email.getText().toString(), felhasznalonev.getText().toString(), jelszo.getText().toString(), teljesnev.getText().toString());
            }
        });
        }


    private void init() {
        felhasznalonev = findViewById(R.id.felhasznalonev);
        jelszo = findViewById(R.id.jelszo);
        email = findViewById(R.id.email);
        teljesnev = findViewById(R.id.teljesnev);

        regisztracio = findViewById(R.id.regisztracio);
        vissza = findViewById(R.id.vissza);
    }




}