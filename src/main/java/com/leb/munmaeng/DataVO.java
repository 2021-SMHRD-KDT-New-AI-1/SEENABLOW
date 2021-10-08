package com.leb.munmaeng;

import java.util.ArrayList;

public class DataVO {

    private String title, word, content, mean;


    ArrayList<DataVO> dataVO = new ArrayList<DataVO>();


    public DataVO(String title, String word, String content, String mean) {
        this.title = title;
        this.word = word;
        this.content = content;
        this.mean = mean;
    }

    public String getTitle() {
        return title;
    }

    public String getWord() {
        return word;
    }

    public String getContent() {
        return content;
    }

    public String getMean() {
        return mean;
    }
}
