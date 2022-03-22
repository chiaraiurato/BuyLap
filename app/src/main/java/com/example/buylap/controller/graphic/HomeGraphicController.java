package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.buylap.Analytics;
import com.example.buylap.MostViewed;
import com.example.buylap.singleton.SellerSingleton;
import com.example.buylap.singleton.UserSingleton;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.utils.Data;
import com.example.buylap.view.BudgetActivity;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.SellerFragment;

import java.util.List;

public class HomeGraphicController {
    HomeFragment homeFragment;

    SellerFragment sellerFragment;
    public HomeGraphicController(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }
    public HomeGraphicController(SellerFragment sellerFragment){
        this.sellerFragment = sellerFragment;
    }

    public List<MostViewed> setAdapterMostView(){
        Data data = new Data();
        return data.sendMostView();

    }
    public List<Analytics> setAdapterAnalytics(){
        Data data = new Data();
        return data.sendAnalytics();
    }
    public void initializeSession(View view){
        UserSingleton userSingleton = UserSingleton.getInstance();
        BeanUser beanUser = userSingleton.getUser();
        if(beanUser != null) {
            homeFragment.setUser(beanUser, view);
        }else{
            Log.d("DEBUG", "GUEST SESSION");
            homeFragment.setGuest(view);
        }
    }
    public void initializeSessionForSeller(View view){
        SellerSingleton holder = SellerSingleton.getInstance();
        BeanSeller beanSeller = holder.getSeller();
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
}
