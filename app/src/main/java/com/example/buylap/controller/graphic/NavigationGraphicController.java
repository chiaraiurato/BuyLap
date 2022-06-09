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
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.NotificationFragment;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.UserFragment;

import java.util.Map;

public class NavigationGraphicController extends SessionGraphicController{

    private NavigationActivity navigationActivity;
    private GenericUser u;
    private HomepageAdaptee s1;
    private Homepage a;
    public NavigationGraphicController(NavigationActivity navigationActivity) {
        super(navigationActivity.getApplicationContext());
        this.navigationActivity = navigationActivity;
        this.u =new GenericUser();
        this.s1= new HomepageAdaptee(navigationActivity);
        this.a= new HomepageAdapter(s1);

    }

    public void checkLogin(){

        if(!isLogged()){
            Intent intent = new Intent(navigationActivity.getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            navigationActivity.startActivity(intent);
        }
    }
    public Fragment selectTypeHomepage(){

        return u.gotoMyHomepage(a);

    }

    public void getMyFragment(){
        Fragment fragment = selectTypeHomepage();
        navigationActivity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
    }


    public Fragment switchPage(MenuItem item){

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = u.gotoMyHomepage(a);
                break;
            case R.id.nav_cashback:
                fragment = new CashbackFragment();
                break;
            case R.id.nav_notification:
                fragment= new NotificationFragment();
                break;
            case R.id.nav_user:
                fragment=  u.gotoMySetting(a);
                break;
        }
        return fragment;

    }


}
