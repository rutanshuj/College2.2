package com.example.admin.college20;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rutanshu Jhaveri on 10/10/2016.
 */
public class events_list_adapter extends RecyclerView.Adapter<events_list_adapter.MyViewHolder>{
    private List<Events_list> eventsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
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
        holder.genre.setText(events.getGenre());
        holder.year.setText(events.getYear());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}

