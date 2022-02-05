package com.example.buylap.controller.graphic;

import android.view.View;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.SellerHolder;
import com.example.buylap.view.SellerFragment;

public class HomeSellerGraphicController {
    SellerFragment sellerFragment;

    public HomeSellerGraphicController(SellerFragment sellerFragment) {
        this.sellerFragment = sellerFragment;
    }
    public void initializeSessionForSeller(View view){
        SellerHolder holder = SellerHolder.getInstance();
        BeanSeller beanSeller = holder.getSeller();
        sellerFragment.setSeller(beanSeller, view);
    }
}
