package com.example.buylap.boundary;

import android.content.Context;
import android.widget.Toast;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanCashback;
import com.example.buylap.exceptions.NoCardInsertedException;

public class BoundaryPayment {

//Reset the amount of the payment

    public void pay(BeanCard beanCard, Context context) throws NoCardInsertedException {

       if(beanCard != null){
           Toast.makeText(context, "Earned 0.50 $ ! Sending payment to you credit card... ", Toast.LENGTH_SHORT).show();
       }else{
           throw new NoCardInsertedException("Card not exist");
       }

    }
}
