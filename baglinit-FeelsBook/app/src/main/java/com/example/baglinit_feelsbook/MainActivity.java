package com.example.baglinit_feelsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    //Declare variable of my activity

    private IncreaseCount increaseCount = new IncreaseCount();
    private ImageButton love_imageButton;
    private ImageButton joy_imageButton;


    private TextView lovecount;
    private TextView joycount;
    private ListView entrylistView;
    private EditText comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variable after set content (i.e. after main screen is establishedd


        entrylistView = findViewById(R.id.entrylistView);
        Collection<Entry> entrys = EntryListController.getEntryList().getEntry();
        final ArrayList<Entry> list = new ArrayList<>(entrys);
        final EntryAdapter entryAdapter = new EntryAdapter(this, list);
        entrylistView.setAdapter(entryAdapter);
        EntryListController.getEntryList().addListener(new Listener(){
            @Override
            public void update() {
                list.clear();
                Collection<Entry> entrys = EntryListController.getEntryList().getEntry();
                list.addAll(entrys);
                entryAdapter.notifyDataSetChanged();


            }
        });

        entrylistView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Delete"+list.get(position).toString(), Toast.LENGTH_SHORT).show();

                Entry entry = list.get(position);
                EntryListController.getEntryList().removeEntry(entry);

                return false;



            }



        });


        comment = findViewById(R.id.comment);

        love_imageButton= findViewById(R.id.love_imageButton);
        love_imageButton.setOnClickListener(listener);
        lovecount = findViewById(R.id.lovecount);


        joy_imageButton = findViewById(R.id.joy_imageButton);
        joy_imageButton.setOnClickListener(listener);
        joycount = findViewById(R.id.joycount);



    }



    private View.OnClickListener listener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.love_imageButton:
                   // openDialog();
                    addEntryAction("love");
                    increaseCount.increment(lovecount);
                    break;
                case R.id.joy_imageButton:
                    //openDialog();

                    increaseCount.increment(joycount);
                    break;
            }

        }
    };

    public void addEntryAction(String feel){

        EntryListController et = new EntryListController();

        et.addEntry(new Entry(new Date(System.currentTimeMillis()), feel, comment.getText().toString() ));
        //Will the input be reset?
    }



}
