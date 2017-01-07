package com.example.admin.college20;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CreateEvent1 extends android.support.v4.app.Fragment {

    private Button uButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_empty1, container, false);

        uButton = (Button) view.findViewById(R.id.getStarted);
        uButton.setVisibility(View.VISIBLE);
        uButton.setBackgroundColor(Color.TRANSPARENT);

        uButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i  = new Intent(getContext(), CreateEvent2.class);
                startActivity(i);

            }
        });

        return view;
    }
}
