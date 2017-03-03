package com.example.admin.college20;


import android.app.ProgressDialog;

import android.content.Intent;

import android.graphics.Color;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
   private FirebaseAuth mAuth;
   private DatabaseReference mDatabaseUsers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("Users");
        mDatabaseUsers.keepSynced(true);

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

                checkLogin();
                }
        });
    }
    private void checkLogin() {
        String Email = mEmail.getText().toString().trim();
        String Password = mPassword.getText().toString().trim();

        if(!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Password)){
            progressDialog.setMessage("Signing In..");
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        progressDialog.dismiss();
                        checkUserExists();
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Error Logging In", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            Toast.makeText(MainActivity.this, "Please enter details", Toast.LENGTH_SHORT).show();

        }
    }

    private void checkUserExists() {
        final String user_id = mAuth.getCurrentUser().getUid();

        mDatabaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_id)){
                    Intent i = new Intent(MainActivity.this, MainPage1.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                }
                else{
                    Toast.makeText(MainActivity.this, "Hey bro, make an account", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
