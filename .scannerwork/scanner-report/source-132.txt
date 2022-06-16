package com.example.buylap.cli.view;

import com.example.buylap.cli.graphic_controller.CashbackGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.LengthBeanCardException;


public class CreditCard {
    private CreditCard(){
        //View Credit Card
    }
    public static void save(String input){
        CashbackGraphicController cashbackGraphicController = null;
        try {
            cashbackGraphicController = new CashbackGraphicController();
        } catch (BeanException e) {
            e.printStackTrace();
        }
        try {
            assert cashbackGraphicController != null;
            cashbackGraphicController.saveCreditCard(input);
        } catch (DAOException e) {
            System.out.println("Error while saving credit card...");
        } catch (LengthBeanCardException e) {
            System.out.println("Length maximum is 20");
        }
    }
    public static void delete(){

        CashbackGraphicController cashbackGraphicController = null;
        try {
            cashbackGraphicController = new CashbackGraphicController();
        } catch (BeanException e) {
            e.printStackTrace();
        }
        try {
            assert cashbackGraphicController != null;
            cashbackGraphicController.deleteCreditCard();
        } catch (DAOException e) {
            System.out.println("Error while deleting credit card");
        }
        System.out.println("Credit card deleted");
    }
}
