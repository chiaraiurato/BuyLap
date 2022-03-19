package com.example.buylap.controller.graphic;

import android.content.Intent;

import com.example.buylap.singleton.GuestSingleton;
import com.example.buylap.bean.BeanGuest;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;

public class MainGraphicController {
    MainActivity mainActivity;
   

    public MainGraphicController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

   
    public void setHost(){
        Intent intent = new Intent(mainActivity, NavigationActivity.class);
        BeanGuest beanGuest = new BeanGuest();
        beanGuest.setTmp("guest");
        GuestSingleton guestSingleton = GuestSingleton.getINSTANCE();
        guestSingleton.setBeanGuest(beanGuest);
        mainActivity.startActivity(intent);
    }

}
