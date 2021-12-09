package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView recipe, QR;
    ViewPager2 viewPager ;


    protected ArrayList setTextList(){

        ArrayList<String> itemList = new ArrayList();
        itemList.add("Page 1");
        itemList.add("Page 2");
        itemList.add("Page 3");
        itemList.add("Page 4");
        itemList.add("Page 5");

        return itemList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰페이저
        viewPager = findViewById(R.id.viewPager);
        TextViewPagerAdapter pagerAdapter = new TextViewPagerAdapter(setTextList()) ;
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        recipe = findViewById(R.id.recipe);
        QR = findViewById(R.id.QRcode);


        Intent intent = getIntent();
        intent.getStringExtra("load_URL");


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