package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import com.example.buylap.R;
import com.example.buylap.adapter.GenericUser;
import com.example.buylap.adapter.Homepage;
import com.example.buylap.adapter.HomepageAdapter;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.GuestFragment;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.NotificationFragment;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.SellerFragment;
import com.example.buylap.view.UserFragment;

public class NavigationGraphicController extends SessionGraphicController{

    private NavigationActivity navigationActivity;
    private GenericUser u;
    private HomeFragment homeFragment;
    private SellerFragment sellerFragment;
    private GuestFragment guestFragment;
    private UserFragment userFragment;

    private Homepage a;

    public NavigationGraphicController(NavigationActivity navigationActivity) {
        super(navigationActivity.getApplicationContext());
        this.navigationActivity = navigationActivity;
        this.u =new GenericUser();
        this.homeFragment= new HomeFragment();
        this.sellerFragment = new SellerFragment();
        this.guestFragment = new GuestFragment();
        this.userFragment = new UserFragment();
        this.a= new HomepageAdapter(userFragment, sellerFragment, homeFragment, guestFragment, navigationActivity );

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

        return u.gotoMyHomepage(a);

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
