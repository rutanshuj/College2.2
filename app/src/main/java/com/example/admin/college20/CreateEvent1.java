package com.example.admin.college20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateEvent1 extends AppCompatActivity {
    private EditText mEventTitle, mEventCategory, mContact;
    Spinner spinner;

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event1);

        spinner = (Spinner) findViewById(R.id.spinnerCategory);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Categories, android.R.layout.simple_spinner_item);

        //Specify the layout to use when the spinner appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        mEventTitle = (EditText) findViewById(R.id.event_title);
        mEventCategory = (EditText) findViewById(R.id.event_category);
        mContact = (EditText) findViewById(R.id.contact_info);
        next = (Button) findViewById(R.id.nextButton0);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String event_title = mEventTitle.getText().toString().trim();
                final String contact = mContact.getText().toString().trim();
                final String club = spinner.getSelectedItem().toString();
                final String category = mEventCategory.getText().toString().trim();

                if (!TextUtils.isEmpty(event_title)
                        && !TextUtils.isEmpty(contact)
                        && !TextUtils.isEmpty(club)) {

                    SharedPreferences sp = getSharedPreferences("preference", Context.MODE_WORLD_READABLE);
                    SharedPreferences.Editor preferences = sp.edit();
                    preferences.putString("title", event_title);
                    preferences.putString("club", club);
                    preferences.putString("contact", contact);
                    preferences.putString("category", category);
                    preferences.commit();
                    Intent i = new Intent(CreateEvent1.this, CreateEvent2.class);
                    startActivity(i);
                }
            }
        });
    }
}
