package com.example.witssocial_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class friendProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_profile);

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        String user = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();

        TextView emailText = findViewById(R.id.fpUsername);
        emailText.setText(email);

//        TextView userId = findViewById(R.id.userUsername);
//        userId.setText(user);

    }
}