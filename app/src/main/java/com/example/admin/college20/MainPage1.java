package com.example.admin.college20;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class MainPage1 extends AppCompatActivity {
    NavigationView mp1NavigationView;
    DrawerLayout mp1NavigationLayout;
    FragmentManager mp1FragmentManager;
    FragmentTransaction mp1FragmentTransaction;
    Toolbar mp1_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page1);

        mp1_toolbar = (Toolbar) findViewById(R.id.toolbar_mp1);
        mp1NavigationLayout = (DrawerLayout) findViewById(R.id.mainPage1DrawerLayout);
        mp1NavigationView = (NavigationView) findViewById(R.id.mainPage1DrawerView);


        /**
         * Get Fragment Manager and replace your frame layout with the fragment that you wish to
          replace it with
         */

        mp1FragmentManager = getSupportFragmentManager();
        mp1FragmentTransaction = mp1FragmentManager.beginTransaction();
        mp1FragmentTransaction.replace(R.id.containerToBeFilled, new mp1_SwipeTab()).commit();

        /** After getting the particular fragment you can now set your Navigation View Adapter
         * and Listener
         */

        mp1NavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mp1NavigationLayout.closeDrawers();
                if (item.getItemId() == R.id.Home){
                    FragmentTransaction fragmentTransaction = mp1FragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerToBeFilled, new mp1_SwipeTab()).commit();
                }

            return false;
            }
        });

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_mp1);
        ActionBarDrawerToggle mp1_DrawerToggle = new ActionBarDrawerToggle(this,mp1NavigationLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mp1NavigationLayout.setDrawerListener(mp1_DrawerToggle);

        mp1_DrawerToggle.syncState();

        mp1_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SearchUniActivity.class);
                i.setClass(getApplicationContext(), SearchUniActivity.class);
                startActivity(i);
            }
        });

    }


}
