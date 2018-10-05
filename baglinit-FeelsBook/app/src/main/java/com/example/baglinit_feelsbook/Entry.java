package com.example.baglinit_feelsbook;
import java.util.Date;

public class Entry {

    protected Date Timestamp;
    protected String Feeling;
    protected String Comment_Entry;

    public Entry(Date Timestamp, String Feeling, String Comment_Entry) {
        this.Timestamp = Timestamp;
        this.Feeling = Feeling;
        this.Comment_Entry = Comment_Entry;
    }


    public Date getTimestamp() {
        return this.Timestamp;
    }


    public String getFeeling() {
        return this.Feeling;
    }

    public String getComment_Entry() {
        return this.Comment_Entry;
    }

//    public String toString(){
//        return getComment_Entry();
//    }
}

