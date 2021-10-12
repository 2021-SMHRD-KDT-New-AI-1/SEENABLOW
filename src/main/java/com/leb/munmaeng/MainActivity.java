package com.leb.munmaeng;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView card_nov, card_poem, card_news, card_column;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card_nov =findViewById(R.id.card_nov);
        card_poem =findViewById(R.id.card_poem);
        card_news =findViewById(R.id.card_news);
        card_column = findViewById(R.id.card_column);


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