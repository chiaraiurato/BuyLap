package com.example.buylap.cli.view;
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
    public static void main(String input) throws IOException, DAOException, BeanException, SQLException, ExpiredDateCardException, ParseException, LengthBeanCardException {

        SignInGraphicController signInGraphicController = new SignInGraphicController();

        signInGraphicController.parseInput(input);

    }



}
