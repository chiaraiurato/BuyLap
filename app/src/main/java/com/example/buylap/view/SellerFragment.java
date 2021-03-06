package com.example.buylap.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.buylap.exceptions.BeanException;
import com.example.buylap.factory.NavigationFactory;
import com.example.buylap.adaptergui.AnalyticsAdapter;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.controller.graphic.HomeGraphicController;
import com.example.buylap.R;

public class SellerFragment extends Fragment implements NavigationFactory {

    private TextView accountName;

    public SellerFragment() {
        //Singleton
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        HomeGraphicController homeGraphicController = new HomeGraphicController(this);
        View view= inflater.inflate(R.layout.fragment_seller, container, false);
        accountName = view.findViewById(R.id.businessAccount);
        Button takeQuiz = view.findViewById(R.id.takeQuiz);
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeGraphicController.goToTakeQuiz();
            }
        });
        try {
            homeGraphicController.initializeSessionForSeller(view);
        } catch (BeanException e) {
            e.printStackTrace();
        }
        Button insertComponent = view.findViewById(R.id.insertComp);
        insertComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeGraphicController.gotoInsertComponent();
            }
        });
        RecyclerView.Adapter adapter = new AnalyticsAdapter(homeGraphicController.setAdapterAnalytics());

        RecyclerView recyclerView = view.findViewById(R.id.RecyclerFunct);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void setSeller(BeanSeller beanSeller, View view){
        accountName = view.findViewById(R.id.businessAccount);

        if(beanSeller.getUsername() != null) {
            String username = beanSeller.getUsername() + ",";
            accountName.setText(username);
        }


    }

    @Override
    public Fragment selectMyFragment() {
        return this;
    }
}