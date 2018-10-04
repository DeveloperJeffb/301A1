package com.example.baglinit_feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryList {



    protected ArrayList<Entry> historyList;


    public HistoryList(){
        historyList = new ArrayList<Entry>();
    }

    public Collection<Entry> getEntry(){
        return new ArrayList<Entry>();
    }

    public void addEntry(Entry entry){          //switch entry with real function/class/activity
        historyList.add(entry);
        //progressing
    }

    public void removeEntry(Entry entry){       //switch entry with real function/class/activity
        historyList.remove(entry);
    }



}
