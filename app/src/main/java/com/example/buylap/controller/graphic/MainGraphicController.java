package com.example.buylap.controller.graphic;

import android.content.Intent;

import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;

public class MainGraphicController {
    MainActivity mainActivity;
    SessionManager sessionManager;

    public MainGraphicController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.sessionManager = new SessionManager(mainActivity.getApplicationContext());

    }

    public void setGuestAccount(){

        sessionManager.createLoginSession("guest","guest", "GUEST");
        Intent intent = new Intent(mainActivity, NavigationActivity.class);
        mainActivity.startActivity(intent);

    }



}
