package com.example.buylap.Controller.Grafico;

import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Controller.Applicativo.HomeController;
import com.example.buylap.UserHolder;
import com.example.buylap.View.HomeFragment;
import com.example.buylap.View.RegistrationActivity;

public class HomeGraphicController {
    HomeFragment homeFragment;

    HomeController homeController;
    public HomeGraphicController(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        this.homeController = new HomeController();
    }

    public void initializeSession(){
        UserHolder holder = UserHolder.getInstance();
        BeanUser beanUser = holder.getUser();
        homeFragment.setUser(beanUser);
    }
}
