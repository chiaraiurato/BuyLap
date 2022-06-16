package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.widget.Toast;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanCashback;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.NoCardInsertedException;
import com.example.buylap.view.AddCardActivity;
import com.example.buylap.view.CashbackFragment;

import java.io.IOException;
import java.sql.SQLException;

import java.text.ParseException;


public class CashbackGraphicController extends SessionGraphicController{


    private CashbackFragment cashbackFragment;
    private GetCashbackController getCashbackController;
    private BeanCashback beanCashback;
    private BeanUser credentials;
    private BeanCard beanCard;


    public CashbackGraphicController(CashbackFragment cashbackFragment) throws BeanException, DAOException {
        super(cashbackFragment.getContext());
        this.cashbackFragment= cashbackFragment;

        this.credentials = getBeanSession();
        this.getCashbackController = new GetCashbackController(credentials);
        this.beanCashback = new BeanCashback();

    }

    public void uploadCreditCard() throws DAOException, ExpiredDateCardException, ParseException {

        beanCard = getCashbackController.uploadCreditCard(credentials);
        cashbackFragment.setCreditCard(beanCard);

    }
    public void uploadPoints() throws SQLException{

        beanCashback = getCashbackController.uploadPoints(credentials);
        cashbackFragment.setPoints(beanCashback);
    }

    public void deleteCreditCard() throws DAOException {

        getCashbackController.deleteCreditCard(credentials);
        cashbackFragment.deleteCreditCard();
    }

    public void cashOutPoints() throws SQLException, IOException {
        if(beanCashback.getPoints() < 50){
            Toast.makeText(cashbackFragment.getContext(), "Required a minimum of 50 points ", Toast.LENGTH_SHORT).show();
        }else {
            int remainingPoints = beanCashback.getPoints() - 50;
            beanCashback.setPoints(remainingPoints);

            try {

                getCashbackController.sendMoneyToCreditCard(beanCard, cashbackFragment.getContext());
                beanCashback =getCashbackController.updatePoints(beanCashback, credentials);
                cashbackFragment.setPoints(beanCashback);
            } catch (NoCardInsertedException e) {
                Toast.makeText(cashbackFragment.getContext(), "You need to add a credit card ", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void gotoAddCardActivity() {
        if(credentials.getUsername().equals("guest"))
        {
            Toast.makeText(cashbackFragment.getContext(), "You need to be logged! ", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(cashbackFragment.getContext(), AddCardActivity.class);
            cashbackFragment.startActivity(intent);
        }
    }
}
