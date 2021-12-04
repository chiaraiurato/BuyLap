package com.example.buylap;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        listQuest.add(new QuizList("What is your profession", "Student", "Worker"));
        listQuest.add(new QuizList("What is your budget", "under 1000$", "over 1000$"));
        listQuest.add(new QuizList("Click your category", "Gaming", "Office use"));
        listQuest.add(new QuizList("Choose a color", "Black", "White"));
        takeQuiz=view.findViewById(R.id.takequizbtn);
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakeQuiz1Activity.class);
                startActivity(intent);
            }
        });

        recyclerViewCat=(RecyclerView)view.findViewById(R.id.RecyclerCat);
        recyclerView=(RecyclerView)view.findViewById(R.id.RecyclerMostView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),  LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewCat.setLayoutManager(linearLayoutManager2);
        ArrayList<Category> cat = new ArrayList<>();
        cat.add(new Category("Gaming", "ic_baseline_gamepad_24"));
        cat.add(new Category("Office", "ic_round_architecture_24"));
        cat.add(new Category("Home", "ic_baseline_home_work_24"));
        cat.add(new Category("Study", "ic_round_school_24"));

        adapter2 = new CategoryAdapter(cat, this);
        recyclerViewCat.setAdapter(adapter2);
        ArrayList <MostViewed> mostviewed = new ArrayList<>();
        mostviewed.add(new MostViewed("DELL", "XPS15", "ic_baseline_laptop_24"));
        mostviewed.add(new MostViewed("ASUS", "TUF", "ic_baseline_laptop_24"));
        mostviewed.add(new MostViewed("HP", "PAVILION", "ic_baseline_laptop_24"));
        mostviewed.add(new MostViewed("Acer", "NITRO", "ic_baseline_laptop_24"));
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
