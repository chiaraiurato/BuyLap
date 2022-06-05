package com.example.buylap.cli.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.CashbackGraphicController;
import com.example.buylap.bean.BeanCard;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.cli.utils.CommandLineTable;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Cashback {

    private Cashback(){
        //View Cashback
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main() throws BeanException, DAOException, SQLException, FileNotFoundException {



        System.console().printf("                       CASHBACK                        ");
        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController();
        BeanCard beanCard = cashbackGraphicController.uploadCreditCard();
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(false);
        if(beanCard == null){
            System.out.println("\nNo card associated to user! Please digit 'add_card' ");
        }else{
            st.setHeaders("Cardholder name", "Card number", "Expire Date");

            st.addRow(beanCard.getCardHolderName() ,beanCard.getCardNumber() ,
                    beanCard.getData());
            st.print();

        }
        int points =cashbackGraphicController.uploadPoints();
        if(points == -1){
            System.out.println("\nPoints earned : 0");
        }else{
            System.out.println("\nPoints earned : "+ points);
        }

    }
    public static void cashOut() throws SQLException, FileNotFoundException, BeanException {
        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController();
        cashbackGraphicController.cashOutPoints();
    }

}
