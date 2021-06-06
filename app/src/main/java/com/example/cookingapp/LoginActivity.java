package com.example.cookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText Id;
    EditText passwd;
    Button Login;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Id = findViewById(R.id.user_id);
        passwd = findViewById(R.id.user_password);
        Login = findViewById(R.id.Login_btn);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인 확인

                //로그인 토대로 유저 정보 출력 (회원 정보 출력 구간)
                if(login()){
                    Intent nextIntent = new Intent(LoginActivity.this, MainActivity.class);
                    nextIntent.putExtra("login_data", true);
                    Log.i("로그인 : ", "성공");
                    startActivity(nextIntent);

                    finish();
                }
            }
        });

    }

    boolean login(){
        // DB SELECT
        String Id_data = "tkwk0210";
        String passwd_data = "123";

        String answer_Id = Id.getText().toString();
        String answer_passwd = passwd.getText().toString();

        if (answer_Id.equals(Id_data)) {
            if(answer_passwd.equals(passwd_data))
            {
                Toast.makeText(getApplicationContext(), "로그인 완료", Toast.LENGTH_SHORT).show();
                return true;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            //로그인 실패
            Toast.makeText(getApplicationContext(), "없는 아이디 입니다.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}