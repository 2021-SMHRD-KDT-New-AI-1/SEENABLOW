package com.leb.munmaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {
 TextView name_acount, tv_number;
 Button btn_home;
 String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        btn_home = findViewById(R.id.btn_start);
        name_acount = findViewById(R.id.lock_word);
        tv_number = findViewById(R.id.mean);
      SharedPreferences sharedPreferences = getSharedPreferences("username", MODE_PRIVATE);
      username = sharedPreferences.getString("username", "");

        name_acount.setText(username);


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}