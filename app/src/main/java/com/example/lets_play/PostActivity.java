package com.example.lets_play;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.sql.Time;

public class PostActivity extends AppCompatActivity {
    private EditText mPostTitle;
    private EditText mPostPlace;
    private EditText mPostTime;
    private EditText mPostDate;
    private Button nSubmitButton;
    private ProgressDialog mProgress;
    private Uri filepath;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mPostTitle = (EditText) findViewById(R.id.editText_Game_name);
        mPostPlace = (EditText) findViewById(R.id.editText_Place);
        mPostTime = (EditText) findViewById(R.id.editText_Time);
        mPostDate = (EditText) findViewById(R.id.editText_Date);
        nSubmitButton = (Button) findViewById(R.id.bt_Post);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Post");

        mProgress = new ProgressDialog(this);
        nSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();
            }
        });
    }

    private void startPosting() {
        mProgress.setMessage("Posting ...");
        mProgress.show();
        String title_val = mPostTitle.getText().toString().trim();
        String place_val = mPostPlace.getText().toString().trim();
        String time_val = mPostTime.getText().toString().trim();
        String date_val = mPostDate.getText().toString().trim();

        if(!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(place_val) && !TextUtils.isEmpty(time_val))
        {
            DatabaseReference newPost = mDatabase.push();
            newPost.child("title").setValue(title_val);
            newPost.child("place").setValue(place_val);
            newPost.child("time").setValue(time_val);
            newPost.child("date").setValue(date_val);
        }
        mProgress.dismiss();
        //back to main page
        startActivity(new Intent(PostActivity.this,MainActivity.class));
    }
    /* private EditText mPostTitle;
    private EditText mPostPlace;
    private EditText mPostTime;
    private Button nSubmitButton;

    private ProgressDialog mProgress;
   // private StorageReference mStorage;

   // private Uri filepath;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        //mStorage = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Post");

        mPostTitle = (EditText) findViewById(R.id.editText_Game_name);
        mPostPlace = (EditText) findViewById(R.id.editText_Place);
        mPostTime = (EditText) findViewById(R.id.editText_Time);
        nSubmitButton = (Button) findViewById(R.id.bt_Post);

        mProgress = new ProgressDialog(this);

        nSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();
            }
        });
    }

    private void startPosting() {

        mProgress.setMessage("Posting ...");
        mProgress.show();
        String title_val = mPostTitle.getText().toString().trim();
        String place_val = mPostPlace.getText().toString().trim();
        String time_val = mPostTime.getText().toString().trim();

        if(!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(place_val) && !TextUtils.isEmpty(time_val))
        {
           // StorageReference filepath = mStorage.child("Post").child("sPost");

            DatabaseReference newPost = mDatabase.push();
            newPost.child("title").setValue(title_val);
            newPost.child("place").setValue(place_val);
            newPost.child("time").setValue(time_val);
            mProgress.dismiss();
        }
    }
*/
}




