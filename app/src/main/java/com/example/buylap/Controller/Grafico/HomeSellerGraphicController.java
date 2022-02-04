package com.example.buylap.Controller.Grafico;

import android.view.View;

import com.example.buylap.Bean.BeanSeller;
import com.example.buylap.SellerHolder;
import com.example.buylap.View.SellerFragment;

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
