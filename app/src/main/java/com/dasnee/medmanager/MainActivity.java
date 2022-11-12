package com.dasnee.medmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private List<Med> meds;

    private RecyclerView recyclerView;
    private MedAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MedViewModel medViewModel = new ViewModelProvider(this).get(MedViewModel.class);
        medViewModel.getAllMeds().observe(this, meds -> {
            recyclerView = findViewById(R.id.recycler);
            adapter = new MedAdapter(meds);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });

        

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddMedActivity.class);
            startActivity(intent);
        });

    }
}