package com.example.buylap.abstract_factory;

import androidx.fragment.app.Fragment;

import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.GuestFragment;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.SellerFragment;
import com.example.buylap.view.UserFragment;

import java.util.Map;
import java.util.Objects;


public class Factory {

    public NavigationFactory createNavigationFactory(String page, String type) throws Exception {
        if (page.equals("home")) {
            switch (type) {
                case "USER":
                case "GUEST":
                    return new HomeFragment();
                case "SELLER":
                    return new SellerFragment();
                default:
                    throw new Exception("Invalid type : " + type);
            }
        } else {
            switch (type) {
                case "USER":
                case "SELLER":
                    return new UserFragment();
                case "GUEST":
                    return new GuestFragment();
                default:
                    throw new Exception("Invalid type : " + type);
            }
        }
    }

    public UserFragment createUserFragment(){
        return new UserFragment();
    }

    public SellerFragment createSellerFragment(){
        return new SellerFragment();
    }

    public HomeFragment createHomeFragment(){
        return new HomeFragment();
    }
    public GuestFragment createGuestFragment(){
        return new GuestFragment();
    }


}
