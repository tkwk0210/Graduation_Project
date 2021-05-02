package com.example.cookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class recipeActivity extends AppCompatActivity {
    Button btn_next;
    TextView recipe_content;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        btn_next = findViewById(R.id.btn_next);
        recipe_content = findViewById(R.id.recipe_content);

        //한 엑티비티에서 다음 레시피 화면 보여주기 누르면 다음 레시피 내용과 동영상 or 사진 보여주기
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
}