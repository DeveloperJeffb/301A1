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

//Note did not finish saving information after app has been terminated


public class MainActivity extends AppCompatActivity {

    //Declare variable of my activity

    private IncreaseCount increaseCount = new IncreaseCount();
    private DecreaseCount decreaseCount = new DecreaseCount();
    private ImageButton love_imageButton;
    private ImageButton joy_imageButton;
    private ImageButton surprise_imageButton;
    private ImageButton anger_imageButton;
    private ImageButton sad_imageButton;
    private ImageButton fear_imageButton;




    private TextView lovecount;
    private TextView joycount;
    private TextView surprisecount;
    private TextView angercount;
    private TextView sadcount;
    private TextView fearcount;

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
//


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

                String check = entry.getFeeling();
                if (check == "love"){
                    decreaseCount.decrease(lovecount);
                }
                if (check == "joy"){
                    decreaseCount.decrease(joycount);

                }
                if (check == "surprise"){
                    decreaseCount.decrease(surprisecount);

                }
                if (check == "anger"){
                    decreaseCount.decrease(angercount);

                }
                if (check == "sad"){
                    decreaseCount.decrease(sadcount);

                }
                if (check == "fear"){
                    decreaseCount.decrease(fearcount);
                }

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

        surprise_imageButton= findViewById(R.id.surprise_imageButton);
        surprise_imageButton.setOnClickListener(listener);
        surprisecount = findViewById(R.id.surprisecount);

        anger_imageButton = findViewById(R.id.anger_imageButton);
        anger_imageButton.setOnClickListener(listener);
        angercount = findViewById(R.id.angercount);

        sad_imageButton = findViewById(R.id.sad_imageButton);
        sad_imageButton.setOnClickListener(listener);
        sadcount = findViewById(R.id.sadcount);

        fear_imageButton = findViewById(R.id.fear_imageButton);
        fear_imageButton.setOnClickListener(listener);
        fearcount = findViewById(R.id.fearcount);



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
                    addEntryAction("joy");
                    increaseCount.increment(joycount);
                    break;

                case R.id.surprise_imageButton:
                    //openDialog();
                    addEntryAction("surprise");
                    increaseCount.increment(surprisecount);
                    break;

                case R.id.anger_imageButton:
                    //openDialog();
                    addEntryAction("anger");
                    increaseCount.increment(angercount);
                    break;
                case R.id.sad_imageButton:
                    //openDialog();
                    addEntryAction("sad");
                    increaseCount.increment(sadcount);
                    break;

                case R.id.fear_imageButton:
                    //openDialog();
                    addEntryAction("fear");
                    increaseCount.increment(fearcount);
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
