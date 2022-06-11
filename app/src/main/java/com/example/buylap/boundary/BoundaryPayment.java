package com.example.buylap.boundary;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanCashback;
import com.example.buylap.exceptions.NoCardInsertedException;

public class BoundaryPayment {

//Reset the amount of the payment

    public void pay(BeanCashback beanCashback) throws NoCardInsertedException {

       BeanCard beanCard = beanCashback.getBeanCard();
       if(beanCard != null){
           beanCashback.setAmount(0);
       }else{
           throw new NoCardInsertedException("Card not exist");
       }

    }
}
