package com.example.lets_play;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PostActivity extends AppCompatActivity {
    private EditText mPostTitle;
    private EditText mPostPlace;
    private Button nSubmitButton;

    private StorageReference mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mStorage = FirebaseStorage.getInstance().getReference();
        mPostTitle = (EditText) findViewById(R.id.editText_Game_name);
        mPostPlace = (EditText) findViewById(R.id.editText_Place);
        nSubmitButton = (Button) findViewById(R.id.bt_Post);

        nSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();
            }
        });
    }

    private void startPosting() {
        String title_val = mPostTitle.getText().toString().trim();
        String place_val = mPostPlace.getText().toString().trim();

        if(!TextUtils.isEmpty(title_val)&& !TextUtils.isEmpty(place_val))
        {


        }
    }

    ;
}




