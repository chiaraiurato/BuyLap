package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import com.example.buylap.R;
import com.example.buylap.abstract_factory.Client;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.NotificationFragment;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;


public class NavigationGraphicController extends SessionGraphicController{

    private NavigationActivity navigationActivity;
    private Client client;

    public NavigationGraphicController(NavigationActivity navigationActivity) {
        super(navigationActivity.getApplicationContext());
        this.navigationActivity = navigationActivity;
        this.client = new Client(navigationActivity);

    }

    public void checkLogin(){

        if(!isLogged()){
            Log.d("logged", ""+isLogged());
            Intent intent = new Intent(navigationActivity.getApplicationContext(), MainActivity.class);
           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            navigationActivity.startActivity(intent);
        }else{
            Fragment fragment = selectTypeHomepage();
            navigationActivity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
        }
    }
    public Fragment selectTypeHomepage(){
        return client.navigationHome.selectMyFragment();
    }

    public Fragment switchPage(MenuItem item){

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = client.navigationHome.selectMyFragment();
                break;
            case R.id.nav_cashback:
                fragment = new CashbackFragment();
                break;
            case R.id.nav_notification:
                fragment= new NotificationFragment();
                break;
            case R.id.nav_user:
                fragment=  client.navigationSetting.selectMyFragment();
                break;
        }
        return fragment;

    }


}
