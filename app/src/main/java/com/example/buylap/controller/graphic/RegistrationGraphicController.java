package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.buylap.exceptions.BeanException;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.RegistrationActivity;

public class RegistrationGraphicController {

    private RegistrationActivity registrationActivity;
    private RegistrationController registrationController;
    private SessionManager sessionManager;

    public RegistrationGraphicController(RegistrationActivity registrationActivity) {
        this.registrationActivity = registrationActivity;
        this.registrationController = new RegistrationController();
        sessionManager = new SessionManager(registrationActivity.getApplicationContext());
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
}
