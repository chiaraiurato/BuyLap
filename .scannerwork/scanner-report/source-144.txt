package com.example.buylap.controller.graphic;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.view.AddCardActivity;
import com.example.buylap.view.NavigationActivity;

import java.text.ParseException;

public class AddCardGraphicController extends SessionGraphicController{

    private AddCardActivity addCardActivity;
    private BeanCard beanCard;
    private BeanSession credentials;
    private GetCashbackController getCashbackController;

    public AddCardGraphicController(AddCardActivity addCardActivity){
        super(addCardActivity.getApplicationContext());
        this.addCardActivity = addCardActivity;
        this.getCashbackController = new GetCashbackController();
        this.credentials = getBeanSession();
        this.beanCard = new BeanCard();
    }
    private void gotoNavigationActivity(){
        Intent intent = new Intent(addCardActivity, NavigationActivity.class);
        intent.putExtra("gotoCashback", true);
        addCardActivity.startActivity(intent);
    }
    public void saveCreditCard() throws DAOException, BeanException, LengthBeanCardException, ExpiredDateCardException, ParseException {

        beanCard.setCardHolderName(addCardActivity.sendName());
        beanCard.setCardNumber(addCardActivity.sendNumber());
        beanCard.setData(addCardActivity.sendDate());

        Boolean result = getCashbackController.createCard(beanCard, credentials);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "Credit card saved");
        }
        gotoNavigationActivity();
    }
}
