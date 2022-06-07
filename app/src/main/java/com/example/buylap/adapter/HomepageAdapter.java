package com.example.buylap.adapter;

import androidx.fragment.app.Fragment;

import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.SellerFragment;

public class HomepageAdapter implements Homepage{

    private HomepageAdaptee homepageAdaptee;

    public HomepageAdapter(HomepageAdaptee homepageAdaptee){
        this.homepageAdaptee = homepageAdaptee;
    }

    @Override
    public Fragment switchPage() {
        Fragment fragment = null;
        TypeAccount typeAccount = homepageAdaptee.getTypeAccount();
        if(typeAccount == TypeAccount.USER){
            fragment = new HomeFragment();
        }else if(typeAccount == TypeAccount.SELLER){
            fragment = new SellerFragment();
        }else if(typeAccount == TypeAccount.GUEST){
            fragment = new HomeFragment();
        }
        return fragment;
    }
}
