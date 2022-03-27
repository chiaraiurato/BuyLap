package com.example.buylap.controller.graphic;

import android.util.Log;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.AddCardActivity;
import com.example.buylap.view.CashbackFragment;

import java.util.HashMap;

public class CashbackGraphicController {


    AddCardActivity addCardActivity;
    GetCashbackController getCashbackController;
    SessionManager sessionManager;

    public CashbackGraphicController(AddCardActivity addCardActivity) {
        this.addCardActivity = addCardActivity;
        this.getCashbackController = new GetCashbackController();
        this.sessionManager = new SessionManager(addCardActivity.getApplicationContext());
    }

    public void saveCreditCard() throws DAOException, BeanException {
        BeanCard beanCard = new BeanCard();
        beanCard.setCardHolderName(addCardActivity.sendName());
        beanCard.setCardNumber(addCardActivity.sendNumber());
        beanCard.setData(addCardActivity.sendDate());
        beanCard.setCvv(addCardActivity.sendCvv());
        BeanUser beanUser = new BeanUser();
        HashMap<String, String> user = sessionManager.getUserDetails();

        beanUser.setUsername(user.get("user"));
        beanUser.setPassword(user.get("pass"));
        Boolean result = getCashbackController.createCard(beanCard, beanUser);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "Credit card saved");
        }
    }
}
