package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import com.example.buylap.R;
import com.example.buylap.adapter.GenericUser;
import com.example.buylap.adapter.Homepage;
import com.example.buylap.adapter.HomepageAdaptee;
import com.example.buylap.adapter.HomepageAdapter;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.NotificationFragment;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.UserFragment;

import java.util.Map;

public class NavigationGraphicController {

    private NavigationActivity navigationActivity;
    private SessionManager sessionManager;

    public NavigationGraphicController(NavigationActivity navigationActivity) {
        this.navigationActivity = navigationActivity;
        this.sessionManager = new SessionManager(navigationActivity.getApplicationContext());;
    }

    public void checkLogin(){

        if(!sessionManager.isLoggedIn()){
            Intent intent = new Intent(navigationActivity.getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            navigationActivity.startActivity(intent);
        }
    }
    public void selectTypeHomepage(){
        GenericUser u = new GenericUser();
        HomepageAdaptee s1 = new HomepageAdaptee(navigationActivity);
        Homepage a = new HomepageAdapter(s1);
        navigationActivity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container, u.gotoMyHomepage(a)).commit();

    }

    public Fragment switchPage(MenuItem item){

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                selectTypeHomepage();
                break;
            case R.id.nav_cashback:
                fragment = new CashbackFragment();
                break;
            case R.id.nav_notification:
                fragment= new NotificationFragment();
                break;
            case R.id.nav_user:
                fragment= new UserFragment();
                break;
        }
        return fragment;

    }


}
