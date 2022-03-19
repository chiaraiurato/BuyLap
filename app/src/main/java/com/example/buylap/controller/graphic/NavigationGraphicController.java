package com.example.buylap.controller.graphic;

import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.example.buylap.singleton.GuestSingleton;
import com.example.buylap.R;
import com.example.buylap.singleton.UserSingleton;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.LikeFragment;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.SellerFragment;
import com.example.buylap.view.UserFragment;

public class NavigationGraphicController {

    public Fragment selectTypeHomepage(){
        Fragment fragment;
        UserSingleton user = UserSingleton.getInstance();
        GuestSingleton guestSingleton = GuestSingleton.getINSTANCE();

        if(user.getUser() != null){

            fragment = new HomeFragment();
        }else if(guestSingleton.getBeanGuest() != null){

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
                UserSingleton userHolder = UserSingleton.getInstance();
                GuestSingleton guestSingleton = GuestSingleton.getINSTANCE();
                if(userHolder.getUser() != null || guestSingleton.getBeanGuest() != null) {
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
