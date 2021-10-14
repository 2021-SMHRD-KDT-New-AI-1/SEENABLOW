package com.leb.munmaeng;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    Intent intent;
    String ans1, ans2, ans3, quiz;
    TextView tv_quiz;
    Button btn_answer1, btn_answer2, btn_answer3;
    Context context;
    RequestQueue requestQueue;
    String username, url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        tv_quiz = findViewById(R.id.tv_quiz);
        intent = getIntent();
        SharedPreferences sharedPreferences = getSharedPreferences("username", MODE_PRIVATE);
        username = sharedPreferences.getString("username", "");

        url = "http://172.30.1.52:3002/solving?username=";
        url += username;

        String[] array = new String[3];
        ans1 = intent.getStringExtra("단어");
        ans2 = intent.getStringExtra("틀린답1");
        ans3 = intent.getStringExtra("틀린답2");
        quiz = intent.getStringExtra("뜻");
        tv_quiz.setText(quiz);
        array = new String[]{ans1, ans2, ans3};
        Button[] answer_array = new Button[]{btn_answer1, btn_answer2, btn_answer3};

        Collections.shuffle(Arrays.asList(answer_array));
        Collections.shuffle(Arrays.asList(array));

       for(int i =0; i<answer_array.length; i++){
           answer_array[i].setText(array[i]);
       }
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        btn_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_answer1.getText().equals(ans1)){
                    url += "&solve=Y";
                    url += "&word="+ans1;
                    Toast.makeText(getApplicationContext(),"정답입니다!", Toast.LENGTH_SHORT).show();
                    StringRequest request = new StringRequest(
                            Request.Method.GET,
                            url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    });
                    requestQueue.add(request);
                    onBackPressed();
                }else{
                    Toast.makeText(getApplicationContext(),"다시 선택해주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_answer2.getText().equals(ans1)){
                    url += "&solve=Y";
                    url += "&word="+ans1;
                    Toast.makeText(getApplicationContext(),"정답입니다", Toast.LENGTH_SHORT).show();
                    StringRequest request = new StringRequest(
                            Request.Method.GET,
                            url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                                                    }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    });
                    requestQueue.add(request);
                    onBackPressed();
                }else{
                    Toast.makeText(getApplicationContext(),"다시 선택해주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_answer3.getText().equals(ans1)){

                    url += "&solve=Y";
                    url += "&word="+ans1;
                    Toast.makeText(getApplicationContext(),"정답입니다!", Toast.LENGTH_SHORT).show();
                    StringRequest request = new StringRequest(
                            Request.Method.GET,
                            url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    });
                    requestQueue.add(request);
                    onBackPressed();
                }else{
                    Toast.makeText(getApplicationContext(),"다시 선택해주세요!", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }



}