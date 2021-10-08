package com.leb.munmaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignupActivity extends AppCompatActivity {

    EditText et_username, et_age;
    RadioButton rb_man, rb_woman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


    }
}