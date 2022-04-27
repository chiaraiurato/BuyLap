package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.View;

import com.example.buylap.Analytics;
import com.example.buylap.MostViewed;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.utils.Data;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.BudgetActivity;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.InsertComponentActivity;
import com.example.buylap.view.SellerFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HomeGraphicController {
    HomeFragment homeFragment;
    SellerFragment sellerFragment;
    SessionManager sessionManager;

    public HomeGraphicController(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        sessionManager = new SessionManager(homeFragment.getContext());
    }
    public HomeGraphicController(SellerFragment sellerFragment){
        this.sellerFragment = sellerFragment;
        sessionManager = new SessionManager(sellerFragment.getContext());
    }

    public List<MostViewed> setAdapterMostView(){
        Data data = new Data();
        return data.sendMostView();

    }
    public List<Analytics> setAdapterAnalytics(){
        Data data = new Data();
        return data.sendAnalytics();
    }
    public void initializeSession(View view) throws BeanException {

        Map<String, String> user = sessionManager.getUserDetails();
        if(Objects.equals(user.get("type"), "USER")) {
            BeanUser beanUser = new BeanUser();
            beanUser.setUsername(user.get("user"));
            homeFragment.setUser(beanUser, view);

        }else{
            homeFragment.setGuest(view);
        }
    }
    public void initializeSessionForSeller(View view){

        Map<String, String> user = sessionManager.getUserDetails();
        BeanSeller beanSeller = new BeanSeller();

        beanSeller.setUsername(user.get("user"));
        sellerFragment.setSeller(beanSeller, view);
    }
    public void goToTakeQuiz() {
        Intent intent;
        if(homeFragment == null) {
            intent = new Intent(sellerFragment.getContext(), BudgetActivity.class);
            sellerFragment.startActivity(intent);
        }
        else{
            intent = new Intent(homeFragment.getContext(), BudgetActivity.class);
            homeFragment.startActivity(intent);
        }
    }

    public void gotoInsertComponent() {
        Intent intent = new Intent(sellerFragment.getContext(), InsertComponentActivity.class);
        sellerFragment.startActivity(intent);
    }
}
