package com.example.buylap.CLI.main.view;
import com.example.buylap.CLI.main.Main;
import com.example.buylap.controller.graphic.LoginGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SignIn {


    public static void main() throws IOException {
        String username = "";
        String password = "";
        String type= "";
        System.out.println("---------------- SIGN IN ----------------");
        System.out.println("\nChoose type account:");
        System.out.println(
                "1️⃣ Personal Account\n" +
                        "2️Business account\n" +
                        "3️Go Back\n");
        LoginGraphicController loginGraphicController = new LoginGraphicController();
        try {

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            type = loginGraphicController.typeAccountCLI(s);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        System.out.println("\nEnter username ->");
        BufferedReader usernameBuffer = new BufferedReader(new InputStreamReader(System.in));
        username = usernameBuffer.readLine();


        System.out.println("\nEnter password ->");
        BufferedReader passwordBuffer = new BufferedReader(new InputStreamReader(System.in));
        password = passwordBuffer.readLine();

        if (type.equals("USER")) {
            try {
                loginGraphicController.signInUserCLI(username, password);
            } catch (BeanException throwables) {
                throwables.printStackTrace();
            } catch (DAOException e) {
                System.out.println("Sign in failed : wrong credential");
            }
        } else {
            try {
                loginGraphicController.signInSellerCLI(username, password);
            } catch (DAOException e) {
                System.out.println("Sign in failed : wrong credential");
            }
        }
        System.out.println("--------------------------------\n");
    }



}
