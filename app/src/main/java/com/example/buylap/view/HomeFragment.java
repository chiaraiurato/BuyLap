package com.example.buylap.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.buylap.Question;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.graphic.HomeGraphicController;
import com.example.buylap.MostViewAdapter;
import com.example.buylap.MostViewed;
import com.example.buylap.model.QuizList;
import com.example.buylap.R;
import java.util.ArrayList;


public class HomeFragment extends Fragment {


    private TextView accountName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HomeGraphicController homeGraphicController =new HomeGraphicController(this);
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView;
        Button takeQuiz;

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        homeGraphicController.initializeSession(view);

        takeQuiz = view.findViewById(R.id.takequiz);
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               homeGraphicController.goToTakeQuiz();
            }
        });
        recyclerView = view.findViewById(R.id.RecyclerMostView);

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
    public void setUser(BeanUser beanUser, View view) {
        accountName = view.findViewById(R.id.nameAccount);
        if (beanUser.getUsername() != null) {
            String username = beanUser.getUsername() + ",";
            accountName.setText(username);
        }
    }

    public void setGuest( View view) {
        accountName = view.findViewById(R.id.nameAccount);
        String username = "guest";
        accountName.setText(username);
    }
}
