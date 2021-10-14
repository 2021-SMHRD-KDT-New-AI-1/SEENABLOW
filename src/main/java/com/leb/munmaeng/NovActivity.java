package com.leb.munmaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NovActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    List<DataVO> data;
    ListView lv;
    Button btn_find;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nov);
        btn_find = findViewById(R.id.btn_start);
        lv = findViewById(R.id.lv);
        String url = "http://172.30.1.52:3002/";

        Intent intent = getIntent();
        url+=intent.getStringExtra("name");

        data = new ArrayList<DataVO>();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), R.layout.datalist,data);

        lv.setAdapter(adapter);

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

                                        String title = data1.getString("title");
                                        String content = data1.getString("content");
                                        String word = data1.getString("word");
                                        String mean = data1.getString("mean");

                                        DataVO vo = new DataVO(title, word, content, mean);

                                        data.add(vo);
                                        Intent intent = new Intent(NovActivity.this, LockscreenActivity.class);
                                        intent.putExtra("word", word);
                                        intent.putExtra("mean", mean);

                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                adapter.notifyDataSetChanged();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
                requestQueue.add(request);
    }
}