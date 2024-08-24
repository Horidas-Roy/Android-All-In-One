package com.horidas.bottomnavigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;
    FrameLayout container;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.nav_Home){

                    loadFragment(new HomeFragment(),false);

                } else if (id == R.id.nav_Search) {
                    loadFragment(new SearchFragment(),false);
                } else if (id == R.id.nav_Utilities) {
                     loadFragment(new UtilitiesFragment(),false);
                } else if (id == R.id.nav_Contact) {
                     loadFragment(new ContactFragment(),false);
                }else{ //profile
                    loadFragment(new ProfileFragment(),true);
                }
                return true; //for showing selected item
            }
        });

        bnView.setSelectedItemId(R.id.nav_Profile);

    }

    public void loadFragment(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.container,fragment);
        }else{
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}