package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.UserFragment;

import java.util.HashMap;
import java.util.Map;

public class UserFragmentGraphicController {
    private final UserFragment userFragment;
    private final SessionManager session;
    private final Map<String, String> user;

    public UserFragmentGraphicController(UserFragment userFragment){
        this.userFragment = userFragment;
        session = new SessionManager(userFragment.getContext());
        this.user = session.getUserDetails();
    }
    public void initializeSession(View view){
         if(user.get("type").equals("SELLER")) {
             userFragment.setFragmentGuest(view);
         }

    }
    public void notifyGuest(View view){
        Toast.makeText(view.getContext(), "You must be logged", Toast.LENGTH_SHORT).show();
    }
    public void onSignOut(){

        session.logoutUser();
        Intent intent = new Intent(userFragment.getContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        userFragment.startActivity(intent);


    }


}
