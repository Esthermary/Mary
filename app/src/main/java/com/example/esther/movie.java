package com.example.esther;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class movie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        ListView movieList = findViewById(R.id.movieList);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Frozen");
        arrayList.add("She isn out of my league");
        arrayList.add("Her stolen past");
        arrayList.add("Last christmas");arrayList.add("Passion");
        arrayList.add("Prison break");
        arrayList.add("Prince is mine");
        arrayList.add("Ana");
        arrayList.add("Harriet");
        arrayList.add("Addicted");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        movieList.setAdapter(arrayAdapter);




    }
}
