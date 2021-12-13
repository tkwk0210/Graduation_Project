package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ImageView recipe, QR;
    private ViewPager viewPager ;
    CircleImageView circleImageView;

    int currentPage = 0;
    Timer timer;
    final long DELAY = 1000;
    final long PERIOD = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰페이저
        viewPager = findViewById(R.id.viewPager);
        TextViewPagerAdapter pagerAdapter = new TextViewPagerAdapter(this) ;
        viewPager.setAdapter(pagerAdapter);

        Intent getintent = new Intent();
        getintent.getIntExtra("pos", currentPage);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == 5) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY, PERIOD);
        //뷰페이저 끝

        circleImageView = findViewById(R.id.main_circle_image);
        recipe = findViewById(R.id.recipe);
        QR = findViewById(R.id.QRcode);


        Intent intent = getIntent();
        intent.getStringExtra("load_URL");

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //팝업 띄우기 간단한 소개
                Intent popup_intent = new Intent(MainActivity.this, popupActivity.class);
                startActivityForResult(popup_intent, 1);
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