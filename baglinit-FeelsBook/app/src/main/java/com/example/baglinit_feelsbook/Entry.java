package com.example.baglinit_feelsbook;

//Purpose: Establish Entry Object that will contain time, feeling & comment to be entered at the same time a feeling is clicked
//Design rational: object will neatly organize information needed to be inserted at once when a button is clicked, exact object information will be returned when needed
//Issues: No outstanding issues

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

