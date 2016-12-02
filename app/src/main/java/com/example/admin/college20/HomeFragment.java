package com.example.admin.college20;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    View homeView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        homeView = inflater.inflate(R.layout.activity_home_fragment, null);

        Categories_Frag categoriesFrag = new Categories_Frag();
        RecyclerView_Frag recyclerView_frag = new RecyclerView_Frag();


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.home_CategoriesFrag, categoriesFrag);
        fragmentTransaction.commit();

        return homeView;
    }
}
