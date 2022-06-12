package com.example.buylap.cli.graphic_controller;

import static com.example.buylap.cli.view.HomepageUser.BEAN_EXCEPTION;

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
import com.example.buylap.exceptions.IvaLengthException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class SignUpGraphicController {

    public static final String EMAIL_LENGTH="Email is incorrect";
    private RegistrationController registrationController;


    public SignUpGraphicController(){
        this.registrationController = new RegistrationController();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void parseInput(String input) throws BeanException {

        String replaceSpace = input.replace(" ", "");
        String[] token = replaceSpace.split("-t|\\-u|\\-p|\\-m");

        String type = token[1];
        String username = token[2];
        String mail = token[3];
        String password = token[4];

        if (type.equals("user")) {

            BeanUser beanUser = new BeanUser();

            beanUser.setUsername(username);
            try {
                beanUser.setEmail(mail);
            } catch (EmailVerifyException e) {
                System.out.println(EMAIL_LENGTH);
            }
            beanUser.setPassword(password);
            Boolean result = null;
            try {
                result = registrationController.createUser(beanUser);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            if (Boolean.TRUE.equals(result)) {
                System.out.println("SignUp success for User");
            }
            SessionManagerCLI.createLoginSession(beanUser.getUsername(), beanUser.getPassword(), "user");
            HomepageUser.main();


        } else if (type.equals("seller")) {
            String replace = input.replace(" ", "");
            String[] token1 = replace.split("-t|\\-u|\\-m|\\-v|\\-p");
            String iva = token1[4];
            BeanSeller beanSeller = new BeanSeller();
            beanSeller.setUsername(username);
            beanSeller.setEmail(mail);
            try {
                beanSeller.setIva(iva);
            } catch (IvaLengthException e) {
                System.out.println("Length of VAT number must be 11");
            }
            beanSeller.setPassword(password);
            Boolean result = null;
            try {
                result = registrationController.createSeller(beanSeller);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            if (Boolean.TRUE.equals(result)) {
                System.out.println("SignUp success for Seller");
            }
            SessionManagerCLI.createLoginSession(beanSeller.getUsername(), beanSeller.getPassword(), "seller");
            HomepageSeller.main();
        } else {
            System.out.println("Type error! Please choose user or seller account");
        }
    }

}
