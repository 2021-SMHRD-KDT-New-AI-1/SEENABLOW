package com.leb.munmaeng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    CardView card_nov, card_poem, card_news, card_column;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card_nov =findViewById(R.id.card_nov);
        card_poem =findViewById(R.id.card_poem);
        card_news =findViewById(R.id.card_news);
        card_column = findViewById(R.id.card_column);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.naviView);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //액션바 객체
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //뒤로가기 버튼 이미지 적용
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        card_nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NovActivity.class);
                intent.putExtra("name", "novel");
                startActivity(intent);
            }
        });
        card_poem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NovActivity.class);
                intent.putExtra("name", "poem");
                startActivity(intent);
            }
        });

        card_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NovActivity.class);
                intent.putExtra("name", "news");
                startActivity(intent);
            }
        });

        card_column.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NovActivity.class);
                intent.putExtra("name", "column");
                startActivity(intent);
            }
        });





    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert_ex = new AlertDialog.Builder(this);
        alert_ex.setMessage("정말로 종료하시겠습니까?");

        alert_ex.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert_ex.setPositiveButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alert_ex.setTitle("Good Bye!");
        AlertDialog alert = alert_ex.create();
        alert.show();

    }
}