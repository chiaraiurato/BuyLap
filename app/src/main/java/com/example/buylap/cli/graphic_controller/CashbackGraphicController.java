package com.example.buylap.cli.graphic_controller;

import android.os.Build;

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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.zip.DataFormatException;

public class CashbackGraphicController {
    GetCashbackController getCashbackController;

    private Map<String, String> user;

    private static BeanSession beanSession = new BeanSession();

     public CashbackGraphicController() throws BeanException {
         this.getCashbackController = new GetCashbackController();
         this.user = SessionManagerCLI.getUserDetails();
         if(user.get("user") != null) {
             beanSession.setUsername(user.get("user"));
         }
     }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public BeanCard uploadCreditCard() throws DAOException, ExpiredDateCardException, ParseException {
        return getCashbackController.uploadCreditCard(beanSession);

    }
    public void saveCreditCard(String input) throws DAOException, LengthBeanCardException, ExpiredDateCardException, ParseException {
        String replaceSpace = input.replace(" ", "");
        String[] token = replaceSpace.split("-h|\\-n|\\-d");


        String cardNameSurname = token[1].replace("_", " ");
        String numberCard = token[2].replace("-", "");
        String date = token[3];
        BeanCard beanCard = new BeanCard();
        beanCard.setCardHolderName(cardNameSurname);
        beanCard.setCardNumber(numberCard);
        beanCard.setData(date);

        Boolean result = getCashbackController.createCard(beanCard, beanSession);
        if (Boolean.TRUE.equals(result)) {
            System.out.println("Credit card saved!");
        }
    }
    public BeanPoints uploadPoints() throws SQLException, IOException {
        BeanPoints beanPoints = getCashbackController.uploadPoints(beanSession);
        /*
        if (beanPoints.getPoints() == 0){
            return -1;
        }

         */
        return beanPoints;
    }
    public void deleteCreditCard() throws DAOException {

        getCashbackController.deleteCreditCard(beanSession);
    }
    public void cashOutPoints() throws SQLException, IOException {
        getCashbackController.deletePoints(beanSession);
        System.out.println("\nPoints earned correctly!");
    }
}
