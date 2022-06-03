package com.example.buylap.cli.view;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.SignInGraphicController;

import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.io.IOException;
import java.sql.SQLException;

public class SignIn {
    private SignIn(){
        //View SignIn
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String input) throws IOException, DAOException, BeanException, SQLException {

        SignInGraphicController signInGraphicController = new SignInGraphicController();

        signInGraphicController.parseInput(input);

    }



}
