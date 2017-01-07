package com.example.admin.college20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateEvent3 extends AppCompatActivity {
    private EditText mEventDesc, mEventFBUrl, mEventWebLink;
    private Button upload_image_button, done_button;
    private static final int GALLERY_INTENT = 1;
    private String event_desc, event_weblink, event_fb_url;
    private ProgressDialog progressDialog;


    DatabaseReference mDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event3);

        mEventDesc = (EditText) findViewById(R.id.event_desc);
        mEventFBUrl = (EditText) findViewById(R.id.fb_event_url);
        mEventWebLink = (EditText) findViewById(R.id.event_weblink);
        upload_image_button = (Button) findViewById(R.id.upload_image_button);
        done_button = (Button) findViewById(R.id.done_button);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Event");
        progressDialog = new ProgressDialog(this);

        event_desc = mEventDesc.getText().toString().trim();
        event_weblink = mEventWebLink.getText().toString().trim();
        event_fb_url = mEventFBUrl.getText().toString().trim();

        upload_image_button.setVisibility(View.VISIBLE);
        upload_image_button.setBackgroundColor(Color.TRANSPARENT);

        upload_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);
            }
        });

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(event_desc.length()==0 &&
                        event_weblink.length() == 0 &&
                        event_fb_url.length() == 0
                        ){
                    startPosting();

                    Intent i = new Intent(CreateEvent3.this, MainPage1.class);
                    startActivity(i);
                }
            }
        });



    }

    private void startPosting() {

        progressDialog.setMessage("Uploading");
        progressDialog.show();
        Bundle bundle = getIntent().getExtras();
        final String event_title = bundle.getString("title");
        final String event_location = bundle.getString("location");
        final String event_category = bundle.getString("category");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                DatabaseReference databaseReference = mDatabaseReference.push();
                databaseReference.child("Event Title").setValue(event_title);
                databaseReference.child("Event Location").setValue(event_location);
                databaseReference.child("Event Category").setValue(event_category);
                databaseReference.child("Event Description").setValue(event_desc);
                databaseReference.child("Event Weblink").setValue(event_weblink);
                databaseReference.child("Event FB").child(event_fb_url);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
