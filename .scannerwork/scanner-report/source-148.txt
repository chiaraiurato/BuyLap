package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.buylap.cli.utils.SessionManagerCLI;

import com.example.buylap.exceptions.BeanException;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.LoginController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.users.ModelSeller;
import com.example.buylap.model.users.ModelUser;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.LoginActivity;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.RegistrationActivity;
import com.example.buylap.view.SelectTypeAccountActivity;

import java.io.IOException;

public class LoginGraphicController {

    private LoginActivity loginActivity;
    private final LoginController loginController;
    private SessionManager sessionManager;


    public LoginGraphicController(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        this.loginController = new LoginController();
        this.sessionManager = new SessionManager(loginActivity.getApplicationContext());
    }


    public void goToRegistration() {
        Intent intent = new Intent(loginActivity, SelectTypeAccountActivity.class);
        loginActivity.startActivity(intent);
    }

    private void gotoNavigationActivity(){
        Intent intent = new Intent(loginActivity, NavigationActivity.class);
        loginActivity.startActivity(intent);
    }

    public void signInUser() throws DAOException, BeanException{

            BeanUser beanUser = new BeanUser();
            beanUser.setUsername(loginActivity.sendUsername());
            beanUser.setPassword(loginActivity.sendPassword());

            ModelUser modelUser = loginController.searchUser(beanUser);
            sessionManager.createLoginSession(modelUser.getUsername(), modelUser.getPassword(), "USER");
            gotoNavigationActivity();
    }

    public void signInSeller() throws DAOException {

            BeanSeller beanSeller = new BeanSeller();
            beanSeller.setUsername(loginActivity.sendUsername());
            beanSeller.setPassword(loginActivity.sendPassword());

            ModelSeller modelSeller = loginController.searchSeller(beanSeller);
            sessionManager.createLoginSession(modelSeller.getUsername(), modelSeller.getPassword(), "SELLER");
            gotoNavigationActivity();
    }

    public String verifyFields( RadioButton userRadio, RadioButton sellerRadio) {
        if (loginActivity.sendUsername().isEmpty() || loginActivity.sendPassword().isEmpty()) {
            Toast.makeText(loginActivity, "All field required", Toast.LENGTH_SHORT).show();
            return "";
        } else if (!userRadio.isChecked() && !sellerRadio.isChecked()) {
            Toast.makeText(loginActivity, "Select type account", Toast.LENGTH_SHORT).show();
            return "";
        } else if (userRadio.isChecked())
            return "USER";
        return "SELLER";
    }


}
