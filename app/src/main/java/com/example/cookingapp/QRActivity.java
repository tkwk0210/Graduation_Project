package com.example.cookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRActivity extends AppCompatActivity {
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_scan);

        qrScan = new IntentIntegrator(this);
        qrScan.setBeepEnabled(true);                // QR코드 스캔시 삑 소리가 남 false시 소리 X
        qrScan.setOrientationLocked(false);         // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경
        qrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null) {
            if(result.getContents() == null) { //qr코드 읽기 실패 or 돌아가기
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                finish();
            } else { //qr코드 읽기 성공
                /*
                레시피 데이터를 읽으면 어떻게 읽지..
                1. qr코드로 데이터를 레시피 이름생성 -> 레시피 이름을 변수에 저장 후
                2. 레시피 이름 보고 바로 레시피 데이터 읽어와서 보여주기.(바로 DB데이터 읽어오기)
                3. 레시피 이름 보고 검색 메커니즘으로 데이터 읽어오기.
                */

                String recipe_name = result.getContents();
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
