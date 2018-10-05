package com.example.baglinit_feelsbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class EntryList {



        protected ArrayList<Entry> entryList;
        protected ArrayList<Listener> listeners;

        private void notifyListeners(){
            for (Listener listener: listeners){
                listener.update();
            }

        }


        public void addListener(Listener l){
            listeners.add(l);

        }

        public void removeListener(Listener l){
            listeners.remove(l);
        }

        public EntryList(){
            entryList = new ArrayList<Entry>();
            listeners = new ArrayList<Listener>();
        }

        public Collection<Entry> getEntry(){
            return entryList;
        }

        public void addEntry(Entry entry){          //switch entry with real function/class/activity
            entryList.add(entry);
            notifyListeners();
            //progressing
        }

        public void removeEntry(Entry entry){       //switch entry with real function/class/activity
            entryList.remove(entry);
            notifyListeners();

        }
        
        public void updateEntry(Entry entry, String time_change){
            entry.Timestamp = time_change;

            Comparator<Entry> EntryTimeComparator = new Comparator<Entry>() {

                @Override
                public int compare(Entry o1, Entry o2) {
                    String Entry1 = o1.getTimestamp().toUpperCase();
                    String Entry2 = o2.getTimestamp().toUpperCase();
                    return Entry1.compareTo(Entry2);
                }};
            Collections.sort(entryList, EntryTimeComparator);
            //SORT ARRAY LIST
            notifyListeners();

        }

        public int size(){
            return entryList.size();
        }


    }


