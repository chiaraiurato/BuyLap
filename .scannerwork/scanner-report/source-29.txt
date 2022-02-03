package com.example.buylap.Controller.Grafico;

import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Controller.Applicativo.RegistrationController;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.View.RegistrationActivity;

import java.util.ArrayList;
import java.util.List;

public class RegistrationGraphicController {

    RegistrationActivity registrationActivity;
    RegistrationController registrationController;
    List<BeanUser> beanUsers;
    //BeanUser beanUser;
    public RegistrationGraphicController(RegistrationActivity registrationActivity){
        this.registrationActivity = registrationActivity;
        this.beanUsers = new ArrayList<>();
       // this.beanUser = new BeanUser();
    }
    public void registerNewAccountUser(String username, String mail, String password) throws DAOException {

        registrationController.createUser(username, mail, password);
        //beanUsers.add(beanUser);
    }
    public void registerNewAccountSeller(String username, String mail, String password){

    }
}
