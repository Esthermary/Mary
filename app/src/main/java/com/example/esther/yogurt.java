package com.example.esther;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class yogurt extends AppCompatActivity implements YogurtAdapter.ItemClickListener{

    RecyclerView recyclerView;
    YogurtAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogurt);

        recyclerView = findViewById(R.id.yogurt);

        ArrayList<String> names = new ArrayList<>();
        names.add("Jessa");
        names.add("StrawBerry");
        names.add("Toffee");
        names.add("Plain");
        names.add("Vanilla");

        // set up the RecyclerView

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new YogurtAdapter(this, names);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
