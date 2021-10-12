package com.leb.munmaeng;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.List;

public class DataAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<DataVO> data;
    LayoutInflater inflater;//xml파일을 view객체로 변환하는 역활
    Intent intent;
    boolean isclick;

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

        TextView title = view.findViewById(R.id.name_acount);
        TextView contect = view.findViewById(R.id.comment);
        TextView textView2 = view.findViewById(R.id.tv_quizNum);
        TextView textView3 = view.findViewById(R.id.tv_number);
        Button btn = view.findViewById(R.id.btn_home);
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
        Button btn_quiz = view.findViewById(R.id.btn_back);
        isclick = false;
        card_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(isclick == false) {
                btn.setVisibility(btn.VISIBLE);
                btn_quiz.setVisibility(btn_quiz.VISIBLE);
                contect.setVisibility(contect.VISIBLE);
                textView2.setVisibility(textView2.VISIBLE);
                textView3.setVisibility(textView3.VISIBLE);
                isclick = true;
            }else {
                btn.setVisibility(btn.GONE);
                btn_quiz.setVisibility(btn_quiz.GONE);
                contect.setVisibility(contect.GONE);
                textView2.setVisibility(textView2.GONE);
                textView3.setVisibility(textView3.GONE);
                isclick = false;
            }

            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, QuizActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("단어", data.get(i).getWord());
                intent.putExtra("뜻", data.get(i).getMean());
                if(i == 9){
                    intent.putExtra("틀린답1", data.get(i-2).getWord());
                    intent.putExtra("틀린답2", data.get(i-1).getWord());
                }else if(i ==0) {
                    intent.putExtra("틀린답1", data.get(i+2).getWord());
                    intent.putExtra("틀린답2", data.get(i+1).getWord());
                }else{
                    intent.putExtra("틀린답1", data.get(i-2).getWord());
                    intent.putExtra("틀린답2", data.get(i+2).getWord());
                }
                context.startActivity(intent);
            }
        });




        return view;
    };
}

