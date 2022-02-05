package com.example.buylap.controller.graphic;

import android.content.Intent;

import com.example.buylap.HostUser;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;

public class MainGraphicController {
    MainActivity mainActivity;

    public MainGraphicController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }
    public void setHost(){
        Intent intent = new Intent(mainActivity, NavigationActivity.class);
        HostUser hostUser = HostUser.getINSTANCE();
        hostUser.setGuest("guest");
        mainActivity.startActivity(intent);
    }
}
