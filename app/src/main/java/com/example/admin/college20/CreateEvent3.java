package com.example.admin.college20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class CreateEvent3 extends AppCompatActivity {
    private EditText mEventDesc, mEventFBUrl, mEventWebLink;
    private TextView hello;
    private Button upload_image_button, done_button;


    private ProgressDialog progressDialog;
    private static final int GALLERY_INTENT = 1;
    private Uri imageUri = null;

    private DatabaseReference mDatabaseReference;
    private StorageReference mStorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event3);

        mEventDesc = (EditText) findViewById(R.id.event_desc);
        mEventFBUrl = (EditText) findViewById(R.id.fb_event_url);
        mEventWebLink = (EditText) findViewById(R.id.event_weblink);
        upload_image_button = (Button) findViewById(R.id.upload_image_button);
        done_button = (Button) findViewById(R.id.done_button);
        hello = (TextView) findViewById(R.id.hello);

        mDatabaseReference = FirebaseDatabase.
                getInstance().
                getReference().
                child("Event");
        mStorageRef = FirebaseStorage.getInstance().getReference();

        progressDialog = new ProgressDialog(this);

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
                startPosting();
                Toast.makeText(CreateEvent3.this, "Button Selected", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void startPosting() {

        progressDialog.setMessage("Uploading the Data");

        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        final String event_title = getIntent().getStringExtra("title");
        final String event_location = getIntent().getStringExtra("location");
        final String event_category = getIntent().getStringExtra("category");
        final String contact = getIntent().getStringExtra("contact");

        final String event_desc = mEventDesc.getText().toString().trim();
        final String event_weblink = mEventWebLink.getText().toString().trim();
        final String event_fb_url = mEventFBUrl.getText().toString().trim();

        Log.d("Event Tile", event_title);
        Log.d("Event Location", event_location);
        Log.d("Event Category", event_category);
        hello.setText(event_title);

        if (!TextUtils.isEmpty(event_desc)
                && !TextUtils.isEmpty(event_weblink)
                && !TextUtils.isEmpty(event_fb_url)
                && imageUri != null) {
            progressDialog.show();

            StorageReference filepath = mStorageRef.child("Images").child(imageUri.getLastPathSegment());

            filepath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri uri = taskSnapshot.getDownloadUrl();

                    DatabaseReference newEvent = mDatabaseReference.push();
                    newEvent.child("title").setValue(event_title);
                    newEvent.child("location").setValue(event_location);
                    newEvent.child("category").setValue(event_category);
                    newEvent.child("contact").setValue(contact);
                    newEvent.child("desc").setValue(event_desc);
                    newEvent.child("web").setValue(event_weblink);
                    newEvent.child("fb").setValue(event_fb_url);
                    newEvent.child("imageUrl").setValue(uri.toString());

                    progressDialog.dismiss();
                    startActivity(new Intent(CreateEvent3.this, MainPage1.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(CreateEvent3.this, "Upload Failed :(", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Toast.makeText(this, "Fill in the details", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {
            imageUri = data.getData();
        }
    }

}

