package com.example.buylap.cli.graphic_controller;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.cli.view.HomepageSeller;
import com.example.buylap.cli.view.HomepageUser;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.EmailVerifyException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class SignUpGraphicController {


    RegistrationController registrationController;


    public SignUpGraphicController(){
        this.registrationController = new RegistrationController();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void parseInput(String input) throws DAOException, BeanException, IOException, SQLException, ExpiredDateCardException, ParseException, LengthBeanCardException, EmailVerifyException {

        String replaceSpace = input.replace(" ", "");
        String[] token = replaceSpace.split("-t|\\-u|\\-p|\\-m");

        String type = token[1];
        String username = token[2];
        String mail = token[3];
        String password = token[4];

        if (type.equals("user")) {

            BeanUser beanUser = new BeanUser();
            beanUser.setUsername(username);
            beanUser.setEmail(mail);
            beanUser.setPassword(password);
            Boolean result = registrationController.createUser(beanUser);
            if (Boolean.TRUE.equals(result)) {
                System.out.println("SignUp success for User");
            }
            SessionManagerCLI.createLoginSession(beanUser.getUsername(), beanUser.getPassword(), "USER");
            HomepageUser.main();


        } else if (type.equals("seller")) {

            BeanSeller beanSeller = new BeanSeller();
            beanSeller.setUsername(username);
            beanSeller.setEmail(mail);
            beanSeller.setPassword(password);
            Boolean result = registrationController.createSeller(beanSeller);
            if (Boolean.TRUE.equals(result)) {
                System.out.println("SignUp success for Seller");
            }
            SessionManagerCLI.createLoginSession(beanSeller.getUsername(), beanSeller.getPassword(), "SELLER");
            HomepageSeller.main();


        } else {
            System.out.println("Type error! Please choose user or seller account");
        }
    }

}
