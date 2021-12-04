package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GamingActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);
        recyclerList=(RecyclerView)findViewById(R.id.RecyclerList);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);
        recyclerList.setLayoutManager(linearLayoutManager3);

        ArrayList<MostViewed> mostviewed = new ArrayList<>();
        mostviewed.add(new MostViewed("DELL", "XPS15", "ic_baseline_laptop_24"));
        mostviewed.add(new MostViewed("ASUS", "TUF", "ic_baseline_laptop_24"));
        mostviewed.add(new MostViewed("HP", "PAVILION", "ic_baseline_laptop_24"));
        mostviewed.add(new MostViewed("Acer", "NITRO", "ic_baseline_laptop_24"));
        mostviewed.add(new MostViewed("LENOVO", "sowk", "ic_baseline_laptop_24"));
        adapter= new MostViewAdapter(mostviewed);
        recyclerList.setAdapter(adapter);

    }
}