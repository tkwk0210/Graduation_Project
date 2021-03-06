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
        qrScan.setBeepEnabled(false);                // QR코드 스캔시 삑 소리가 남 false시 소리 X
        qrScan.setOrientationLocked(false);          // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경
        qrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null) {
            if(result.getContents() == null) { //qr코드 읽기 실패 or 돌아가기
                Toast.makeText(this, "QR코드 스캔을 취소 합니다.", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Intent nextIntent;
                nextIntent = new Intent(QRActivity.this, recipeActivity.class);
                nextIntent.putExtra("load_URL", result.getContents()); // qr코드 URL 보내기
                startActivity(nextIntent);

                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}