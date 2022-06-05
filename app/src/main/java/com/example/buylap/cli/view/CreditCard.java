package com.example.buylap.cli.view;

import com.example.buylap.cli.graphic_controller.CashbackGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

public class CreditCard {
    private CreditCard(){
        //View Credit Card
    }
    public static void save(String input) throws BeanException, DAOException {
        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController();
        cashbackGraphicController.saveCreditCard(input);
    }
    public static void delete() throws BeanException, DAOException {

        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController();
        cashbackGraphicController.deleteCreditCard();
        System.console().printf("Credit card deleted");
    }
}
