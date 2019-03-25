package com.example.lets_play;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
   private EditText nNameField;
    private EditText nEmailField;
    private EditText nPasswordField;

    private Button mRegisterBtn;

  /*  private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;*/

    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       //mAuth = FirebaseAuth.getInstance();
        //mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        nNameField = (EditText) findViewById(R.id.editText_Name1);
        nEmailField = (EditText) findViewById(R.id.editText_Email);
        nPasswordField = (EditText) findViewById(R.id.editText_Password);
        mRegisterBtn = (Button) findViewById(R.id.btn_register) ;

        mProgress = new ProgressDialog(this);


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegister();
            }
        });

    }

    private void startRegister() {
        final String name = nNameField.getText().toString().trim();
        String email = nEmailField.getText().toString().trim();
        String password = nPasswordField.getText().toString().trim();

        //if not empty
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email)&& !TextUtils.isEmpty(password) )
        {
            mProgress.setMessage("Signing Up... ");
            mProgress.show();
           /* mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //returns result of field
                    if(task.isSuccessful()){
                        String user_id = mAuth.getCurrentUser().getUid();   //current logined user
                        DatabaseReference current_user_db = mDatabase.child(user_id);
                        current_user_db.child("name").setValue(name);
                        mProgress.dismiss();

                        Intent mainIntent = new Intent(RegisterActivity.this , MainActivity.class);
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mainIntent);
                    }
                }
           });*/

            mProgress.dismiss();
            Intent mainIntent = new Intent(RegisterActivity.this,MainActivity.class);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainIntent);
        }
    }
}
