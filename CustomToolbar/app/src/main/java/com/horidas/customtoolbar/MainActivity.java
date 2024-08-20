package com.horidas.customtoolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolBar = findViewById(R.id.toolBar);

        //step 1
        setSupportActionBar(toolBar);

        //step 2
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Toolbar");
//            getSupportActionBar().setSubtitle("SubTitle"); //we can set both place
        }

//      toolBar.setTitle("My Toolbar"); //due to lowest priority setTitle doesn't work here
        toolBar.setSubtitle("Sub Title");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.opt_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        
        if(itemId == R.id.new_opt){
            Toast.makeText(this, "Create New File", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.openMenuBtn) {
            Toast.makeText(this, "Open File", Toast.LENGTH_SHORT).show();
        } else if (itemId == android.R.id.home) {
            super.onBackPressed();
        }else {
            Toast.makeText(this, "Save File", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}