package com.example.baglinit_feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class EntryList {



        protected ArrayList<Entry> entryList;
        protected ArrayList<Listener> listeners;

        private void notifyListeners(){
            for (Listener listener: listeners){
                listener.update();
            }
            //CONTIENUE
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

        public int size(){
            return entryList.size();
        }


    }


