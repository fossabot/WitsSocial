package com.example.witssocial_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private RecyclerView recyclerView;
    private home_adapter mainAdapter;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();



        recyclerView = (RecyclerView) findViewById(R.id.recyclerProfile);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Post> options = new FirebaseRecyclerOptions.Builder<Post>().setQuery(FirebaseDatabase.getInstance().getReference().child("All Posts"),Post.class).build();
        recyclerView.getRecycledViewPool().clear();
        mainAdapter= new home_adapter(options);
        recyclerView.setAdapter(mainAdapter);

        Button mess = findViewById(R.id.OtherProfileMessageButton);

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        String user = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();

        TextView emailText = findViewById(R.id.userEmail);
        emailText.setText(email);

        TextView userId = findViewById(R.id.userUsername);
        userId.setText(user);

        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, InsideMessage.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

}