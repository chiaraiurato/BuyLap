package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanPoints;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.AddCardActivity;
import com.example.buylap.view.CashbackFragment;
import com.example.buylap.view.LoginActivity;
import com.example.buylap.view.NavigationActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import java.text.ParseException;
import java.util.Map;
import java.util.zip.DataFormatException;


public class CashbackGraphicController extends SessionGraphicController{

    private AddCardActivity addCardActivity;
    private CashbackFragment cashbackFragment;
    private GetCashbackController getCashbackController;
    private BeanPoints beanPoints;
    private BeanSession beanSession;

    public CashbackGraphicController(AddCardActivity addCardActivity){
        super(addCardActivity.getApplicationContext());
        this.addCardActivity = addCardActivity;
        this.getCashbackController = new GetCashbackController();
        this.beanSession = getBeanSession();
    }
    public CashbackGraphicController(CashbackFragment cashbackFragment) throws BeanException {
        super(cashbackFragment.getContext());
        this.cashbackFragment= cashbackFragment;
        this.getCashbackController = new GetCashbackController();
        this.beanSession = getBeanSession();
        this.beanPoints = new BeanPoints();

    }
    private void gotoNavigationActivity(){
        Intent intent = new Intent(addCardActivity, NavigationActivity.class);
        intent.putExtra("gotoCashback", true);
        addCardActivity.startActivity(intent);
    }
    public void saveCreditCard() throws DAOException, BeanException, LengthBeanCardException, ExpiredDateCardException, ParseException {
        BeanCard beanCard = new BeanCard();
        beanCard.setCardHolderName(addCardActivity.sendName());
        beanCard.setCardNumber(addCardActivity.sendNumber());
        beanCard.setData(addCardActivity.sendDate());

        Boolean result = getCashbackController.createCard(beanCard, this.beanSession);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "Credit card saved");
        }
        gotoNavigationActivity();
    }
    public void uploadCreditCard() throws DAOException, ExpiredDateCardException, ParseException {

        BeanCard beanCard = getCashbackController.uploadCreditCard(this.beanSession);

        cashbackFragment.setCreditCard(beanCard);

    }
    public void uploadPoints() throws SQLException, IOException {

        this.beanPoints = getCashbackController.uploadPoints(this.beanSession);
        cashbackFragment.setPoints(this.beanPoints);
    }

    public void deleteCreditCard() throws DAOException {

        getCashbackController.deleteCreditCard(this.beanSession);
        cashbackFragment.deleteCreditCard();
    }


    public void cashOutPoints() throws SQLException, IOException {

        getCashbackController.deletePoints(beanSession);
        beanPoints.setPoints(0);
        cashbackFragment.cashOutPoints(beanPoints);

    }

    public void gotoAddCardActivity() {
        if(beanSession.getUsername().equals("guest"))
        {
            Toast.makeText(cashbackFragment.getContext(), "You need to be logged! ", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(cashbackFragment.getContext(), AddCardActivity.class);
            cashbackFragment.startActivity(intent);
        }
    }
}
