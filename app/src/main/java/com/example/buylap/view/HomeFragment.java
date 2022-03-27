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
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.graphic.HomeGraphicController;
import com.example.buylap.MostViewAdapter;
import com.example.buylap.R;
import com.example.buylap.exceptions.BeanException;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    private TextView accountName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HomeGraphicController homeGraphicController =new HomeGraphicController(this);

        RecyclerView.Adapter adapter;
        RecyclerView recyclerView;


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        try {
            homeGraphicController.initializeSession(view);
        } catch (BeanException e) {
            e.printStackTrace();
        }

        Button takeQuiz = view.findViewById(R.id.takequiz);
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               homeGraphicController.goToTakeQuiz();
            }
        });
        recyclerView = view.findViewById(R.id.RecyclerMostView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MostViewAdapter(homeGraphicController.setAdapterMostView());
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
