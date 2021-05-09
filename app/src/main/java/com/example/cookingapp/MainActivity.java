package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Search, QR, Login;
    public boolean login = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();

        //로그인 한 회원원
       /*
        if (intent.getBooleanExtra("login_data")) {
            login = true;
        } else {
            login = false;
        }
        */

        Search = findViewById(R.id.search);
        QR = findViewById(R.id.QRcode);
        Login = findViewById(R.id.Login);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        QR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent nextIntent;
                nextIntent = new Intent(MainActivity.this, QRActivity.class);
                startActivity(nextIntent);
                 */

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent nextIntent;
                nextIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(nextIntent);
            }
        });
    }
/*

 */
}

