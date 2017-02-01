package com.example.admin.college20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateEvent2 extends AppCompatActivity {

    private EditText mEventTitle, mEventLocation, mEventCategory, mContact;
    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event2);

        mEventTitle = (EditText) findViewById(R.id.event_title);
        mEventLocation = (EditText) findViewById(R.id.event_location);
        mEventCategory = (EditText) findViewById(R.id.event_category);
        mContact = (EditText) findViewById(R.id.contact_info);
        mNextButton = (Button) findViewById(R.id.nextButton);

        final String event_title = mEventTitle.getText().toString().trim();
        final String event_location = mEventLocation.getText().toString().trim();
        final String event_category = mEventCategory.getText().toString().trim();
        final String contact = mContact.getText().toString().trim();

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**if (!TextUtils.isEmpty(event_title)
                        && !TextUtils.isEmpty(event_location)
                        && !TextUtils.isEmpty(event_category)
                        && !TextUtils.isEmpty(contact)) {**/

                    Intent i = new Intent(CreateEvent2.this, CreateEvent3.class);
                    i.putExtra("title", event_title);
                    i.putExtra("location", event_location);
                    i.putExtra("category", event_category);
                    i.putExtra("contact", contact);
                    startActivity(i);
                }


        });
    }
}
