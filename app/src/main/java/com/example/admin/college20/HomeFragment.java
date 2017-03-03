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
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  HomeFragment extends Fragment {
    public View homeView;
    //Button bttn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        homeView = inflater.inflate(R.layout.activity_home_fragment, null);
        //bttn = (Button) findViewById(R.id.button);



        Categories_Frag categoriesFrag = new Categories_Frag();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.home_CategoriesFrag, categoriesFrag);
        fragmentTransaction.commit();

        return homeView;
    }
}
