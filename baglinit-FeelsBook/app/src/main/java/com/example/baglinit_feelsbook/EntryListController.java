package com.example.baglinit_feelsbook;



//Purpose: Handle Simple events for the entry list
//Design rational: Establish get EntryList method and add entry list method
//Issues: No outstanding issues
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
