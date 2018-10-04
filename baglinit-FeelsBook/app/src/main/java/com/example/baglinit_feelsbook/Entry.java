package com.example.baglinit_feelsbook;

public class Entry {

    protected String Timestamp;
    protected String Feeling;
    protected String Comment_Entry;

    public Entry(String Timestamp, String Feeling, String Comment_Entry) {
        this.Timestamp = Timestamp;
        this.Feeling = Feeling;
        this.Comment_Entry = Comment_Entry;
    }

    public String getTimestamp() {
        return this.Timestamp;
    }


    public String getFeeling() {
        return this.Feeling;
    }

    public String getComment_Entry() {
        return this.Comment_Entry;
    }
}

