package com.example.buylap.cli.graphic_controller;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.cli.view.HomepageSeller;
import com.example.buylap.cli.view.HomepageUser;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.LoginController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.model.users.ModelSeller;
import com.example.buylap.model.users.ModelUser;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


public class SignInGraphicController {

    private final LoginController loginController;

    public SignInGraphicController(){
        this.loginController = new LoginController();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void parseInput(String input) throws BeanException {
        String replaceSpace = input.replace(" ", "");
        String[] token = replaceSpace.split("-t|\\-u|\\-p|\\-m");

        String type = token[1];
        String username = token[2];
        String password = token[3];
        if (type.equals("user")) {
            ModelUser modelUser = null;
            BeanUser beanUser = new BeanUser();
            beanUser.setUsername(username);
            beanUser.setPassword(password);
            try {
                modelUser = loginController.searchUser(beanUser);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            assert modelUser != null;
            System.out.println("model user "+modelUser.getUsername());
            SessionManagerCLI.createLoginSession(modelUser.getUsername(), modelUser.getPassword(), "user");
            HomepageUser.main();

        }else if(type.equals("seller")){
            ModelSeller modelSeller = null;
            BeanSeller beanSeller = new BeanSeller();
            beanSeller.setUsername(username);
            beanSeller.setPassword(password);

            try {
                modelSeller = loginController.searchSeller(beanSeller);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            assert modelSeller != null;
            SessionManagerCLI.createLoginSession(modelSeller.getUsername(), modelSeller.getPassword(), "seller");
            HomepageSeller.main();
        }
    }
}
