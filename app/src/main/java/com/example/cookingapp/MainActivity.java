package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView recipe, QR, main_image;
    WebView webView_1 ;
    Object binding;

    //Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipe = findViewById(R.id.recipe);
        QR = findViewById(R.id.QRcode);
        //webView_1 = findViewById(R.id.main_webview_1);
        //Login = findViewById(R.id.Login);
        main_image = findViewById(R.id.main_webview_1);

        Intent intent = getIntent();
        intent.getStringExtra("load_URL");
        // 웹뷰

        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qrIntent;
                qrIntent = new Intent(MainActivity.this, recipeActivity.class);
                startActivity(qrIntent);

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
    }
}