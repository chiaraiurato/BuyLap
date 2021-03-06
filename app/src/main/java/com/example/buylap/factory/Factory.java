package com.example.buylap.factory;

import com.example.buylap.exceptions.InvalidTypeAccountException;
import com.example.buylap.view.GuestFragment;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.SellerFragment;
import com.example.buylap.view.UserFragment;


public class Factory {

    public NavigationFactory createNavigationFactory(String page, String type) throws InvalidTypeAccountException {
        if (page.equals("home")) {
            switch (type) {
                case "USER":
                case "GUEST":
                    return new HomeFragment();
                case "SELLER":
                    return new SellerFragment();
                default:
                    throw new InvalidTypeAccountException("Invalid type : " + type);
            }
        } else {
            switch (type) {
                case "USER":
                case "SELLER":
                    return new UserFragment();
                case "GUEST":
                    return new GuestFragment();
                default:
                    throw new InvalidTypeAccountException("Invalid type : " + type);
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
