package com.leb.munmaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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

public class AccountActivity extends AppCompatActivity {
 TextView name_acount, tv_number, acc_mean;
 Button btn_home;
 String username;
 int title;
 RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        acc_mean = findViewById(R.id.acc_mean);
        btn_home = findViewById(R.id.btn_start);
        name_acount = findViewById(R.id.lock_word);
        tv_number = findViewById(R.id.mean);
      SharedPreferences sharedPreferences = getSharedPreferences("username", MODE_PRIVATE);
      username = sharedPreferences.getString("username", "");

        name_acount.setText(username);

        String url = "http://172.30.1.52:3002/rank";
        url += "?username=" + username;

        if (requestQueue == null) {
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

                            for (int i = 0; i < list.length(); i++) {

                                JSONObject data1 = (JSONObject) list.get(i);

                                title = data1.getInt("count(case when username = '"+username+"' then 1 end)");
                                tv_number.setText((title/2)+"개");

                                if(title/2>10){
                                    acc_mean.setText("축하 합니다. 1등입니다!");
                                }else if(title/2<5){
                                    acc_mean.setText("공부좀 하세요");
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        requestQueue.add(request);
    }
}