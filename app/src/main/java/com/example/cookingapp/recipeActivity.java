package com.example.cookingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class recipeActivity extends AppCompatActivity {
    Button btn_next;
    int index = 0;
    TextView recipe_content;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        btn_next = findViewById(R.id.btn_next);
        recipe_content = findViewById(R.id.recipe_content);

        //한 엑티비티에서 다음 레시피 화면 보여주기 누르면 다음 레시피 내용과 동영상 or 사진 보여주기
        /*
                레시피를 DB에서 읽어오기
                레시피의 길이 ( 단계가 매번 다를 것.  ex) 4차례 설명하는게 있는 반면 어떤건 10차례 설명)
                매 레시피 길이에 따라 넘어가야하는 갯수가 다르기에 배열로 저장.
                첫 번째(1번 레시피 내용)에 들어가야 할 레시피 내용.

                ex) 라면  -> 레시피 이름
                    1. 냄비에 물을 500ml 붓는다.
                    2. 물이 끓으면 면과 스프를 넣고 3분간 끓인다.
                    3. 기호에 맞춰 파, 계란 등을 넣는다.             -> 레시피 단계 3, 각 1, 2, 3 에 따라 맞는 레시피 내용.
                    를 예시로
         */
        final int step_length = 3 ;                               // 읽어온 단계 위의 3단계

        final String[][] step = new String[step_length][1];       // 크기 3X1, -> 3단계에 각 레시피 내용 (한 단계에 하나의 내용만 있기에 3x1로)
        String[] step_content = new String[step_length];          // 크기 3, 각 레시피 내용 -> ??  -> 각 단계에 맞춰 string 데이터 넣어야함 (이걸 어떻게 넣을지가 문제)

        for(int content = 0; content < step_length; content++)
        {
            step_content[content] = "아 ㅋㅋ" + content;           // 임시
            Log.d("내용", step_content[content]);
        }

        for(int i = 0; i < step.length; i++)
        {
            step[i][1] = step_content[i];
            Log.d("내용", step[i][1]);
        }

        // 레시피 단계를 나타내고, 텍스트 문자로 내용을 출력. 각 이미지 or 영상 출력

        recipe_content.setText(step[index] + step[index][1]);

        btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = step[index] + step[index][1];
                    recipe_content.setText(text);
                    index++;
                    }
        });
    }
}