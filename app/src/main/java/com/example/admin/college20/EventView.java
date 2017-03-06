package com.example.admin.college20;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class EventView extends AppCompatActivity {

    DatabaseReference databaseReference;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("ApprovedEvents");
        recyclerView = (RecyclerView) findViewById(R.id.request_EventList);

        //Avoid unnecessary layout passes by setting setHasFixedSize to true
        recyclerView.setHasFixedSize(true);

        //Select the type of layout manager you would use for your recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        final String event_cat  = getIntent().getStringExtra("Category");

        FirebaseRecyclerAdapter<Event, RequestViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Event, RequestViewHolder>(
                Event.class,
                R.layout.events_list_row,
                RequestViewHolder.class,
                databaseReference.orderByChild("category").equalTo(event_cat)
        ) {
            @Override
            protected void populateViewHolder(RequestViewHolder viewHolder, Event model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setCategory(model.getCategory());
                viewHolder.setLocation(model.getLocation());
                viewHolder.setPrice(model.getPrice());
                viewHolder.setImageUrl(getApplicationContext(), model.getImageUrl());

                viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(EventView.this, "Image Selected", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public static class RequestViewHolder extends RecyclerView.ViewHolder {
        View mView;
        ImageView imageButton;

        public RequestViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            imageButton = (ImageView) mView.findViewById(R.id.request_image);
        }

        public void setTitle(String title) {
            TextView a_title = (TextView) mView.findViewById(R.id.request_title);
            a_title.setText(title);
        }

        public void setDesc(String desc) {
            TextView a_desc = (TextView) mView.findViewById(R.id.request_desc);
            a_desc.setText(desc);
        }

        public void setLocation(String location) {
            TextView a_desc = (TextView) mView.findViewById(R.id.request_location);
            a_desc.setText(location);
        }

        public void setCategory(String category) {
            TextView a_category = (TextView) mView.findViewById(R.id.request_category);
            a_category.setText(category);
        }

        public void setPrice(String price) {
            TextView a_price = (TextView) mView.findViewById(R.id.request_price);
            a_price.setText(price);
        }

        public void setImageUrl(Context ctx, String imageUrl) {
            ImageView a_image = (ImageView) mView.findViewById(R.id.request_image);
            Picasso.with(ctx).load(imageUrl).into(a_image);
        }
    }
}
