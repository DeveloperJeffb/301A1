package com.example.baglinit_feelsbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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


//public class UsersAdapter extends ArrayAdapter<User> {
//    public UsersAdapter(Context context, ArrayList<User> users) {
//        super(context, 0, users);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Get the data item for this position
//        User user = getItem(position);
//        // Check if an existing view is being reused, otherwise inflate the view
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
//        }
//        // Lookup view for data population
//        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
//        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
//        // Populate the data into the template view using the data object
//        tvName.setText(user.name);
//        tvHome.setText(user.hometown);
//        // Return the completed view to render on screen
//        return convertView;
//    }
//}