package com.example.admin.college20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Categories_Frag extends Fragment implements View.OnClickListener {
    ImageView arch, art, business, literature, science, tech;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories2, container, false);
        arch = (ImageView) view.findViewById(R.id.arch);
        art = (ImageView) view.findViewById(R.id.artImg);
        business = (ImageView) view.findViewById(R.id.businessImg);
        literature = (ImageView) view.findViewById(R.id.literatureImg);
        science = (ImageView) view.findViewById(R.id.scienceImg);
        tech = (ImageView) view.findViewById(R.id.techImg);

        arch.setOnClickListener(this);
        art.setOnClickListener(this);
        business.setOnClickListener(this);
        literature.setOnClickListener(this);
        science.setOnClickListener(this);
        tech.setOnClickListener(this);
        return view;
    }
    public void onClick(View view){

        Intent i = new Intent(getActivity(), EventView.class);

        switch(view.getId()) {
            case R.id.arch:
                String architecture = "Architecture";
                i.putExtra("Category", architecture);
                break;
            case R.id.artImg:
                String art = "Art";
                i.putExtra("Category", art);
                break;
            case R.id.businessImg:
                String business = "Business";
                i.putExtra("Category", business);
                break;
            case R.id.literatureImg:
                String literature = "Literature";
                i.putExtra("Category", literature);
                break;
            case R.id.scienceImg:
                String science = "Science";
                i.putExtra("Category", science);
                break;
            case R.id.techImg:
                String technology = "Technology";
                i.putExtra("Category", technology);
                break;
        }
        startActivity(i);
    }

}
