package com.example.cookingapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class DataClass extends AppCompatActivity {

    //엑티비티 변경- 안댐
    public void nextActivity(String Activity_name) throws ClassNotFoundException {
        Class NextActivity = Class.forName(Activity_name);

        Intent nextIntent = new Intent(this, NextActivity);
        startActivity(nextIntent);
    }

    // 액티비티간 데이터 보내기 (문자열)
    public static void input_data(String Data){
        String contents = Data;
        Intent intent = new Intent();
        intent.putExtra("Data", contents);
        //기본 형태
    }

    // 다른 액티비티에서 보낸 데이터 받기 (문자열)
    public static void output_data(String Data){
        String contents = Data;
        Intent intent = new Intent();
        intent.getStringExtra(Data);
        //기본 형태
    }

    // DB에서 보낸 데이터 받아 오기
}
