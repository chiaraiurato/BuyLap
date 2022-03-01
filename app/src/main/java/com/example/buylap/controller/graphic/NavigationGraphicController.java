package com.example.buylap.controller.graphic;

import android.util.Log;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.example.buylap.HostUser;
import com.example.buylap.R;
import com.example.buylap.UserHolder;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.LikeFragment;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.SellerFragment;
import com.example.buylap.view.UserFragment;

public class NavigationGraphicController {

    private NavigationActivity navigationActivity;

    public NavigationGraphicController(NavigationActivity navigationActivity) {
        this.navigationActivity = navigationActivity;

    }
    public Fragment selectTypeHomepage(){
        Fragment fragment;
        UserHolder userHolder = UserHolder.getInstance();
        HostUser hostUser = HostUser.getINSTANCE();
        if(userHolder.getUser() != null){

            fragment = new HomeFragment();
        }else if(hostUser.getHost() =="guest"){ //con equals mi da exception

            fragment = new HomeFragment();
        }else{
            fragment = new SellerFragment();
        }
        return fragment;
    }
    public Fragment switchPage(MenuItem item){

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                UserHolder userHolder = UserHolder.getInstance();
                HostUser hostUser = HostUser.getINSTANCE();
                if(userHolder.getUser() != null || hostUser.getHost() == "guest") {
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
