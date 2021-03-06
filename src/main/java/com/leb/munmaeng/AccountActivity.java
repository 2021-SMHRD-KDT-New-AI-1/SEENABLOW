package com.leb.munmaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountActivity extends AppCompatActivity {
    private NavigationView navigationView;
    TextView name_acount, tv_number;
    Button btn_home;
    ImageView[] uni;
    TextView[] tv;
    String username;
    ImageView navi_icon;

    int title;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        uni = new ImageView[8];
        tv = new TextView[8];
        btn_home = findViewById(R.id.btn_start);
        name_acount = findViewById(R.id.lock_word);
        tv_number = findViewById(R.id.mean);

//        View view = getLayoutInflater().from(this).inflate(R.layout.activity_main,null);
//        navigationView = (NavigationView) view.findViewById(R.id.naviView);
//        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
//        View nav_header_view3 = navigationView.getHeaderView(0);
//        navi_icon = (ImageView) nav_header_view3.findViewById(R.id.navi_icon);





        for (int i = 0; i < uni.length; i++) {
            int resID = getResources().getIdentifier("uni" + (i + 1), "id", getPackageName());
            uni[i] = findViewById(resID);
        }
        for (int i = 0; i < tv.length; i++) {
            int resID = getResources().getIdentifier("uni_tv" + (i + 1), "id", getPackageName());
            tv[i] = findViewById(resID);
        }

        SharedPreferences sharedPreferences = getSharedPreferences("username", MODE_PRIVATE);
        username = sharedPreferences.getString("username", "");
        SharedPreferences.Editor editor= sharedPreferences.edit();

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

                                title = data1.getInt("count(case when username = '" + username + "' then 1 end)");
                                title = title/2;
                                tv_number.setText(title  + "???");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (title >= 5) {
                            uni[0].setImageResource(R.drawable.uni_1color);
                            tv[0].setText(" ??????!! ???????????????!");
                            uni[0].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.v("asd", "sdaf");
                                    editor.putString("class", "8");
                                    editor.commit();
                                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                                    startActivity(intent);

                                }
                            });
                        } if (title > 10) {
                            uni[1].setImageResource(R.drawable.uni_2color);
                            tv[1].setText(" ??????!! ???????????????!");
                            uni[1].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.v("asd", "sdaf");
                                    editor.putString("class", "7");
                                    editor.commit();
                                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                                    intent.putExtra("image", "1");
                                    startActivity(intent);
                                }
                            });
                        }  if (title > 15) {
                            uni[2].setImageResource(R.drawable.uni_3color);
                            tv[2].setText(" ??????!! ???????????????!");
                            uni[2].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    editor.putString("class", "6");
                                    editor.commit();
                                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                                    intent.putExtra("image", "1");
                                    startActivity(intent);
                                }
                            });
                        }  if (title > 20) {
                            uni[3].setImageResource(R.drawable.uni_4color);
                            tv[3].setText(" ??????!! ???????????????!");
                            uni[3].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    editor.putString("class", "5");
                                    editor.commit();
                                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                                    intent.putExtra("image", "1");
                                    startActivity(intent);
                                }
                            });
                        }  if (title > 25) {
                            uni[4].setImageResource(R.drawable.uni_5color);
                            tv[4].setText(" ??????!! ???????????????!");
                            uni[4].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    editor.putString("class", "4");
                                    editor.commit();
                                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                                    intent.putExtra("image", "1");
                                    startActivity(intent);
                                }
                            });
                        }  if (title > 30) {
                            uni[5].setImageResource(R.drawable.uni_6color);
                            tv[5].setText(" ??????!! ???????????????!");
                            uni[5].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    editor.putString("class", "3");
                                    editor.commit();
                                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                                    intent.putExtra("image", "1");
                                    startActivity(intent);
                                }
                            });
                        }  if (title > 35) {
                            uni[6].setImageResource(R.drawable.uni_7color);
                            tv[6].setText(" ??????!! ???????????????!");
                            uni[6].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    editor.putString("class", "2");
                                    editor.commit();
                                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                                    intent.putExtra("image", "1");
                                    startActivity(intent);
                                }
                            });
                        }  if (title > 40) {
                            uni[7].setImageResource(R.drawable.uni_8color);
                            tv[7].setText(" ??????!! ???????????????!");
                            uni[7].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    editor.putString("class", "1");
                                    editor.commit();
                                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                                    intent.putExtra("image", "1");
                                    startActivity(intent);
                                }
                            });
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