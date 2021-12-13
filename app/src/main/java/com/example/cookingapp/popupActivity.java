package com.example.cookingapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class popupActivity extends AppCompatActivity {
    ImageView X_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_layout);

        X_button = findViewById(R.id.X_btn);
        X_button.setOnClickListener(new View.OnClickListener() {
            @Override //꺼짐
            public void onClick(View v) {
                finish();
            }
        });
    }
    // 밖에 터치하면 안꺼지게.
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE){ return false; }

        return true;
    }
    // 백버튼 막기
    public void onBackPressed(){
        return;
    }
}
