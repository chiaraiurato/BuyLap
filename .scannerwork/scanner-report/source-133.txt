package com.example.buylap.cli.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.SignUpGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.io.IOException;
import java.sql.SQLException;

public class SignUp {

    private SignUp(){
        //View SignUp
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String input) throws IOException, DAOException, BeanException, SQLException {

        SignUpGraphicController signUpGraphicController = new SignUpGraphicController();
        signUpGraphicController.parseInput(input);


    }


}


