package com.example.buylap.boundary;

import android.content.Context;
import android.widget.Toast;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanCashback;
import com.example.buylap.exceptions.NoCardInsertedException;

public class BoundaryPayment {

    //Simulate the payment

    public void pay(BeanCard beanCard, Context context) throws NoCardInsertedException {

       if(beanCard != null){
           Toast.makeText(context, "Earned 100 $ ! Sending payment to you credit card... ", Toast.LENGTH_SHORT).show();
       }else{
           throw new NoCardInsertedException("Card not exist");
       }

    }
    public void payCLI(BeanCard beanCard) throws NoCardInsertedException {

        if(beanCard != null){
            System.out.println("Earned 100 $ ! Sending payment to you credit card... ");
        }else{
            throw new NoCardInsertedException("Card not exist");
        }

    }
}
