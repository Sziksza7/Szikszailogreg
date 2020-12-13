package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private TextView userteljesnev;
    private Button kijelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        init();

        kijelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kijel = new Intent(LoggedInActivity.this,
                        MainActivity.class);
                startActivity(kijel);
                finish();
            }
        });

    }

    public void init(){
        userteljesnev = findViewById(R.id.userteljesnev);
        kijelentkezes = findViewById(R.id.kijelentkezes);
    }

}