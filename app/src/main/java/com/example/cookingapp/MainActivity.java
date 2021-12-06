package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView recipe, QR;
    WebView webView_1 ;
    //Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipe = findViewById(R.id.recipe);
        QR = findViewById(R.id.QRcode);
        webView_1 = findViewById(R.id.main_webview_1);
        //Login = findViewById(R.id.Login);

        Intent intent = getIntent();
        intent.getStringExtra("load_URL");


        // 웹뷰 시작
        webView_1 = (WebView) findViewById(R.id.webView);

        webView_1.setWebViewClient(new WebViewClient());                             // 클릭시 새창 안뜨게

        webView_1.loadUrl("http://google.com"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작

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
/*
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent;
                nextIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(nextIntent);
            }
        });
        */


    }
}