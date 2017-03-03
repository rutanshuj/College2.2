package com.example.admin.college20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CreateEvent3 extends AppCompatActivity {
    EditText mEventLocation, mFBLink, mWebLink;
    Button nextButton2;

    DatabaseReference databaseReference;
    StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event3);

        mEventLocation = (EditText) findViewById(R.id.event_loca_eT);
        mFBLink = (EditText) findViewById(R.id.facebook_link_eT);
        mWebLink = (EditText) findViewById(R.id.web_link_eT);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Event");
        mStorageRef = FirebaseStorage.getInstance().getReference();

        nextButton2 = (Button) findViewById(R.id.nextButton2);

        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(mEventLocation.getText().toString())
                        && !TextUtils.isEmpty(mFBLink.getText().toString())
                        && !TextUtils.isEmpty(mWebLink.getText().toString())){

                Intent i = new Intent(CreateEvent3.this, CreateEvent4.class);
                final String event_location = mEventLocation.getText().toString().trim();
                final String FbLink = mEventLocation.getText().toString().trim();
                final String WebLink = mWebLink.getText().toString().trim();

                i.putExtra("location", event_location);
                i.putExtra("fblink", FbLink);
                i.putExtra("weblink", WebLink);

                startActivity(i);
                }
            }
        });
    }

}
