package com.example.admin.college20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

public class EventDetails extends AppCompatActivity {
    ImageView eventImage;
    TextView title1, desc1, location1, category1, price1,
            start_date1, end_date1, start_time1, end_time1, fblink1, weblink1, contact1, club1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        eventImage = (ImageView) findViewById(R.id.eventImage_detailsPage);
        desc1 = (TextView) findViewById(R.id.request_desc);
        title1 = (TextView) findViewById(R.id.request_title_d);
        location1 = (TextView) findViewById(R.id.request_location);
        category1 = (TextView) findViewById(R.id.request_category_d);
        price1 = (TextView) findViewById(R.id.request_price);
        start_date1 = (TextView) findViewById(R.id.start_date);
        end_date1 = (TextView) findViewById(R.id.end_date);
        start_time1 = (TextView) findViewById(R.id.start_time);
        end_time1 = (TextView) findViewById(R.id.end_time);
        club1 = (TextView) findViewById(R.id.request_club_d);
        weblink1 = (TextView) findViewById(R.id.request_weblink);
        fblink1 = (TextView) findViewById(R.id.request_fblink);
        contact1 = (TextView) findViewById(R.id.request_contact);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarEventDetails);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent intent = getIntent();
        final String desc = intent.getStringExtra("desc");
        final String imageUrl = intent.getStringExtra("imageUrl");
        final String title = intent.getStringExtra("title");
        final String start_date = intent.getStringExtra("start_date");
        final String end_date = intent.getStringExtra("end_date");
        final String start_time = intent.getStringExtra("start_time");
        final String end_time = intent.getStringExtra("end_time");
        final String club = intent.getStringExtra("club");
        final String category = intent.getStringExtra("category");
        final String price = intent.getStringExtra("price");
        final String location = intent.getStringExtra("location");
        final String fblink = intent.getStringExtra("fblink");
        final String weblink = intent.getStringExtra("weblink");
        final String contact = intent.getStringExtra("contact");

        desc1.setText(desc);
        title1.setText(title);
        location1.setText(location);
        category1.setText(category);
        price1.setText(price);
        club1.setText(club);
        start_date1.setText(start_date);
        end_date1.setText(end_date);
        start_time1.setText(start_time);
        end_time1.setText(end_time);
        fblink1.setText(fblink);
        weblink1.setText(weblink);
        contact1.setText(contact);

        Picasso.with(getApplicationContext()).load(imageUrl).into(eventImage);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.eventdetails, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_back:
                Intent action_back = new Intent(EventDetails.this, EventView.class);
                startActivity(action_back);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
