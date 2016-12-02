package com.example.admin.college20;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rutanshu Jhaveri on 10/10/2016.
 */
public class RecyclerView_Frag extends Fragment {
    private List<Events_list> eventsList = new ArrayList<>();
    public RecyclerView recyclerView;
    private events_list_adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mAdapter = new events_list_adapter(eventsList);
        Context context = getActivity();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        return rootView;

    }

    private void prepareMovieData() {
        Events_list movie = new Events_list("Mad Max: Fury Road", "Action & Adventure", "2015");
        eventsList.add(movie);

        movie = new Events_list("Inside Out", "Animation, Kids & Family", "2015");
        eventsList.add(movie);

        movie = new Events_list("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        eventsList.add(movie);

        movie = new Events_list("Shaun the Sheep", "Animation", "2015");
        eventsList.add(movie);

        movie = new Events_list("The Martian", "Science Fiction & Fantasy", "2015");
        eventsList.add(movie);

        movie = new Events_list("Mission: Impossible Rogue Nation", "Action", "2015");
        eventsList.add(movie);

        movie = new Events_list("Up", "Animation", "2009");
        eventsList.add(movie);

        movie = new Events_list("Star Trek", "Science Fiction", "2009");
        eventsList.add(movie);

        movie = new Events_list("The LEGO Movie", "Animation", "2014");
        eventsList.add(movie);

        movie = new Events_list("Iron Man", "Action & Adventure", "2008");
        eventsList.add(movie);

        movie = new Events_list("Aliens", "Science Fiction", "1986");
        eventsList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
