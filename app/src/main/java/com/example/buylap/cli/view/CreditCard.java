package com.example.buylap.cli.view;

import com.example.buylap.cli.graphic_controller.CashbackGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.text.ParseException;
import java.util.zip.DataFormatException;

public class CreditCard {
    private CreditCard(){
        //View Credit Card
    }
    public static void save(String input) throws BeanException, DAOException, LengthBeanCardException, ExpiredDateCardException, ParseException {
        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController();
        cashbackGraphicController.saveCreditCard(input);
    }
    public static void delete() throws BeanException, DAOException {

        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController();
        cashbackGraphicController.deleteCreditCard();
        System.out.println("Credit card deleted");
    }
}
