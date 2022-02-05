package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.View;

import com.example.buylap.HostUser;
import com.example.buylap.UserHolder;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.UserFragment;

public class UserFragmentGraphicController {
    private UserFragment userFragment;

    public UserFragmentGraphicController(UserFragment userFragment){
        this.userFragment = userFragment;
    }
    public void onSignOut(){
        UserHolder userHolder = UserHolder.getInstance();
        userHolder.setUser(null);
        HostUser hostUser = HostUser.getINSTANCE();
        hostUser.setGuest("");
        Intent intent = new Intent(userFragment.getContext(), MainActivity.class);
        userFragment.startActivity(intent);
    }


}
