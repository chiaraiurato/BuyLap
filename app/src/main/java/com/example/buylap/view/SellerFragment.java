package com.example.buylap.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.buylap.Analytics;
import com.example.buylap.AnalyticsAdapter;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.controller.graphic.HomeSellerGraphicController;
import com.example.buylap.R;

import java.util.ArrayList;

public class SellerFragment extends Fragment {

    private TextView accountName;
    public SellerFragment() {
        //Singleton
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        HomeSellerGraphicController homeSellerGraphicController = new HomeSellerGraphicController(this);
        View view= inflater.inflate(R.layout.fragment_seller, container, false);
        accountName = view.findViewById(R.id.businessAccount);
        homeSellerGraphicController.initializeSessionForSeller(view);
        ArrayList<Analytics> analytics = new ArrayList<>();
        analytics.add(new Analytics("statistics"));
        analytics.add(new Analytics("piechart"));
        analytics.add(new Analytics("booklet"));
        analytics.add(new Analytics("paidsearch"));
        RecyclerView.Adapter adapter = new AnalyticsAdapter(analytics);

        RecyclerView recyclerView = view.findViewById(R.id.RecyclerFunct);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);

       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

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
}