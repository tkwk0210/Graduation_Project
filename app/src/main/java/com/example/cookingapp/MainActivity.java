package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ImageView recipe, QR;
    ViewPager viewPager ;
    CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰페이저
        viewPager = findViewById(R.id.viewPager);
        TextViewPagerAdapter pagerAdapter = new TextViewPagerAdapter(this) ;
        viewPager.setAdapter(pagerAdapter);

        circleImageView = findViewById(R.id.main_circle_image);
        recipe = findViewById(R.id.recipe);
        QR = findViewById(R.id.QRcode);


        Intent intent = getIntent();
        intent.getStringExtra("load_URL");

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // 팝업 띄우기 ㄱ
                Intent popup_intent = new Intent(MainActivity.this, popup.class);
                startActivity(popup_intent);
            }
        });

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