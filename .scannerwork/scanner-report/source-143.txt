package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.view.View;

import com.example.buylap.model.Analytics;
import com.example.buylap.model.MostViewed;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.utils.Data;
import com.example.buylap.view.BudgetActivity;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.view.HomeFragment;
import com.example.buylap.view.InsertComponentActivity;
import com.example.buylap.view.SellerFragment;

import java.util.List;

public class HomeGraphicController extends SessionGraphicController{
    private HomeFragment homeFragment;
    private SellerFragment sellerFragment;
    private BeanUser credentials;

    public HomeGraphicController(HomeFragment homeFragment) {
        super(homeFragment.getContext());
        this.homeFragment = homeFragment;
        credentials = getBeanSession();

    }
    public HomeGraphicController(SellerFragment sellerFragment) {
        super(sellerFragment.getContext());
        this.sellerFragment = sellerFragment;
        credentials = getBeanSession();
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

        if(credentials.getType() != null) {
            if (credentials.getType().equals("USER")) {
                BeanUser beanUser = new BeanUser();
                beanUser.setUsername(credentials.getUsername());
                homeFragment.setUser(beanUser, view);

            } else {
                homeFragment.setGuest(view);
            }
        }
    }

    public void initializeSessionForSeller(View view) throws BeanException {

        BeanSeller beanSeller = new BeanSeller();
        beanSeller.setUsername(credentials.getUsername());
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
