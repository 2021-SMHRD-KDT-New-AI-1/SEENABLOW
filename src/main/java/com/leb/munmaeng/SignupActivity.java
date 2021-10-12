package com.leb.munmaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class SignupActivity extends AppCompatActivity {

    EditText et_username, et_age;
    RadioButton rb_man, rb_woman;
    RequestQueue requestQueue;
    Button btn_signup;
    RadioGroup rg_gender;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_username = findViewById(R.id.et_username);
        et_age = findViewById(R.id.et_age);
        rb_man =findViewById(R.id.rb_man);
        rb_woman = findViewById(R.id.rb_woman);
        btn_signup =findViewById(R.id.btn_signup);
        rg_gender = findViewById(R.id.rg_gender);


        SharedPreferences pref = getSharedPreferences("isFirst", SignupActivity.MODE_PRIVATE);
        boolean first = pref.getBoolean("isFirst", false);

        SharedPreferences pref_data = getSharedPreferences("username",MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();
        SharedPreferences.Editor editor_data = pref.edit();
        if(first==false){

            if (requestQueue == null) {
                requestQueue = Volley.newRequestQueue(getApplicationContext());
            }

            btn_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String username = et_username.getText().toString();
                    String age = et_age.getText().toString();
                    if(rb_man.isChecked()==true){
                        gender = rb_man.getText().toString();
                    }else if(rb_woman.isChecked()==true){
                        gender = rb_woman.getText().toString();
                    }else{
                        Toast.makeText(getApplicationContext(), "성별을 선택하세요", Toast.LENGTH_SHORT).show();
                    }


                    String url = "http://172.30.1.52:3002/signup";
                    url += "?username=" + username;
                    url += "&age=" + age;
                    url += "&gender=" + gender;

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

                    editor_data.putString("name", username);
                    editor_data.commit();
                    editor.putBoolean("isFirst",true);
                    editor.commit();

                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            });
            //앱 최초 실행시 하고 싶은 작업
        }else{

            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            startActivity(intent);


        }


    }
}