package com.example.cookingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity {
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
            public void onClick(View view) {

                String user_id = Id.getText().toString();
                String user_pwd = passwd.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {//로그인 성공시

                                String mb_id = jsonObject.getString( "mb_id" );
                                String mb_password = jsonObject.getString( "mb_password" );
                                //String UserName = jsonObject.getString( "UserName" );

                                Toast.makeText( getApplicationContext(), String.format("환영합니다."), Toast.LENGTH_SHORT ).show();
                                Intent intent = new Intent( LoginActivity.this, MainActivity.class );

                                intent.putExtra( "mb_id", mb_id );
                                intent.putExtra( "mb_password", mb_password );
                                //intent.putExtra( "UserName", UserName );

                                startActivity( intent );

                            } else {//로그인 실패시
                                Toast.makeText( getApplicationContext(), "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT ).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest( user_id, user_pwd, responseListener );
                RequestQueue queue = Volley.newRequestQueue( LoginActivity.this );
                queue.add( loginRequest );

            }
        });

    }
}

                /*로그인 토대로 유저 정보 출력 (회원 정보 출력 구간)
                if(login()){
                    Intent nextIntent = new Intent(LoginActivity.this, MainActivity.class);
                    nextIntent.putExtra("login_data", true);
                    Log.i("로그인 : ", "성공");
                    startActivity(nextIntent);

                    finish();
                }*/
