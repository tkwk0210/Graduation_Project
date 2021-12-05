package com.example.cookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class recipeActivity extends AppCompatActivity {

        private WebView mWebView; // 웹뷰 선언
        private WebSettings mWebSettings; //웹뷰세팅
        String URL = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.recipe);


            Intent intent = getIntent();
            URL = intent.getStringExtra("load_URL");

            if(URL != null)
            {
                URL = intent.getStringExtra("load_URL");
            }
            else{
                URL = "http://15.164.123.111/dashboard/";
            }

            // 웹뷰 시작
            mWebView = (WebView) findViewById(R.id.webView);

            mWebView.setWebViewClient(new WebViewClient());                             // 클릭시 새창 안뜨게

            mWebSettings = mWebView.getSettings();                                      // 세부 세팅 등록
            mWebSettings.setJavaScriptEnabled(true);                                    // 웹페이지 자바스클비트 허용 여부
            mWebSettings.setSupportMultipleWindows(false);                              // 새창 띄우기 허용 여부
            mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false);               // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
            mWebSettings.setLoadWithOverviewMode(true);                                 // 메타태그 허용 여부
            mWebSettings.setUseWideViewPort(true);                                      // 화면 사이즈 맞추기 허용 여부
            mWebSettings.setSupportZoom(false);                                         // 화면 줌 허용 여부
            mWebSettings.setBuiltInZoomControls(false);                                 // 화면 확대 축소 허용 여부
            mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
            mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);                       // 브라우저 캐시 허용 여부
            mWebSettings.setDomStorageEnabled(true);                                    // 로컬저장소 허용 여부


            mWebView.loadUrl(URL); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
        }

        /*
            Button btn_next;
    int index = 0;
    TextView recipe_content;

        btn_next = findViewById(R.id.btn_next);
        recipe_content = findViewById(R.id.recipe_content);

        //한 엑티비티에서 다음 레시피 화면 보여주기 누르면 다음 레시피 내용과 동영상 or 사진 보여주기

                레시피를 DB에서 읽어오기
                레시피의 길이 ( 단계가 매번 다를 것.  ex) 4차례 설명하는게 있는 반면 어떤건 10차례 설명)
                매 레시피 길이에 따라 넘어가야하는 갯수가 다르기에 배열로 저장.
                첫 번째(1번 레시피 내용)에 들어가야 할 레시피 내용.

                ex) 라면  -> 레시피 이름
                    1. 냄비에 물을 500ml 붓는다.
                    2. 물이 끓으면 면과 스프를 넣고 3분간 끓인다.
                    3. 기호에 맞춰 파, 계란 등을 넣는다.             -> 레시피 단계 3, 각 1, 2, 3 에 따라 맞는 레시피 내용.
                    를 예시로
                    -> 내용만
                    -> 재료. 재료 갯수 역시 레시피와 같이 많음. 매번 양도 갯수도 다르다. -> 재료 n개, n개의 양
                    면, 스프, 물

        final int step_length = 3 ;                                     // 읽어온 단계 위의 3단계
        final int ingredients = 3 ;                                     // 식재료 3개

        //final String[][] step = new String[step_length][1];           // 크기 3X1, -> 3단계에 각 레시피 내용 (한 단계에 하나의 내용만 있기에 3x1로)
        final String[] step_content = new String[step_length];          // 크기 3, 각 레시피 내용 -> ??  -> 각 단계에 맞춰 데이터 넣기

        final String[] Ingredients = new String[ingredients];           // 식재료 이름
        final String[] Ingredients_amount = new String[ingredients];    // 식재료 양


        for(int i = 0; i < step_length; i++) {
            step[i] = "1";
        }

        for(int Ingredients_index = 0; Ingredients_index < ingredients; Ingredients_index++){
            //
            Ingredients[Ingredients_index] = Ingredients_index + "식재료";
            Ingredients_amount[Ingredients_index] = Ingredients_index + "식재료 양";
        }

        for(int content = 0; content < step_length; content++) {
            step_content[content] = "내용 " + content;
            //step[content][0] = step_content[content];

            Log.d("내용", step_content[content]);
        }
        // 레시피 단계를 나타내고, 텍스트 문자로 내용을 출력. 각 이미지 or 영상 출력

        recipe_content.setText((index+1) + step_content[index]);

        btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(index < step_length) {
                            String text = (index+1) + step_content[index];
                            recipe_content.setText(text);
                            Log.d("내용", step_content[index]);
                            index++;
                        }
                        else{
                            //레시피 종료

                        }
                    }
        }); */
}