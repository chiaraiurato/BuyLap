package com.example.buylap.controller.graphic;

import android.util.Log;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
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
    CashbackFragment cashbackFragment;
    GetCashbackController getCashbackController;
    SessionManager sessionManager;
    HashMap<String, String> user;
    public CashbackGraphicController(AddCardActivity addCardActivity) {
        this.addCardActivity = addCardActivity;
        this.getCashbackController = new GetCashbackController();
        this.sessionManager = new SessionManager(addCardActivity.getApplicationContext());
        this.user = sessionManager.getUserDetails();
    }
    public CashbackGraphicController(CashbackFragment cashbackFragment) {
        this.cashbackFragment= cashbackFragment;
        this.getCashbackController = new GetCashbackController();
        this.sessionManager = new SessionManager(cashbackFragment.getContext());
        this.user = sessionManager.getUserDetails();
    }

    public void saveCreditCard() throws DAOException, BeanException {
        BeanCard beanCard = new BeanCard();
        beanCard.setCardHolderName(addCardActivity.sendName());
        beanCard.setCardNumber(addCardActivity.sendNumber());
        beanCard.setData(addCardActivity.sendDate());
        beanCard.setCvv(addCardActivity.sendCvv());
        BeanSession beanSession = new BeanSession();

        beanSession.setUsername(user.get("user"));
        Boolean result = getCashbackController.createCard(beanCard, beanSession);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "Credit card saved");
        }
    }
    public void uploadCreditCardIfExist() throws DAOException, BeanException {

        BeanUser beanUser= new BeanUser();
        beanUser.setUsername(user.get("user"));
        BeanCard beanCard= getCashbackController.uploadCreditCard(beanUser);
        cashbackFragment.setCreditCard(beanCard);
    }

    public void deleteCreditCard() throws BeanException, DAOException {
        BeanSession beanSession = new BeanSession();

        beanSession.setUsername(user.get("user"));
        getCashbackController.deleteCreditCard(beanSession);
        cashbackFragment.deleteCreditCard();
    }
}
