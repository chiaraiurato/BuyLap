package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.buylap.CLI.main.utils.SessionManagerCLI;

import com.example.buylap.CLI.main.view.HomepageSeller;
import com.example.buylap.CLI.main.view.HomepageUser;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.RegistrationActivity;

import java.io.IOException;

public class RegistrationGraphicController {

    RegistrationActivity registrationActivity;
    RegistrationController registrationController;
    SessionManager sessionManager;
    SessionManagerCLI sessionManagerCLI;

    public RegistrationGraphicController(RegistrationActivity registrationActivity) {
        this.registrationActivity = registrationActivity;
        this.registrationController = new RegistrationController();
        sessionManager = new SessionManager(registrationActivity.getApplicationContext());
    }
    public RegistrationGraphicController(){
        this.registrationController = new RegistrationController();
        this.sessionManagerCLI = new SessionManagerCLI();
    }
    public void registerNewAccountUser() throws DAOException, BeanException {
        BeanUser beanUser = new BeanUser();
        beanUser.setUsername(registrationActivity.sendUsername());
        beanUser.setEmail(registrationActivity.sendEmail());
        beanUser.setPassword(registrationActivity.sendPassword());
        Boolean result = registrationController.createUser(beanUser);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "SignUp success for User");
        }
        sessionManager.createLoginSession(beanUser.getUsername(), beanUser.getPassword(), "USER");
        goToNavigationActivity();

    }
    private void goToNavigationActivity(){
        Intent intent = new Intent(registrationActivity, NavigationActivity.class);
        registrationActivity.startActivity(intent);
    }

    public void registerNewAccountSeller() throws DAOException {
        BeanSeller beanSeller = new BeanSeller();
        beanSeller.setUsername(registrationActivity.sendUsername());
        beanSeller.setEmail(registrationActivity.sendEmail());
        beanSeller.setPassword(registrationActivity.sendPassword());
        Boolean result = registrationController.createSeller(beanSeller);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "SignUp success for Seller");
        }
        sessionManager.createLoginSession(beanSeller.getUsername(), beanSeller.getPassword(), "SELLER");
        goToNavigationActivity();
    }

    public String selectTypeAccount( RadioButton userRadio, RadioButton sellerRadio) {
        if (TextUtils.isEmpty(registrationActivity.sendUsername()) || TextUtils.isEmpty(registrationActivity.sendEmail())
                || TextUtils.isEmpty(registrationActivity.sendPassword())) {
            Toast.makeText(registrationActivity, "All field required", Toast.LENGTH_SHORT).show();
            return "";
        } else if (!userRadio.isChecked() && !sellerRadio.isChecked()) {
            Toast.makeText(registrationActivity, "Select type account", Toast.LENGTH_SHORT).show();
            return "";
        } else if (userRadio.isChecked())
            return "USER";
        return "SELLER";
    }
    public String typeAccountCLI(String s) {
        String type= "";
        switch (Integer.parseInt(s)) {
            case 1:
                type= "USER";
                break;
            case 2:
                type = "SELLER";
                break;
            default:
                System.out.println("Error! Please select the correct number");
        }
        return type;
    }

    public void signUpUserCLI(String username, String email, String password) throws DAOException, BeanException, IOException {
        BeanUser beanUser = new BeanUser();
        beanUser.setUsername(username);
        beanUser.setEmail(email);
        beanUser.setPassword(password);
        Boolean result = registrationController.createUser(beanUser);
        if (Boolean.TRUE.equals(result)) {
            System.out.println("SignUp success for User");
        }
        sessionManagerCLI.createLoginSession(beanUser.getUsername(), beanUser.getPassword(), "USER");
        HomepageUser.main();
    }


    public void signUpSellerCLI(String username, String email, String password) throws DAOException {
        BeanSeller beanSeller = new BeanSeller();
        beanSeller.setUsername(username);
        beanSeller.setEmail(email);
        beanSeller.setPassword(password);
        Boolean result = registrationController.createSeller(beanSeller);
        if (Boolean.TRUE.equals(result)) {
            System.out.println("SignUp success for Seller");
        }
        sessionManager.createLoginSession(beanSeller.getUsername(), beanSeller.getPassword(), "SELLER");
        HomepageSeller.main();
    }
}
