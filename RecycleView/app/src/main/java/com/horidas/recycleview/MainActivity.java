package com.horidas.recycleview;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;
    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    FloatingActionButton btnOpenDialog;
    RecyclerContactAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recycleView = findViewById(R.id.recycleView);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);

                EditText edName = dialog.findViewById(R.id.edName);
                EditText edNumber = dialog.findViewById(R.id.edNumber);
                Button addContactBtn = dialog.findViewById(R.id.addContactBtn);

                addContactBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", number = "";

                        if(!edName.getText().toString().isEmpty()){
                            name = edName.getText().toString();
                        }else{
                            Toast.makeText(MainActivity.this, "Please enter your name!", Toast.LENGTH_SHORT).show();
                            edName.setError("Enter your name!!");
                        }

                        if (!edNumber.getText().toString().isEmpty()){
                           number = edNumber.getText().toString();
                        }else{
                            Toast.makeText(MainActivity.this, "Please enter your number!", Toast.LENGTH_SHORT).show();
                            edName.setError("Enter your number!!");
                        }

                        arrContacts.add(new ContactModel(R.drawable.f,name,number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recycleView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        recycleView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.a,"A","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.b,"B","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.c,"C","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.d,"D","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.e,"E","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.f,"F","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.g,"G","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.h,"H","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.i,"I","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.j,"J","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.k,"K","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.a,"A","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.b,"B","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.c,"C","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.d,"D","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.e,"E","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.f,"F","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.g,"G","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.h,"H","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.i,"I","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.j,"J","01758734050"));
        arrContacts.add(new ContactModel(R.drawable.k,"K","01758734050"));

        adapter = new RecyclerContactAdapter(this,arrContacts);
        recycleView.setAdapter(adapter);

    }
}