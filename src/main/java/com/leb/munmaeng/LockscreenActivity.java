package com.leb.munmaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import java.util.List;
import java.util.Random;

public class LockscreenActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    TextView lock_word, lock_mean;
    Button btn_start;
    List<DataVO> data;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockscreen);

        lock_word = findViewById(R.id.lock_word);
        lock_mean = findViewById(R.id.acc_mean);
        btn_start = findViewById(R.id.btn_start);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        lock_word.setText("단속");
        lock_mean.setText("규제하거나 바로잡아 이끄는 일.");

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //어플 태스크 목록에서 완전 삭제 기능
                moveTaskToBack(true); // 태스크를 백그라운드로 이동
                finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
                System.exit(0);
            }
        });

    }
}