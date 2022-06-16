package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import com.example.buylap.R;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.factory.Factory;
import com.example.buylap.factory.NavigationFactory;
import com.example.buylap.exceptions.InvalidTypeAccountException;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.NotificationFragment;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;


public class NavigationGraphicController extends SessionGraphicController{

    private NavigationActivity navigationActivity;
    private BeanUser credentials;
    private NavigationFactory navigationHome;
    private NavigationFactory navigationSetting;

    public NavigationGraphicController(NavigationActivity navigationActivity) {
        super(navigationActivity.getApplicationContext());
        this.navigationActivity = navigationActivity;
        this.credentials = getBeanSession();
    }

    public void checkLogin(){

        if(!isLogged()){
            Log.d("logged", ""+isLogged());
            Intent intent = new Intent(navigationActivity.getApplicationContext(), MainActivity.class);
           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            navigationActivity.startActivity(intent);
        }else{

            Factory factory = new Factory();
            try {
                navigationHome = factory.createNavigationFactory("home", credentials.getType());
                navigationSetting = factory.createNavigationFactory("setting", credentials.getType());

            } catch (InvalidTypeAccountException e) {
                e.printStackTrace();
            }
            Fragment fragment = selectTypeHomepage();
            navigationActivity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
        }
    }
    public Fragment selectTypeHomepage(){
        return navigationHome.selectMyFragment();
    }

    public Fragment switchPage(MenuItem item){

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = navigationHome.selectMyFragment();
                break;
            case R.id.nav_cashback:
                fragment = new CashbackFragment();
                break;
            case R.id.nav_notification:
                fragment= new NotificationFragment();
                break;
            case R.id.nav_user:
                fragment=  navigationSetting.selectMyFragment();
                break;
        }
        return fragment;

    }


}
