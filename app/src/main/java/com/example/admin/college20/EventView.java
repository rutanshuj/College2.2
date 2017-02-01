package com.example.admin.college20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

public class EventView extends AppCompatActivity {

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);


        databaseReference.getDatabase().getReference();

        Bundle bundle = getIntent().getExtras();

    }
}
