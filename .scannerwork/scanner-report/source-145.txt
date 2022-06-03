package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.example.buylap.R;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.LikeFragment;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.SellerFragment;
import com.example.buylap.view.UserFragment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NavigationGraphicController {

    private NavigationActivity navigationActivity;
    private SessionManager sessionManager;
    private Map<String, String> user;

    public NavigationGraphicController(NavigationActivity navigationActivity) {
        this.navigationActivity = navigationActivity;
        this.sessionManager = new SessionManager(navigationActivity.getApplicationContext());
        this.user = sessionManager.getUserDetails();
    }

    public void checkLogin(){

        if(!sessionManager.isLoggedIn()){
            Intent intent = new Intent(navigationActivity.getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            navigationActivity.startActivity(intent);
        }
    }
    public Fragment selectTypeHomepage(){
        Fragment fragment;

        if(Objects.equals(user.get("type"), "USER")){

            fragment = new HomeFragment();
        }else if(Objects.equals(user.get("type"), "SELLER")){
            fragment = new SellerFragment();
        }else{
            fragment = new HomeFragment();
        }
        return fragment;

    }
    public Fragment switchPage(MenuItem item){

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                if(user.get("type").equals("USER") || user.get("type").equals("GUEST")){
                    fragment = new HomeFragment();
                }else{
                    fragment = new SellerFragment();
                }
                break;
            case R.id.nav_cashback:
                fragment = new CashbackFragment();
                break;
            case R.id.nav_like:
                fragment= new LikeFragment();
                break;
            case R.id.nav_user:
                fragment= new UserFragment();
                break;
        }
        return fragment;

    }
}
