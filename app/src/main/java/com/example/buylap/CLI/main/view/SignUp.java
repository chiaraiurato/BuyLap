package com.example.buylap.CLI.main.view;

import com.example.buylap.controller.graphic.RegistrationGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SignUp {

    public static void main() throws IOException {
        System.out.println("---------------- SIGN UP ----------------");

        String username = "";
        String password = "";
        String email = "";
        String type= "";
        System.out.println("\nChoose type account:");
        System.out.println(
                        "1️⃣ Personal Account\n" +
                        "2️Business account\n" +
                        "3️Go Back\n");
        RegistrationGraphicController registrationGraphicController = new RegistrationGraphicController();
        try {

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            if(Integer.parseInt(s) == 3){

            }
            type = registrationGraphicController.typeAccountCLI(s);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        System.out.println("\nEnter username ->");
        BufferedReader usernameBuffer = new BufferedReader(new InputStreamReader(System.in));
        username = usernameBuffer.readLine();

        System.out.println("\nEnter email ->");
        BufferedReader emailBuffer = new BufferedReader(new InputStreamReader(System.in));
        email = emailBuffer.readLine();

        System.out.println("\nEnter password ->");
        BufferedReader passwordBuffer = new BufferedReader(new InputStreamReader(System.in));
        password = passwordBuffer.readLine();



        if (type.equals("USER")) {
            try {
                registrationGraphicController.signUpUserCLI(username, email, password);
            } catch (BeanException throwables) {
                throwables.printStackTrace();
            } catch (DAOException e) {
                System.out.println("Sign up failed");
            }
        } else {
            try {
                registrationGraphicController.signUpSellerCLI(username, email,  password);
            } catch (DAOException e) {
                System.out.println("Sign up failed");
            }
        }
        System.out.println("--------------------------------\n");
    }


}


