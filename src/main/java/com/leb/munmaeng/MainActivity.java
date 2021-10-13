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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    CardView card_nov, card_poem, card_news, card_column;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    TextView navi_textview, navi_textview2;
    String username, age, gender;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //해당 액티비티를 잠금화면에 띄워줌


        setContentView(R.layout.activity_main);
        card_nov =findViewById(R.id.card_nov);
        card_poem =findViewById(R.id.card_poem);
        card_news =findViewById(R.id.card_news);
        card_column = findViewById(R.id.card_column);
        drawerLayout = findViewById(R.id.drawer_layout);
        intent = getIntent();

        navigationView =  (NavigationView) findViewById(R.id.naviView);
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
        View nav_header_view = navigationView.getHeaderView(0);
        navi_textview = (TextView)nav_header_view.findViewById(R.id.user_name);
        View nav_header_view2 = navigationView.getHeaderView(0);
        navi_textview2 = (TextView)nav_header_view2.findViewById(R.id.userinfo);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //액션바 객체
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //뒤로가기 버튼 이미지 적용
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        SharedPreferences sharedPreferences = getSharedPreferences("username", MODE_PRIVATE);
         username = sharedPreferences.getString("username", "");
         age = sharedPreferences.getString("age", "");
         gender =sharedPreferences.getString("gender", "");

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
        int id = item.getItemId();
        if(id == R.id.menu_item1){
            Intent intent = new Intent(MainActivity.this, AccountActivity.class);
            startActivity(intent);
        }else if(id == R.id.menu_item2){
            Log.d("실행", "ㅇㅇ");
            Intent intent = new Intent(getApplicationContext(), ScreenService.class);
            startService(intent);

        }

        switch (item.getItemId()){

            case android.R.id.home:
                navi_textview.setText(username);
                navi_textview2.setText(age+" 세 "+gender);

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