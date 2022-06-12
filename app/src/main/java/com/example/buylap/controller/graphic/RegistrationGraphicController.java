package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.buylap.exceptions.IvaLengthException;
import com.example.buylap.view.SelectTypeAccountActivity;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.EmailVerifyException;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.LoginActivity;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.RegistrationActivity;
import com.example.buylap.view.RegistrationSellerActivity;

public class RegistrationGraphicController {

    private RegistrationActivity registrationActivity;
    private RegistrationSellerActivity registrationSellerActivity;
    private SelectTypeAccountActivity selectTypeAccountActivity;
    private RegistrationController registrationController;
    private SessionManager sessionManager;

    public RegistrationGraphicController(RegistrationActivity registrationActivity) {
        this.registrationActivity = registrationActivity;
        this.registrationController = new RegistrationController();
        sessionManager = new SessionManager(registrationActivity.getApplicationContext());
    }
    public RegistrationGraphicController(RegistrationSellerActivity registrationSellerActivity){
        this.registrationSellerActivity= registrationSellerActivity;
        this.registrationController = new RegistrationController();
        sessionManager = new SessionManager(registrationSellerActivity.getApplicationContext());
    }
    public RegistrationGraphicController(SelectTypeAccountActivity selectTypeAccountActivity){
        this.selectTypeAccountActivity = selectTypeAccountActivity;
    }

    public void registerNewAccountUser() throws DAOException, BeanException {
        BeanUser beanUser = new BeanUser();
        beanUser.setUsername(registrationActivity.sendUsername());
        try {
            beanUser.setEmail(registrationActivity.sendEmail());
        } catch (EmailVerifyException e) {
            Toast.makeText(registrationActivity, "Email is invalid", Toast.LENGTH_SHORT).show();
        }
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
    private void gotoNavigationSeller(){
        Intent intent = new Intent(registrationSellerActivity, NavigationActivity.class);
        registrationSellerActivity.startActivity(intent);
    }

    public void registerNewAccountSeller() throws DAOException {
        BeanSeller beanSeller = new BeanSeller();
        beanSeller.setUsername(registrationSellerActivity.sendUsername());
        beanSeller.setEmail(registrationSellerActivity.sendEmail());
        beanSeller.setPassword(registrationSellerActivity.sendPassword());
        try {
            beanSeller.setIva(registrationSellerActivity.sendIva());
            Boolean result = registrationController.createSeller(beanSeller);
            if (Boolean.TRUE.equals(result)) {
                Log.d("DATABASE", "SignUp success for Seller");
            }
            sessionManager.createLoginSession(beanSeller.getUsername(), beanSeller.getPassword(), "SELLER");
            gotoNavigationSeller();

        } catch (IvaLengthException e) {
            Toast.makeText(registrationActivity, "Not a VAT number", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean verifyFields(){
        if (TextUtils.isEmpty(registrationActivity.sendUsername()) || TextUtils.isEmpty(registrationActivity.sendEmail())
                || TextUtils.isEmpty(registrationActivity.sendPassword())) {
            Toast.makeText(registrationActivity, "All field required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public boolean verifyFieldsSeller(){
        if (TextUtils.isEmpty(registrationSellerActivity.sendUsername()) || TextUtils.isEmpty(registrationSellerActivity.sendEmail())
                || TextUtils.isEmpty(registrationSellerActivity.sendPassword())) {
            Toast.makeText(registrationSellerActivity, "All field required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public String selectTypeAccount( RadioButton userRadio, RadioButton sellerRadio) {

        if (!userRadio.isChecked() && !sellerRadio.isChecked()) {
            Toast.makeText(selectTypeAccountActivity, "Select type account", Toast.LENGTH_SHORT).show();
            return "";
        } else if (userRadio.isChecked())
            return "USER";
        return "SELLER";
    }
    public void gotoSignUpUser(){

        Intent intent = new Intent(selectTypeAccountActivity, RegistrationActivity.class);
        selectTypeAccountActivity.startActivity(intent);
    }
    public void gotoSignUpSeller(){

        Intent intent = new Intent(selectTypeAccountActivity, RegistrationSellerActivity.class);
        selectTypeAccountActivity.startActivity(intent);
    }

    public void gotoSignIn() {
        Intent intent = new Intent(registrationActivity, LoginActivity.class);
        registrationActivity.startActivity(intent);
    }
    public void gotoSignInSeller() {
        Intent intent = new Intent(registrationSellerActivity, LoginActivity.class);
        registrationSellerActivity.startActivity(intent);
    }
}
