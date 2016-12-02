package com.example.admin.college20;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    //Firebase ref = new Firebase("https://collegerama-d9037.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Firebase.setAndroidContext(this);

    }

//    public void signup(View v)
//    {
//        Intent i=new Intent();
//        i.setClass(this,SignUpP1.class);
//        startActivity(i);
//    }



    public void signin(View view) {
        Intent i =new Intent(this, MainPage1.class);
        i.setClass(this, MainPage1.class);
        startActivity(i);
//        final ProgressDialog progress = new ProgressDialog(this);
//        progress.setTitle("Logging In");
//        progress.setMessage("Setting Up Profile");
//        long delay = 5000;
//        progress.show();

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                progress.dismiss();
//
//            }
//        }, delay);
    }
}
