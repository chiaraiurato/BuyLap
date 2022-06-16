package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.GuestFragment;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.UserFragment;

import java.util.HashMap;
import java.util.Map;

public class UserFragmentGraphicController extends SessionGraphicController{
    private UserFragment userFragment;
    private GuestFragment guestFragment;


    public UserFragmentGraphicController(UserFragment userFragment){
        super(userFragment.getContext());
        this.userFragment = userFragment;
        session = new SessionManager(userFragment.getContext());
        this.user = session.getUserDetails();
    }
    public UserFragmentGraphicController(GuestFragment guestFragment){
        super(guestFragment.getContext());
        this.guestFragment = guestFragment;
    }
    public void onSignOutGuest(){
        session.logoutUser();
        Intent intent = new Intent(guestFragment.getContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        guestFragment.startActivity(intent);

    }

    public void onSignOut(){

        session.logoutUser();
        Intent intent = new Intent(userFragment.getContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        userFragment.startActivity(intent);


    }


}
