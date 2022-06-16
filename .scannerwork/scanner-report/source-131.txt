package com.example.buylap.cli.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.bean.BeanCashback;
import com.example.buylap.cli.graphic_controller.CashbackGraphicController;
import com.example.buylap.bean.BeanCard;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.cli.utils.CommandLineTable;
import com.example.buylap.exceptions.ExpiredDateCardException;

import java.sql.SQLException;
import java.text.ParseException;

public class Cashback {

    private Cashback() {
        //View Cashback
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main() {


        System.out.println("                       CASHBACK                        ");
        CashbackGraphicController cashbackGraphicController = null;
        try {
            cashbackGraphicController = new CashbackGraphicController();
        } catch (BeanException e) {
            e.printStackTrace();
        }
        BeanCard beanCard = null;
        try {
            assert cashbackGraphicController != null;
            beanCard = cashbackGraphicController.uploadCreditCard();
        } catch (DAOException e) {
            System.out.println("Error while uploading credit card");
        } catch (ExpiredDateCardException | ParseException e) {
            System.out.println("Date is expired or date format is incorrect");

        }
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(false);
        if (beanCard == null) {
            System.out.println("\nNo card associated to user! Please digit 'add_card' ");
        } else {
            st.setHeaders("Cardholder name", "Card number", "Expire Date");

            st.addRow(beanCard.getCardHolderName(), beanCard.getCardNumber(),
                    beanCard.getData());
            st.print();

        }
        setPoints(cashbackGraphicController.uploadPoints());

    }
    public static void setPoints(BeanCashback beanPoints){
        System.out.println("\nPoints earned : " + beanPoints.getPoints());
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void cashOut(){
         CashbackGraphicController cashbackGraphicController = null;
        try {
            cashbackGraphicController = new CashbackGraphicController();
        } catch (BeanException e) {
            e.printStackTrace();
        }
        try {
            assert cashbackGraphicController != null;
            cashbackGraphicController.cashOutPoints(cashbackGraphicController.uploadPoints());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
