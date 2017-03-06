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
        Toast.makeText(getContext(), "Button Clicked !!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getActivity(), EventView.class);

        switch(view.getId()) {
            case R.id.arch:
                String arch = "Architecture";
                i.putExtra("Arch", arch);

            case R.id.artImg:
                String art = "Art";
                i.putExtra("Art", art);

            case R.id.businessImg:
                String business = "Business";
                i.putExtra("Business", business);

            case R.id.literatureImg:
                String lit = "Literature";
                i.putExtra("Literature", lit);

            case R.id.scienceImg:
                String science = "Science";
                i.putExtra("Science", science);

            case R.id.techImg:
                String tech = "Tech";
                i.putExtra("Technology", tech);
        }
        startActivity(i);
    }

}
