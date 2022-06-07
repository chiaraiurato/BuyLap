package com.example.buylap.adapter;

import androidx.fragment.app.Fragment;

import com.example.buylap.bean.BeanSession;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.SellerFragment;

import java.util.Map;
import java.util.Objects;

public class HomepageAdaptee {

    private SessionManager sessionManager;
    private TypeAccount type;
    private Map<String, String> user;

    public HomepageAdaptee(NavigationActivity navigationActivity){
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

}
