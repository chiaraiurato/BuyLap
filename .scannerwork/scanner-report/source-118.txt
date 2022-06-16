package com.example.buylap.boundary;

import com.example.buylap.bean.BeanCashback;

public class BoundaryEbay {

    //Simulate the purchase made by user

    public BeanCashback madePurchase(BeanCashback beanCashback){

        double amount = beanCashback.getAmount();
        double conversion = amount * 0.10;
        beanCashback.setPoints((int)Math.round(conversion));
        return beanCashback;

    }
}
