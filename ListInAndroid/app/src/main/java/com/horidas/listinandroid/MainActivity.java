package com.horidas.listinandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    int[] arrNo = new int[]{1,2,3,4,5,6,7,8,9,10};
    ArrayList<String> arrNames = new ArrayList<>();
    Spinner spinner;
    ArrayList<String> arrIds = new ArrayList<>();
    AutoCompleteTextView acTxtView;
    ArrayList<String> arrLanguages = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        acTxtView = findViewById(R.id.acTxtView);

        arrNames.add("Horidas");
        arrNames.add("Roy");
        arrNames.add("Milon");
        arrNames.add("Apurbo");
        arrNames.add("Pronity");
        arrNames.add("Surovi");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    Toast.makeText(getApplicationContext(),"Click on First Item",Toast.LENGTH_LONG).show();
                }
            }
        });



        arrIds.add("National Id Card");
        arrIds.add("Voter Id Card");
        arrIds.add("Driving Id Card");
        arrIds.add("Ration Id Card");
        arrIds.add("Pan Id Card");
        arrIds.add("xth Id Card");
        arrIds.add("xiith Id Card");


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(spinnerAdapter);



        arrLanguages.add("Bangla");
        arrLanguages.add("English");
        arrLanguages.add("Hindi");
        arrLanguages.add("China");
        arrLanguages.add("Tamil");
        arrLanguages.add("Russian");

        ArrayAdapter<String> acTvAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrLanguages);
        acTxtView.setAdapter(acTvAdapter);
    }
}