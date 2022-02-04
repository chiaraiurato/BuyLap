package com.example.buylap.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.buylap.Analytics;
import com.example.buylap.AnalyticsAdapter;
import com.example.buylap.Bean.BeanSeller;
import com.example.buylap.Controller.Grafico.HomeGraphicController;
import com.example.buylap.Controller.Grafico.HomeSellerGraphicController;
import com.example.buylap.MostViewAdapter;
import com.example.buylap.MostViewed;
import com.example.buylap.R;

import java.util.ArrayList;

public class SellerFragment extends Fragment {

    private HomeSellerGraphicController homeSellerGraphicController;
    private View view;
    private TextView accountName;
    private  RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    public SellerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.homeSellerGraphicController = new HomeSellerGraphicController(this);
        view= inflater.inflate(R.layout.fragment_seller, container, false);
        accountName = view.findViewById(R.id.businessAccount);
        homeSellerGraphicController.initializeSessionForSeller(view);
        ArrayList<Analytics> analytics = new ArrayList<>();
        analytics.add(new Analytics("cpu"));
        analytics.add(new Analytics("ssd"));
        analytics.add(new Analytics("ram"));

        adapter = new AnalyticsAdapter(analytics);
        recyclerView = view.findViewById(R.id.RecyclerFunct);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
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