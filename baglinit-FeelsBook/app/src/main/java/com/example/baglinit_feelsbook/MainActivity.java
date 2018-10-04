package com.example.baglinit_feelsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    //Declare variable of my activity

    private IncreaseCount increaseCount = new IncreaseCount();
    private ImageButton love_imageButton;
    private ImageButton joy_imageButton;


    private TextView lovecount;
    private TextView joycount;

    private EditText comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variable after set content (i.e. after main screen is establishedd
        comment = findViewById(R.id.comment);
        love_imageButton= findViewById(R.id.love_imageButton);
        love_imageButton.setOnClickListener(listener);
        lovecount = findViewById(R.id.lovecount);


        joy_imageButton = findViewById(R.id.joy_imageButton);
        joy_imageButton.setOnClickListener(listener);
        joycount = findViewById(R.id.joycount);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);

    }



    private View.OnClickListener listener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.love_imageButton:
                   // openDialog();

                    increaseCount.increment(lovecount);
                    break;
                case R.id.joy_imageButton:
                    //openDialog();

                    increaseCount.increment(joycount);
                    break;
            }

        }
    };

//    private void openDialog(){
//
//        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
//        View mView = getLayoutInflater().inflate(R.layout.layout_dialog, null);
//        final EditText meditTextComment = (EditText) mView.findViewById(R.id.editTextcomment);
//
//        Button mComment = (Button) mView.findViewById(R.id.comment);
//        Button mNoComment = (Button) mView.findViewById(R.id.nocomment);
//
//        mComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                comment = meditTextComment.getText().toString();
//                //comment.setText(meditTextComment.getText().toString();
//                //Add comment automaticall here to take affect like above
//
//                //Similar to lonely twitter set these funcitons after comment is confirmed
//                //String comment = bodyText.getText().tosString();
//                //commmentlist.add(comment);
////                saveButton.setOnClickListener(new View.OnClickListener() {
////
////                    public void onClick(View v) {
////                        setResult(RESULT_OK);
////                        String text = bodyText.getText().toString();
////
////                        Tweet tweet = new NormalTweet(text);
////                    tweetList.add(tweet);
////                    adapter.notifyDataSetChanged();
////                    saveInFile()
//
////BASICALLY AFTER COMMENT IS CONFIRMED (AFTER COMMENT IS CLICKED, ADD EVERYTHING TO THE LIST)
//                //CREATE LIST VIEW NOW
//            }
//        });
//
//        mNoComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                comment ="No comment";
//            }
//        });
//
//        mBuilder.setView(mView);
//        AlertDialog dialog = mBuilder.create();
//        dialog.show();
//    }


}
