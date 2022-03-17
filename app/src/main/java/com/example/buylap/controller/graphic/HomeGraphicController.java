package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.buylap.SellerSingleton;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.view.BudgetActivity;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.HomeController;
import com.example.buylap.UserHolder;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.SellerFragment;

import net.jodah.failsafe.internal.util.DelegatingExecutorService;

public class HomeGraphicController {
    HomeFragment homeFragment;
    HomeController homeController;
    SellerFragment sellerFragment;
    public HomeGraphicController(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        this.homeController = new HomeController();
    }
    public HomeGraphicController(SellerFragment sellerFragment){
        this.sellerFragment = sellerFragment;
        this.homeController = new HomeController();
    }

    public void initializeSession(View view){
        UserHolder holder = UserHolder.getInstance();
        BeanUser beanUser = holder.getUser();
        if(beanUser != null) {
            homeFragment.setUser(beanUser, view);
        }else{
            Log.d("DEBUG", "hereGuestagain");
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
