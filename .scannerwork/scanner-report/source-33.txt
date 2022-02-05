package com.example.buylap.Controller.Grafico;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Controller.Applicativo.LoginController;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.UserHolder;
import com.example.buylap.View.LoginActivity;
import com.example.buylap.View.NavigationActivity;
import com.example.buylap.View.RegistrationActivity;

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

    public void signIn() throws SQLException, DAOException {
        if(loginActivity.sendUsername().isEmpty() &&loginActivity.sendPassword().isEmpty())
        {
            Toast.makeText(loginActivity, "All fields requires", Toast.LENGTH_SHORT).show();
        }else {
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
}
