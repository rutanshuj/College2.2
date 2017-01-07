package com.example.admin.college20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class Categories_Frag extends Fragment {
    ImageView imageView1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories2, container, false);
        imageView1 = (ImageView) view.findViewById(R.id.arch);


        imageView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getContext(), CreateEvent1.class);
                startActivity(i);
            }
        });
        return view;

    }
}
