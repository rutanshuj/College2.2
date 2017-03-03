package com.example.admin.college20;

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

public class uMainPage extends AppCompatActivity {
    NavigationView u_navigationView;
    DrawerLayout u_drawerLayout;
    Toolbar u_toolbar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_main_page);

        u_toolbar = (Toolbar) findViewById(R.id.u_toolbar);
        u_drawerLayout = (DrawerLayout) findViewById(R.id.u_DrawerLayout);
        u_navigationView = (NavigationView) findViewById(R.id.u_NavView);

        CreateEvent createEvent = new CreateEvent();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.u_container, createEvent);
        fragmentTransaction.commit();

        u_navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                u_drawerLayout.closeDrawers();
                if(item.getItemId() == R.id.u_home){

                }
                if(item.getItemId() == R.id.u_sales){

                }
                if(item.getItemId() == R.id.u_integrations){

                }

                return false;
            }
        });

        u_toolbar = (Toolbar) findViewById(R.id.u_toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,u_drawerLayout, u_toolbar,R.string.app_name,
                R.string.app_name);
        actionBarDrawerToggle.syncState();
    }
}

