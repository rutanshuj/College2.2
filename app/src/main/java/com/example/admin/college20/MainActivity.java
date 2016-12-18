package com.example.admin.college20;


import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    //Firebase ref = new Firebase("https://collegerama-d9037.firebaseio.com/");
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Firebase.setAndroidContext(this);

        Button sign_up = (Button) findViewById(R.id.signUp);
        sign_up.setVisibility(View.VISIBLE);
        sign_up.setBackgroundColor(Color.TRANSPARENT);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), MainPage1.class);
                startActivity(i);
            }
        });
    }
    //comment

//    public void signup(View v)
//    {
//        Intent i=new Intent();
//        i.setClass(this,SignUpP1.class);
//        startActivity(i);
//    }
}
