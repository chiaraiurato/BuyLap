package com.example.buylap.adapter;

import androidx.fragment.app.Fragment;

public class GenericUser {

    public Fragment gotoMyHomepage(Homepage a){
        return a.switchMainPage();
    }

    public Fragment gotoMySetting(Homepage a){
        return a.switchSettingPage();
    }
}
