package com.lux.ex047activitysystemintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.b1).setOnClickListener(view -> {
            //Dial화면 앱 실행하기
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            //미리 전화번호까지 선택 가능
            Uri uri=Uri.parse("tel:01056919962");
            intent.setData(uri);
            startActivity(intent);
        });

        findViewById(R.id.b2).setOnClickListener(view -> {
            //짧은 문자 보내기 -SMS
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_SENDTO);

            Uri uri=Uri.parse("smsto:01012341234,01012345688");
            intent.setData(uri);
            intent.putExtra("sms_body","Hello");
            startActivity(intent);
        });

        findViewById(R.id.b3).setOnClickListener(view -> {
            //웹사이트 열기 - 웹 브라우저 앱 열기
            Uri uri=Uri.parse("https://www.naver.com");

            Intent intent=new Intent(Intent.ACTION_VIEW,uri); //action, data생성자로 전달

            startActivity(intent);
        });

        findViewById(R.id.b4).setOnClickListener(v -> {
            //사진 앱
            Intent intent=new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");   //image/* => 모든 확장자

            //버전에 따라서는 startActivityForResult()로 해야만 실행되는 경우도 있음.
            startActivity(intent);
            //선택한 사진 받아 보여주는 수업은 차후에 별도로 진행 예정
        });

        findViewById(R.id.b5).setOnClickListener(view -> {
            //카메라 앱
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
            //캡쳐한 사진 받아 보여주는 수업은 차후에 별도로 진행 예정
        });

        //안드로이드 개발자 사이트 또는 구글 검색을 통해 기타 많은 시스템 인텐트의 액션을 적용할 수 있음.
    }
}