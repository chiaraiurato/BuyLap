package com.example.buylap.boundary;

import com.example.buylap.bean.BeanCashback;
import com.example.buylap.bean.BeanPoints;

public class BoundaryEbay {

    //Simulate the purchase made by user

    public BeanPoints madePurchase(BeanCashback beanCashback){

        double amount = beanCashback.getAmount();
        double conversion = amount * 0.10;
        BeanPoints beanPoints = new BeanPoints();
        beanPoints.setPoints((int)Math.round(conversion));
        return beanPoints;

    }
}
