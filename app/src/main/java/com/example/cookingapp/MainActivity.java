package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    Button QR, Login;
    public boolean login = false;
    SearchView Search;
    ImageView test_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();

        //로그인 한 회원 체크
        if (intent.getBooleanExtra("login_data", true)) {
            login = true;
            Log.i("로그인 : ", "O");
        } else {
            login = false;
            Log.i("로그인 : ", "X");
        }

        Search = findViewById(R.id.Search_recipe);
        QR = findViewById(R.id.QRcode);
        Login = findViewById(R.id.Login);
        test_imageView = findViewById(R.id.test_recipe);

        test_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent;
                nextIntent = new Intent(MainActivity.this, recipeActivity.class);
                startActivity(nextIntent);
            }
        });

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