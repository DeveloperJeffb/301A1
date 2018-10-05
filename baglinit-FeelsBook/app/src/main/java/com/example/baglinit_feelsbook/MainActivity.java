package com.example.baglinit_feelsbook;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

        entrylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); //check without main activity
                builder.setTitle("Edit date");
                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT); //Switch to text
                builder.setView(input);
               // final Entry entry = list.get(position);
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String text = input.getText().toString();
                        Entry entry = list.get(position);
                        EntryListController.getEntryList().updateEntry(entry, text);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();






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
        DateFormat enterdate = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
        String convertDate = enterdate.format(new Date());
        et.addEntry(new Entry(convertDate, feel, comment.getText().toString() ));
        //Will the input be reset?
    }



}
