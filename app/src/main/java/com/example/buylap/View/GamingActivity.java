package com.example.buylap.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.buylap.MostViewAdapter;
import com.example.buylap.MostViewed;
import com.example.buylap.R;

import java.util.ArrayList;

public class GamingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView.Adapter adapter;
        RecyclerView recyclerList;
        setContentView(R.layout.activity_gaming);
        recyclerList=(RecyclerView)findViewById(R.id.RecyclerList);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);
        recyclerList.setLayoutManager(linearLayoutManager3);

        ArrayList<MostViewed> mostviewed = new ArrayList<>();
        mostviewed.add(new MostViewed("AMD", "Ryzen 7 3700X", "ic_baseline_cpu"));
        mostviewed.add(new MostViewed("NVIDIA", "GTX 1800ti", "ic_baseline_gpu"));
        mostviewed.add(new MostViewed("CORSAIR", "DDR4 32GB", "ic_baseline_ram"));
        mostviewed.add(new MostViewed("Cooler Master", "MasterBox Q300L", "ic_baseline_laptop_24"));
        adapter= new MostViewAdapter(mostviewed);
        recyclerList.setAdapter(adapter);

    }
}