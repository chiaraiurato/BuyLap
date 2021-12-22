package com.example.buylap.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.buylap.MostViewAdapter;
import com.example.buylap.MostViewed;
import com.example.buylap.Model.QuizList;
import com.example.buylap.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    public static ArrayList<QuizList> listQuest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView;
        Button takeQuiz;

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listQuest = new ArrayList<>();
        listQuest.add(new QuizList("Who are you?", "Beginner", "Nerd", "Don't know"));
        listQuest.add(new QuizList("What is your profession ?", "Student", "Worker", "Business man"));
        listQuest.add(new QuizList("Click your category", "Gaming", "Office use", "Home use"));

        takeQuiz = view.findViewById(R.id.takequizbtn);
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakeQuizActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerMostView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<MostViewed> mostviewed = new ArrayList<>();
        mostviewed.add(new MostViewed("AMD", "Ryzen 7 3700X", "cpu"));
        mostviewed.add(new MostViewed("NVIDIA", "GTX 1800ti", "videocard"));
        mostviewed.add(new MostViewed("CORSAIR", "DDR4 32GB", "ram"));
        mostviewed.add(new MostViewed("MSI B550-A PRO", "ATX DDR4 LAN USB 3.2 Gen2 Front Type-C HDMI DisplayPort", "motherboard96"));
        adapter = new MostViewAdapter(mostviewed);
        recyclerView.setAdapter(adapter);


        return view;
    }

}

