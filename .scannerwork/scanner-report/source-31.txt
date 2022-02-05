package com.example.buylap.controller.graphic;

import android.view.View;

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

    public void initializeSessionForUser(View view){
        UserHolder holder = UserHolder.getInstance();
        BeanUser beanUser = holder.getUser();
        homeFragment.setUser(beanUser, view);
    }
}
