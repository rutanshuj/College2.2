package com.example.admin.college20;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rutanshu Jhaveri on 10/10/2016.
 */
public class events_list_adapter extends RecyclerView.Adapter<events_list_adapter.MyViewHolder>{
    private List<Events_list> eventsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, time_and_date, cat_label;
        public ImageView event_Img;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            cat_label = (TextView) view.findViewById(R.id.cat_label);
            time_and_date = (TextView) view.findViewById(R.id.time_and_date);
            event_Img = (ImageView) view.findViewById(R.id.event_Img);
        }
    }

    public events_list_adapter(List<Events_list> eventsList) {
        this.eventsList = eventsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Events_list events = eventsList.get(position);
        holder.title.setText(events.getTitle());
        holder.cat_label.setText(events.getCat_label());
        holder.time_and_date.setText(events.getTime_and_date());
        holder.event_Img.setBackgroundResource(events.getImage());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}

