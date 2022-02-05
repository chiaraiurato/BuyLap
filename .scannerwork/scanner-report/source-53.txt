package com.example.buylap;

import com.example.buylap.bean.BeanSeller;

public class SellerHolder {
    private BeanSeller beanSeller;

    private final static SellerHolder INSTANCE = new SellerHolder();

    private SellerHolder() {}

    public static SellerHolder getInstance() {
        return INSTANCE;
    }

    public void setSeller(BeanSeller beanSeller) {
        this.beanSeller = beanSeller;
    }

    public BeanSeller getSeller() {
        return this.beanSeller;
    }
}
