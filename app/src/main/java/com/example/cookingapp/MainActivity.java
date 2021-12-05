package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView recipe, QR;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipe = findViewById(R.id.recipe);
        QR = findViewById(R.id.QRcode);
        Login = findViewById(R.id.Login);

        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qrIntent;
                qrIntent = new Intent(MainActivity.this, recipeActivity.class);
                startActivity(qrIntent);

            }
        });

        /*로그인 한 회원 체크
        if (intent.getBooleanExtra("login_data", true)) {
            login = true;
            Log.i("로그인 : ", "O");
        } else {
            login = false;
            Log.i("로그인 : ", "X");
        }*/

        QR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent;
                nextIntent = new Intent(MainActivity.this, QRActivity.class);
                startActivity(nextIntent);

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
}