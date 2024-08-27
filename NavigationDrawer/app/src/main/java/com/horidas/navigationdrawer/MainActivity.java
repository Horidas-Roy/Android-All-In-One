package com.horidas.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        //step 1
        setSupportActionBar(toolbar);

        //step 2
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.open_drawer,R.string.closed_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(new HomeFragment(),true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    int id = item.getItemId();

                    if (id == R.id.optNotes){
                           loadFragment(new NotesFragment(),false);
                    }else if(id == R.id.optSetting){
                            loadFragment(new NotesFragment(),false);
                    }else{ //setting
                            loadFragment(new HomeFragment(),false);
                    }

                    drawerLayout.closeDrawer(GravityCompat.START);

                    return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //for passing data in fragments
        Bundle bundle = new Bundle();
        bundle.putString("name","Horidas");
        bundle.putInt("Age",24);
        fragment.setArguments(bundle);
        //============================


        if(flag){
            ft.add(R.id.container,fragment);
        }else{
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}