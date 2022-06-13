package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanCashback;
import com.example.buylap.bean.BeanPoints;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.exceptions.NoCardInsertedException;
import com.example.buylap.view.AddCardActivity;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.NavigationActivity;

import java.io.IOException;
import java.sql.SQLException;

import java.text.ParseException;


public class CashbackGraphicController extends SessionGraphicController{

    private AddCardActivity addCardActivity;
    private CashbackFragment cashbackFragment;
    private GetCashbackController getCashbackController;
    private BeanPoints beanPoints;
    private BeanSession credentials;
    private BeanCard beanCard;

    public CashbackGraphicController(AddCardActivity addCardActivity){
        super(addCardActivity.getApplicationContext());
        this.addCardActivity = addCardActivity;
        this.getCashbackController = new GetCashbackController();
        this.credentials = getBeanSession();
        this.beanCard = new BeanCard();
    }
    public CashbackGraphicController(CashbackFragment cashbackFragment) throws BeanException {
        super(cashbackFragment.getContext());
        this.cashbackFragment= cashbackFragment;
        this.getCashbackController = new GetCashbackController();
        this.credentials = getBeanSession();
        this.beanPoints = new BeanPoints();

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
    public void uploadCreditCard() throws DAOException, ExpiredDateCardException, ParseException {

        beanCard = getCashbackController.uploadCreditCard(credentials);

        cashbackFragment.setCreditCard(beanCard);

    }
    public void uploadPoints() throws SQLException{

        beanPoints = getCashbackController.uploadPoints(credentials);
        cashbackFragment.setPoints(beanPoints);
    }

    public void deleteCreditCard() throws DAOException {

        getCashbackController.deleteCreditCard(credentials);
        cashbackFragment.deleteCreditCard();
    }

    public void cashOutPoints() throws SQLException, IOException {
        if(beanPoints.getPoints() < 100){
            Toast.makeText(cashbackFragment.getContext(), "Required a minimum of 100 points ", Toast.LENGTH_SHORT).show();
        }else {
            int remainingPoints = beanPoints.getPoints() - 100;
            beanPoints.setPoints(remainingPoints);
            try {
                getCashbackController.sendMoneyToCreditCard(beanCard, cashbackFragment.getContext());
                beanPoints=getCashbackController.updatePoints(beanPoints , credentials);
                cashbackFragment.setPoints(beanPoints);
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
