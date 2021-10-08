package com.leb.munmaeng;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import java.util.List;

import kotlin.reflect.KVisibility;

public class DataAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<DataVO> data;
    LayoutInflater inflater;//xml파일을 view객체로 변환하는 역활



    public DataAdapter(Context context, int layout, List<DataVO> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ;
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return
                data.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = inflater.inflate(layout, null);
        }
        TextView title = view.findViewById(R.id.title);
        TextView contect = view.findViewById(R.id.content);
        TextView textView2 = view.findViewById(R.id.textView2);
        TextView textView3 = view.findViewById(R.id.textView3);
        Button btn = view.findViewById(R.id.btn_find);
        title.setText(data.get(i).getTitle());
        textView2.setText(data.get(i).getWord());
        textView3.setText(data.get(i).getMean());
        contect.setText( data.get(i).getContent());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String find = "https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=1&acq=skaldi&qdt=0&ie=utf8&query=";
                find += title.getText();
                Uri uri = Uri.parse(find);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);


            }
        });

        CardView card_flip = view.findViewById(R.id.card_flip);
        Button btn_quiz = view.findViewById(R.id.btn_quiz);

        card_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card_flip.getLayoutParams().height = 600;


            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, QuizActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("단어", data.get(i).getWord());
                intent.putExtra("뜻", data.get(i).getMean());
                intent.putExtra("틀린답1", "우정");
                intent.putExtra("틀린답2", "사랑");
                context.startActivity(intent);
            }
        });




        return view;
    };
}

