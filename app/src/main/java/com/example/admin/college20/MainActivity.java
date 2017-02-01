package com.example.admin.college20;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText mEmail;
    private EditText mPassword;
    private Button mLoginButton, mSignUpButton;
    private ProgressDialog progressDialog;
   // private FirebaseAuth mAuth;
   // private DatabaseReference mDatabaseUsers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        //mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("Users");
        //mDatabaseUsers.keepSynced(true);

        mEmail = (EditText) findViewById(R.id.mpEmail);
        mPassword = (EditText) findViewById(R.id.mpPassword);
        mLoginButton = (Button) findViewById(R.id.signIn);
        mSignUpButton = (Button) findViewById(R.id.sign_up);

        mLoginButton.setVisibility(View.VISIBLE);
        mLoginButton.setBackgroundColor(Color.TRANSPARENT);

        mSignUpButton.setVisibility(View.VISIBLE);
        mSignUpButton.setBackgroundColor(Color.TRANSPARENT);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainPage1.class );
                startActivity(i);
                //checkLogin();
                }
        });
    }
}
