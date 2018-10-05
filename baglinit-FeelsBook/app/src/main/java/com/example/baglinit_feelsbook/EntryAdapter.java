package com.example.baglinit_feelsbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//Purpose: Class to establish how the entries (history, feeling, comment) will be displayed ont the list view
//Design rational: positioned entries as followed,iso8601 Date&Time format, feeling, comment
//Issues: No outstanding issues

public class EntryAdapter extends ArrayAdapter<Entry> {
    public  EntryAdapter(Context context, ArrayList<Entry> entry){
        super(context,0, entry );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Entry entry = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.entry_layout,parent,false);
        }

        TextView textView_Comment = convertView.findViewById(R.id.textView_Comment);
        TextView textView_Feeling = convertView.findViewById(R.id.textView_Feeling);
        TextView textView_Date = convertView.findViewById(R.id.textView_Date);

        textView_Comment.setText(entry.Comment_Entry);
        textView_Feeling.setText(entry.Feeling);
        textView_Date.setText(entry.Timestamp.toString());

        return convertView;

    }

}

