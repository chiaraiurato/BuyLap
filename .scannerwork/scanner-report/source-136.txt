package com.example.buylap.singleton;

import com.example.buylap.bean.BeanSeller;

public final class SellerSingleton {
    private BeanSeller beanSeller;

    private static final SellerSingleton INSTANCE = new SellerSingleton();

    private SellerSingleton() {}

    public static SellerSingleton getInstance() {
        return INSTANCE;
    }

    public void setSeller(BeanSeller beanSeller) {
        this.beanSeller = beanSeller;
    }

    public BeanSeller getSeller() {
        return this.beanSeller;
    }
}
