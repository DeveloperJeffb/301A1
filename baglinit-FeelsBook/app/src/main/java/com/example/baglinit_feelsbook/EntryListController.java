package com.example.baglinit_feelsbook;

public class EntryListController {

    private  static EntryList entryList = null;

    static public EntryList getEntryList(){
        if(entryList ==null){
            entryList = new EntryList();
        }
        return entryList;
    }

    public void addEntry(Entry entry){
        getEntryList().addEntry(entry);

    }




}
