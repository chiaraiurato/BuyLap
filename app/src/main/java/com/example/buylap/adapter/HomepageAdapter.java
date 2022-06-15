package com.example.buylap.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.buylap.R;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.GuestFragment;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.SellerFragment;
import com.example.buylap.view.UserFragment;

import java.util.Map;
import java.util.Objects;


public class HomepageAdapter implements Homepage{

    private SessionManager sessionManager;
    private TypeAccount type;
    private Map<String, String> user;
    private UserFragment userFragment;
    private SellerFragment sellerFragment;
    private NavigationActivity navigationActivity;
    private HomeFragment homeFragment;
    private GuestFragment guestFragment;

    public HomepageAdapter(UserFragment userFragment, SellerFragment sellerFragment, HomeFragment homeFragment,
                           GuestFragment guestFragment, NavigationActivity navigationActivity){
        this.userFragment = userFragment;
        this.sellerFragment = sellerFragment;
        this.homeFragment = homeFragment;
        this.guestFragment = guestFragment;
        this.navigationActivity = navigationActivity;

        this.sessionManager = new SessionManager(navigationActivity.getApplicationContext());
        this.user = sessionManager.getUserDetails();

        if(Objects.equals(user.get("type"), "USER")){
            type=TypeAccount.USER;
        }else if(Objects.equals(user.get("type"), "SELLER")){
            type= TypeAccount.SELLER;
        }else if(Objects.equals(user.get("type"), "GUEST")){
            type = TypeAccount.GUEST;
        }
    }

    public TypeAccount getTypeAccount() {
        return this.type;
    }

    @Override
    public Fragment switchMainPage() {
        TypeAccount typeAccount = getTypeAccount();
        if(typeAccount == TypeAccount.USER){
            return homeFragment;
        }else if(typeAccount == TypeAccount.SELLER){
            return sellerFragment;
        }else if(typeAccount == TypeAccount.GUEST){
            return homeFragment;
        }

        return null;
    }

    @Override
    public Fragment switchSettingPage() {

        TypeAccount typeAccount = getTypeAccount();
        if(typeAccount == TypeAccount.USER){
            return userFragment;
        }else if(typeAccount == TypeAccount.SELLER){
            return userFragment;
        }else if(typeAccount == TypeAccount.GUEST){
           return guestFragment;
        }
        return null;
    }


}
