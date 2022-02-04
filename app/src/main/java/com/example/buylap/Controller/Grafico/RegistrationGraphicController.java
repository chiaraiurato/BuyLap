package com.example.buylap.Controller.Grafico;

import android.util.Log;

import com.example.buylap.Bean.BeanSeller;
import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Controller.Applicativo.RegistrationController;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.SellerHolder;
import com.example.buylap.UserHolder;
import com.example.buylap.View.RegistrationActivity;

import java.util.ArrayList;
import java.util.List;

public class RegistrationGraphicController {

    RegistrationActivity registrationActivity;
    RegistrationController registrationController;


    public RegistrationGraphicController(RegistrationActivity registrationActivity){
        this.registrationActivity = registrationActivity;
        this.registrationController = new RegistrationController();

    }
    public void registerNewAccountUser() throws DAOException {
        BeanUser beanUser = new BeanUser();
        beanUser.setUsername(registrationActivity.sendUsername());
        beanUser.setEmail(registrationActivity.sendEmail());
        beanUser.setPassword(registrationActivity.sendPassword());
        Boolean result = registrationController.createUser(beanUser);
        if(result){
            Log.d("DATABASE", "SignUp success");
        }
        UserHolder holder = UserHolder.getInstance();
        holder.setUser(beanUser);

    }
    public void registerNewAccountSeller() throws DAOException {
        BeanSeller beanSeller = new BeanSeller();
        beanSeller.setUsername(registrationActivity.sendUsername());
        beanSeller.setEmail(registrationActivity.sendEmail());
        beanSeller.setPassword(registrationActivity.sendPassword());
        Boolean result = registrationController.createSeller(beanSeller);
        if(result){
            Log.d("DATABASE", "SignUp success");
        }
        SellerHolder sellerHolder = SellerHolder.getInstance();
        sellerHolder.setSeller(beanSeller);
    }
}
