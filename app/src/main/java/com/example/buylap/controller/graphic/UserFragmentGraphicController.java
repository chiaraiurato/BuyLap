package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.buylap.singleton.GuestSingleton;
import com.example.buylap.singleton.SellerSingleton;
import com.example.buylap.singleton.UserSingleton;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.UserFragment;

public class UserFragmentGraphicController {
    private UserFragment userFragment;

    public UserFragmentGraphicController(UserFragment userFragment){
        this.userFragment = userFragment;
    }
    public void initializeSession(View view){
        UserSingleton holder = UserSingleton.getInstance();
        BeanUser beanUser = holder.getUser();
        if(beanUser != null) {
            userFragment.setFragmentUser(beanUser, view);
        }else{
            userFragment.setFragmentGuest(view);
        }
    }
    public void notifyGuest(View view){
        Toast.makeText(view.getContext(), "You must be logged", Toast.LENGTH_SHORT).show();
    }
    public void onSignOut(){
        UserSingleton userHolder = UserSingleton.getInstance();
        userHolder.setUser(null);
        GuestSingleton guestSingleton = GuestSingleton.getINSTANCE();
        guestSingleton.setBeanGuest(null);
        SellerSingleton sellerSingleton = SellerSingleton.getInstance();
        sellerSingleton.setSeller(null);

        Intent intent = new Intent(userFragment.getContext(), MainActivity.class);
        userFragment.startActivity(intent);
    }


}
