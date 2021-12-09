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

import com.example.buylap.Category;
import com.example.buylap.CategoryAdapter;
import com.example.buylap.MostViewAdapter;
import com.example.buylap.MostViewed;
import com.example.buylap.QuizList;
import com.example.buylap.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements CategoryAdapter.OnCatListener {


    public static ArrayList<QuizList> listQuest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView.Adapter adapter;
        RecyclerView.Adapter adapter2;
        RecyclerView recyclerView;
        RecyclerView recyclerViewCat;
        Button takeQuiz;
        ArrayList<Category> mCategory= new ArrayList<>();

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        listQuest=new ArrayList<>();
        listQuest.add(new QuizList("Who are you?", "Beginner", "Nerd", "Don't know"));
        listQuest.add(new QuizList("What is your profession ?", "Student", "Worker", "Business man"));
        listQuest.add(new QuizList("Click your category", "Gaming", "Office use", "Home use"));

        takeQuiz=view.findViewById(R.id.takequizbtn);
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakeQuizActivity.class);
                startActivity(intent);
            }
        });

       //recyclerViewCat=(RecyclerView)view.findViewById(R.id.RecyclerCat);
        recyclerView=(RecyclerView)view.findViewById(R.id.RecyclerMostView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),  LinearLayoutManager.VERTICAL, false);
        //LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
       /* recyclerViewCat.setLayoutManager(linearLayoutManager2);
        ArrayList<Category> cat = new ArrayList<>();
        cat.add(new Category("Gaming", "ic_baseline_gamepad_24"));
        cat.add(new Category("Office", "ic_round_architecture_24"));
        cat.add(new Category("Home", "ic_baseline_home_work_24"));
        cat.add(new Category("Study", "ic_round_school_24"));

        adapter2 = new CategoryAdapter(cat, this);
        recyclerViewCat.setAdapter(adapter2);

        */
        ArrayList <MostViewed> mostviewed = new ArrayList<>();
        mostviewed.add(new MostViewed("AMD", "Ryzen 7 3700X", "cpu"));
        mostviewed.add(new MostViewed("NVIDIA", "GTX 1800ti", "videocard"));
        mostviewed.add(new MostViewed("CORSAIR", "DDR4 32GB", "ram"));
        mostviewed.add(new MostViewed("MSI B550-A PRO", "ATX DDR4 LAN USB 3.2 Gen2 Front Type-C HDMI DisplayPort", "motherboard"));
        adapter= new MostViewAdapter(mostviewed);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onCatClick(int position) {
        final Intent intent;
        switch (position){
            case 0:
                intent =  new Intent(getContext(), GamingActivity.class);
                break;

            case 1:
                intent =  new Intent(getContext(), OfficeActivity.class);
                break;
            case 2:
                intent = new Intent(getContext(), HomeActivity.class);
                break;

            default:
                intent =  new Intent(getContext(), StudyActivity.class);
                break;
        }
        getContext().startActivity(intent);
    }
}
