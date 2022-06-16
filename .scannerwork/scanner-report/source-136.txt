package com.example.buylap.cli.view;
import static com.example.buylap.cli.view.HomepageUser.BEAN_EXCEPTION;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.SignInGraphicController;

import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class SignIn {
    private SignIn(){
        //View SignIn
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String input){

        SignInGraphicController signInGraphicController = new SignInGraphicController();

        try {
            signInGraphicController.parseInput(input);
        } catch (BeanException e) {
            System.out.println(BEAN_EXCEPTION);
        }

    }



}
