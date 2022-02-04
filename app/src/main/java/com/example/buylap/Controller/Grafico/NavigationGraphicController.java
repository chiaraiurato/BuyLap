package com.example.buylap.Controller.Grafico;

import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.example.buylap.R;
import com.example.buylap.SellerHolder;
import com.example.buylap.UserHolder;
import com.example.buylap.View.CashbackFragment;
import com.example.buylap.View.HomeFragment;
import com.example.buylap.View.LikeFragment;
import com.example.buylap.View.NavigationActivity;
import com.example.buylap.View.SellerFragment;
import com.example.buylap.View.UserFragment;

public class NavigationGraphicController {

    private NavigationActivity navigationActivity;

    public NavigationGraphicController(NavigationActivity navigationActivity) {
        this.navigationActivity = navigationActivity;

    }
    public Fragment choiceAccount(){
        Fragment fragment;
        UserHolder userHolder = UserHolder.getInstance();
        if(userHolder.getUser() != null){

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
                if(userHolder.getUser() != null) {
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
