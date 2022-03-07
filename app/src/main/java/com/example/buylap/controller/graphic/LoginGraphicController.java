package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.buylap.SellerHolder;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.LoginController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.UserHolder;
import com.example.buylap.view.LoginActivity;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.RegistrationActivity;

import java.sql.SQLException;

public class LoginGraphicController {
    private LoginActivity loginActivity;
    private LoginController loginController;

    public LoginGraphicController(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        this.loginController = new LoginController();
    }

    public void goToRegistration() {
        Intent intent = new Intent(loginActivity, RegistrationActivity.class);
        loginActivity.startActivity(intent);
    }

    public void signInUser() throws SQLException, DAOException {
        if (loginActivity.sendUsername().isEmpty() && loginActivity.sendPassword().isEmpty()) {
            Toast.makeText(loginActivity, "All fields requires", Toast.LENGTH_SHORT).show();
        } else {
            BeanUser beanUser = new BeanUser();
            beanUser.setUsername(loginActivity.sendUsername());
            beanUser.setPassword(loginActivity.sendPassword());

            beanUser = loginController.searchUser(beanUser);

            UserHolder holder = UserHolder.getInstance();
            holder.setUser(beanUser);
            Intent intent = new Intent(loginActivity, NavigationActivity.class);
            loginActivity.startActivity(intent);
        }
    }
    public void signInSeller() throws SQLException, DAOException {
        if (loginActivity.sendUsername().isEmpty() && loginActivity.sendPassword().isEmpty()) {
            Toast.makeText(loginActivity, "All fields requires", Toast.LENGTH_SHORT).show();
        } else {
            BeanSeller beanSeller = new BeanSeller();
            beanSeller.setUsername(loginActivity.sendUsername());
            beanSeller.setPassword(loginActivity.sendPassword());

            beanSeller = loginController.searchSeller(beanSeller);
            SellerHolder holder = SellerHolder.getInstance();
            holder.setSeller(beanSeller);
            Intent intent = new Intent(loginActivity, NavigationActivity.class);
            loginActivity.startActivity(intent);
        }
    }
    public String selectTypeAccount(String username, String password, RadioButton userRadio, RadioButton sellerRadio) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(loginActivity, "All field required", Toast.LENGTH_SHORT).show();
        } else if (!userRadio.isChecked() && !sellerRadio.isChecked()) {
            Toast.makeText(loginActivity, "Select type account", Toast.LENGTH_SHORT).show();
        } else if (userRadio.isChecked())
            return "USER";
        return "SELLER";
    }


}
