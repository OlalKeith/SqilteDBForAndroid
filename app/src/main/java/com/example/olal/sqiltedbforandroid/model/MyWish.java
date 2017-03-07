package com.example.olal.sqiltedbforandroid.model;

/**
 * Created by olal on 2/28/17.
 */
//the database handler class
public class MyWish {

    //instance variables

    public String title;
    public String content;
    public String recordDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
}
