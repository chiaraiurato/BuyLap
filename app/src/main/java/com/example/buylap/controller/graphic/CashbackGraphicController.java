package com.example.buylap.controller.graphic;

import android.util.Log;
import android.widget.Toast;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.AddCardActivity;
import com.example.buylap.view.CashbackFragment;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

public class CashbackGraphicController {


    AddCardActivity addCardActivity;
    CashbackFragment cashbackFragment;
    GetCashbackController getCashbackController;
    SessionManager sessionManager;
    HashMap<String, String> user;
    private static BeanSession beanSession;

    public CashbackGraphicController(AddCardActivity addCardActivity){
        this.addCardActivity = addCardActivity;
        this.getCashbackController = new GetCashbackController();
    }
    public CashbackGraphicController(CashbackFragment cashbackFragment) throws BeanException {
        this.cashbackFragment= cashbackFragment;
        this.getCashbackController = new GetCashbackController();
        this.sessionManager = new SessionManager(cashbackFragment.getContext());
        this.user = sessionManager.getUserDetails();
        beanSession = new BeanSession();
        if(user.get("user") != null) {
            beanSession.setUsername(user.get("user"));
        }
    }

    public void saveCreditCard() throws DAOException, BeanException {
        BeanCard beanCard = new BeanCard();
        beanCard.setCardHolderName(addCardActivity.sendName());
        beanCard.setCardNumber(addCardActivity.sendNumber());
        beanCard.setData(addCardActivity.sendDate());
        beanCard.setCvv(addCardActivity.sendCvv());
        System.out.println(beanSession.getUsername());
        Boolean result = getCashbackController.createCard(beanCard, beanSession);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "Credit card saved");
        }
    }
    public void uploadCreditCard() throws DAOException, BeanException, SQLException, FileNotFoundException {

        BeanCard beanCard= getCashbackController.uploadCreditCard(beanSession);
        System.out.println(beanSession.getUsername());
        cashbackFragment.setCreditCard(beanCard);

    }
    public void uploadPoints() throws DAOException, SQLException, FileNotFoundException {
        int points = getCashbackController.uploadPoints(beanSession);
        cashbackFragment.setPoints(points);
    }
    public boolean verifyLengthOfCreditCard(){
        if(addCardActivity.sendNumber().length() > 20) {
            Toast.makeText(addCardActivity, "Length of credit card incorrect", Toast.LENGTH_SHORT).show();
            return false;
        }
    return true;
    }

    public void deleteCreditCard() throws BeanException, DAOException {

        getCashbackController.deleteCreditCard(beanSession);
        cashbackFragment.deleteCreditCard();
    }


    public void cashOutPoints() throws BeanException, DAOException, SQLException, FileNotFoundException {

        getCashbackController.deletePoints(beanSession);
        cashbackFragment.cashOutPoints();

    }


}
