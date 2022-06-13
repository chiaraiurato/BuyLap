package com.example.buylap.cli.graphic_controller;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.buylap.bean.BeanPoints;
import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.cli.view.Cashback;
import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.exceptions.NoCardInsertedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.zip.DataFormatException;

public class CashbackGraphicController {
    private GetCashbackController getCashbackController;
    private BeanSession beanSession;
    private BeanPoints beanPoints;
    private BeanCard beanCard;

     public CashbackGraphicController() throws BeanException {
         this.getCashbackController = new GetCashbackController();
         this.beanSession = SessionManagerCLI.getUserDetails();
         this.beanCard = new BeanCard();
         this.beanPoints =  new BeanPoints();
     }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public BeanCard uploadCreditCard() throws DAOException, ExpiredDateCardException, ParseException {
        return getCashbackController.uploadCreditCard(beanSession);

    }
    public void saveCreditCard(String input) throws DAOException, LengthBeanCardException {
        String replaceSpace = input.replace(" ", "");
        String[] token = replaceSpace.split("-h|\\-n|\\-d");
        String cardNameSurname = token[1].replace("_", " ");
        String numberCard = token[2].replace("-", "");
        String date = token[3];
        beanCard.setCardHolderName(cardNameSurname);
        beanCard.setCardNumber(numberCard);
        try {
            beanCard.setData(date);
        } catch (ParseException e) {
            System.out.println("Date format incorrect");
        } catch (ExpiredDateCardException e) {
            System.out.println("Date is expired");
        }

        Boolean result = getCashbackController.createCard(beanCard, beanSession);
        if (Boolean.TRUE.equals(result)) {
            System.out.println("Credit card saved!");
        }
    }
    public BeanPoints uploadPoints() {
        beanPoints = null;
        try {
            beanPoints = getCashbackController.uploadPoints(beanSession);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beanPoints;
    }
    public void deleteCreditCard() throws DAOException {

        getCashbackController.deleteCreditCard(beanSession);
    }
    public void cashOutPoints(BeanPoints beanPoints) throws SQLException {
        if (beanPoints.getPoints() < 100) {
            System.out.println("Required a minimum of 100 points. You have "+beanPoints.getPoints()+" points");
        } else {
            int remainingPoints = beanPoints.getPoints() - 100;
            beanPoints.setPoints(remainingPoints);
            /*
            try {
                getCashbackController.sendMoneyToCreditCard(beanCard);
                beanPoints = getCashbackController.updatePoints(beanPoints, beanSession);
                Cashback.setPoints(beanPoints);
                System.out.println("Earned 0.50 $ ! Sending payment to you credit card...");
            } catch (NoCardInsertedException e) {
                System.out.println("You need to add a credit card ");
            }

             */

        }
    }
}
