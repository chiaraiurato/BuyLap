package com.example.buylap.cli.graphic_controller;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.bean.BeanCashback;
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

import java.sql.SQLException;
import java.text.ParseException;

public class CashbackGraphicController {
    private GetCashbackController getCashbackController;
    private BeanSession beanSession;
    private BeanCashback beanCashback;
    private BeanCard beanCard;

     public CashbackGraphicController() throws BeanException {
         this.getCashbackController = new GetCashbackController();
         this.beanSession = SessionManagerCLI.getUserDetails();
         this.beanCashback =  new BeanCashback();
     }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public BeanCard uploadCreditCard() throws DAOException, ExpiredDateCardException, ParseException {
        beanCard = getCashbackController.uploadCreditCard(beanSession);

        return beanCard;

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
    public BeanCashback uploadPoints() {
        beanCashback = null;
        try {
            beanCashback = getCashbackController.uploadPoints(beanSession);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beanCashback;
    }
    public void deleteCreditCard() throws DAOException {

        getCashbackController.deleteCreditCard(beanSession);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void cashOutPoints(BeanCashback beanCashback) throws SQLException {
        if (beanCashback.getPoints() < 50) {
            System.out.println("Required a minimum of 50 points. You have "+beanCashback.getPoints()+" points");
        } else {
            int remainingPoints = beanCashback.getPoints() - 50;
            beanCashback.setPoints(remainingPoints);

            try {
                getCashbackController.sendMoneyToCreditCardCLI(uploadCreditCard());
                beanCashback = getCashbackController.updatePoints(beanCashback, beanSession);
                Cashback.setPoints(beanCashback);
            } catch (NoCardInsertedException e) {
                System.out.println("You need to add a credit card ");
            } catch (DAOException | ExpiredDateCardException | ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
