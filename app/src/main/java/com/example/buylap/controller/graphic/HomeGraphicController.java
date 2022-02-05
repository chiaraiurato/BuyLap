package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.View;

import com.example.buylap.BudgetActivity;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.HomeController;
import com.example.buylap.UserHolder;
import com.example.buylap.view.HomeFragment;

public class HomeGraphicController {
    HomeFragment homeFragment;
    HomeController homeController;
    public HomeGraphicController(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        this.homeController = new HomeController();
    }

    public void initializeSession(View view){
        UserHolder holder = UserHolder.getInstance();
        BeanUser beanUser = holder.getUser();
        if(beanUser != null) {
            homeFragment.setUser(beanUser, view);
        }else{
            homeFragment.setGuest(view);
        }
    }

    public void goToTakeQuiz() {
        Intent intent = new Intent(homeFragment.getContext(), BudgetActivity.class);
        homeFragment.startActivity(intent);
    }
}
