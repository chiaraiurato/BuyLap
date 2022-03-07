package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.SellerHolder;
import com.example.buylap.UserHolder;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.RegistrationActivity;

public class RegistrationGraphicController {

    RegistrationActivity registrationActivity;
    RegistrationController registrationController;


    public RegistrationGraphicController(RegistrationActivity registrationActivity) {
        this.registrationActivity = registrationActivity;
        this.registrationController = new RegistrationController();

    }

    public void registerNewAccountUser() throws DAOException {
        BeanUser beanUser = new BeanUser();
        beanUser.setUsername(registrationActivity.sendUsername());
        beanUser.setEmail(registrationActivity.sendEmail());
        beanUser.setPassword(registrationActivity.sendPassword());
        Boolean result = registrationController.createUser(beanUser);
        if (Boolean.TRUE.equals(result)) {
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
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "SignUp success");
        }
        SellerHolder sellerHolder = SellerHolder.getInstance();
        sellerHolder.setSeller(beanSeller);
    }

    public String selectTypeAccount(String username, String email, String password, RadioButton userRadio, RadioButton sellerRadio) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(registrationActivity, "All field required", Toast.LENGTH_SHORT).show();
        } else if (!userRadio.isChecked() && !sellerRadio.isChecked()) {
            Toast.makeText(registrationActivity, "Select type account", Toast.LENGTH_SHORT).show();
        } else if (userRadio.isChecked())
            return "USER";
        return "SELLER";
    }
}
