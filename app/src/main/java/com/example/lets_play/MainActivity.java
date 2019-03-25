package com.example.lets_play;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //public static final String TAG = "Done";
    //    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
    //FirebaseFirestore db = FirebaseFirestore.getInstance();

   // private RecyclerView mPostList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mDatabase = FirebaseDatabase.getInstance().getReference().child("Post");

       /* mPostList = (RecyclerView) findViewById(R.id.post_list);
        mPostList.setHasFixedSize(true);
        mPostList.setLayoutManager(new LinearLayoutManager(this));*/
    }

    @Override
    protected void onStart() {
        super.onStart();

        //recyView();
    }

  //  private void recyView() {

//        Query query = FirebaseDatabase.getInstance().getReference().child("Post");
//        FirebaseRecyclerOptions<myPost> options = new FirebaseRecyclerOptions.Builder<myPost>()
//                .setQuery(query, new SnapshotParser<myPost>() {
//                    @NonNull
//                    @Override
//                    public myPost parseSnapshot(@NonNull DataSnapshot snapshot) {
//                        return new myPost(snapshot.child("title").getValue().toString(),
//                                snapshot.child("date").getValue().toString(),
//                                snapshot.child("time").getValue().toString(), snapshot.child("place").getValue().toString());
//                    }
//                }).build();
//
//        FirebaseRecyclerAdapter<myPost , PostViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<myPost, PostViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull myPost model) {
//                holder.setTitle(model.getTitle());
//                holder.setTime(model.getTime());
//                holder.setPlace(model.getPlace());
//                holder.setDate(model.getDate());
//            }
//
//            @NonNull
//            @Override
//            public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//                return null;
//            }
//        };
//    }
//
//    public static class PostViewHolder extends RecyclerView.ViewHolder{
//
//        View mView;
//
//        public PostViewHolder(@NonNull View itemView) {
//            super(itemView);
//            mView = itemView;
//        }
//
//        public void setTitle(String title){
//
//            TextView show_title = (TextView) mView.findViewById(R.id.show_title);
//            show_title.setText(title);
//        }
//
//        public void setPlace(String place){
//            TextView show_place = (TextView) mView.findViewById(R.id.show_place);
//            show_place.setText(place);
//        }
//
//        public void setTime(String time){
//            TextView show_time = (TextView) mView.findViewById(R.id.show_time);
//            show_time.setText(time);
//        }
//        public void setDate(String date){
//            TextView show_date = (TextView) mView.findViewById(R.id.show_date);
//            show_date.setText(date);
//        }
//
//    }

    //registration
       /* mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {            //To check if user has logged in or not
                if (firebaseAuth.getCurrentUser() == null) {
                    Intent loginIntent = new Intent(MainActivity.this, RegisterActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);   //user won't be able to go back
                    startActivity(loginIntent);
                }
            }
        };*/
        // Create a new user with a first and last name
        /*Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
*/
 /*   @Override
    protected void onStart() {
        super.onStart();

        //used to send user to the login page
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); //it returns null if user is  not logged in
        if(user == null){
            Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }


       startActivity(new Intent(MainActivity.this, LoginActivity.class));
        Intent loginIntent = new Intent(MainActivity.this, RegisterActivity.class);
        mAuth.addAuthStateListener(mAuthListener);
    }*/

    @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }
    @Override
        public boolean onOptionsItemSelected (MenuItem item){
            if (item.getItemId() == R.id.action_add) {
                startActivity(new Intent(MainActivity.this, PostActivity.class));
            }
            return super.onOptionsItemSelected(item);
        }
}