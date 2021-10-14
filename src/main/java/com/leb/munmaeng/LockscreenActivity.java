package com.leb.munmaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Random;

public class LockscreenActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    TextView lock_word, lock_mean;
    Button btn_start;
    List<DataVO> data;
    int random, random1;
    String word, mean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockscreen);

        lock_word = findViewById(R.id.lock_word);
        lock_mean = findViewById(R.id.acc_mean);
        btn_start = findViewById(R.id.btn_start);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);


        String[] arr = new String[]{"novel", "poem", "news", "column"};
        random = new Random().nextInt(arr.length-1);
        String url = "http://172.30.1.52:3002/";
        url += arr[random];

        if(requestQueue ==null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }


        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray list = new JSONArray(response);
                            random1 = new Random().nextInt(list.length()-1);

                            for (int i = 0; i < list.length(); i++) {

                            }
                            JSONObject data1 = (JSONObject) list.get(random1);

                            word = data1.getString("word");
                            mean = data1.getString("mean");
                            lock_word.setText(word);
                            lock_mean.setText(mean);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );


 requestQueue.add(request);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //어플 태스크 목록에서 완전 삭제 기능
//                moveTaskToBack(true); // 태스크를 백그라운드로 이동
//                finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
//                System.exit(0);
                onBackPressed();
            }
        });

    }
}