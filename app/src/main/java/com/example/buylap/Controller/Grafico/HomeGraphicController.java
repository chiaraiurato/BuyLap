package com.example.buylap.Controller.Grafico;

import android.view.View;

import com.example.buylap.Bean.BeanSeller;
import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Controller.Applicativo.HomeController;
import com.example.buylap.SellerHolder;
import com.example.buylap.UserHolder;
import com.example.buylap.View.HomeFragment;
import com.example.buylap.View.SellerFragment;

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
