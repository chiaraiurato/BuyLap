package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.buylap.Analytics;
import com.example.buylap.MostViewed;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.utils.Data;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.BudgetActivity;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.InsertComponentActivity;
import com.example.buylap.view.SellerFragment;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HomeGraphicController extends SessionGraphicController{
    private HomeFragment homeFragment;
    private SellerFragment sellerFragment;
    private BeanSession beanSession;

    public HomeGraphicController(HomeFragment homeFragment) {
        super(homeFragment.getContext());
        this.homeFragment = homeFragment;
        beanSession = getBeanSession();

    }
    public HomeGraphicController(SellerFragment sellerFragment) {
        super(sellerFragment.getContext());
        this.sellerFragment = sellerFragment;
        beanSession = getBeanSession();
    }

    public List<MostViewed> setAdapterMostView(){
        Data data = new Data();
        return data.sendMostView();

    }
    public List<Analytics> setAdapterAnalytics(){
        Data data = new Data();
        return data.sendAnalytics();
    }
    public void initializeSession(View view) throws BeanException {
        Log.d("beans", ""+beanSession.getUsername());
        if(beanSession.getType() != null) {
            if (beanSession.getType().equals("user")) {
                BeanUser beanUser = new BeanUser();
                beanUser.setUsername(beanSession.getUsername());
                homeFragment.setUser(beanUser, view);

            } else {
                homeFragment.setGuest(view);
            }
        }
    }

    public void initializeSessionForSeller(View view){

        BeanSeller beanSeller = new BeanSeller();
        beanSeller.setUsername(beanSession.getUsername());
        sellerFragment.setSeller(beanSeller, view);
    }
    public void goToTakeQuiz() {
        Intent intent;
        if(homeFragment == null) {
            intent = new Intent(sellerFragment.getContext(), BudgetActivity.class);
            sellerFragment.startActivity(intent);
        }
        else{
            intent = new Intent(homeFragment.getContext(), BudgetActivity.class);
            homeFragment.startActivity(intent);
        }
    }

    public void gotoInsertComponent() {
        Intent intent = new Intent(sellerFragment.getContext(), InsertComponentActivity.class);
        sellerFragment.startActivity(intent);
    }
}
