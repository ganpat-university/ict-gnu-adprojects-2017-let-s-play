package com.example.lets_play;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
public class LoginActivity extends AppCompatActivity {
    private EditText mLoginEmailField;
    private EditText mLoginPasswordField;
    private Button mLoginBtn;
    private Button mRegBtn;
    private ProgressBar mLoginProgress;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        //mDatabase mDa= FirebaseAuth.getInstance().getReferace().child("Users");
        mLoginEmailField = (EditText) findViewById(R.id.loginPasswordField);
        mLoginEmailField = (EditText) findViewById(R.id.loginEmailField);
        mLoginBtn = (Button) findViewById(R.id.loginBtn);
        mRegBtn = (Button) findViewById(R.id.regbtn);
        mLoginProgress = (ProgressBar) findViewById(R.id.progressBar);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mLoginEmailField.getText().toString();
                String password = mLoginPasswordField.getText().toString();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    mLoginProgress.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task){
                            if(task.isSuccessful()){
                                sentToMain();
                            }else{
                                String errorMsg = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this, "Error : " + errorMsg, Toast.LENGTH_LONG).show();
                            }
                            mLoginProgress.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        });
    }

    //check if user is logged in or not
    @Override
    protected void onStart() {
        super.onStart();
        //get current user status
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //check user is loggened or not
        //IF USER IS LOGGED IN THAN SEND TO mainActivity
        if (currentUser != null) {
            sentToMain();
        }
    }

    private void sentToMain() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
    /* private void checkLogin() {
        String email = mLoginEmailField.getText().toString().trim();
        String password = mLoginPasswordField.getText().toString().trim();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            checkUserExist(email,password);
           /* mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if () {
                        if (task.isSuccessful()) {
                            checkUserExist();

                        } else {
                            Toast.makeText(LoginActivity.this, "Error Login", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }
    }*/
        /*   private void checkUserExist(String e,String p) {
                if(e=="harsh@gmail.com" && p =="12345"){
                    Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);
                }

           }
               String user_id = mAuth.getCurrentUser().getUid();
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.hasChild(user_id)){
                            Intent mainIntent =new Intent(LoginActivity.this,MainActivity.class);
                            mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivities(mainIntent);


                        } else{

                            Toast.makeText(LoginActivity.this,"You need to setup your account.",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        }

    }*/