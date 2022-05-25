package com.example.buylap.CLI.main;
import com.example.buylap.CLI.main.view.HomepageUser;
import com.example.buylap.CLI.main.view.SignIn;
import com.example.buylap.CLI.main.view.SignUp;
import com.example.buylap.exceptions.BeanException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args){

        System.out.println("---------------- BUYLAP ----------------");
        System.out.println("\nEnter an option :\n" +
                "1️⃣ Sign up\n" +
                "2️Sign in\n" +
                "3️Skip for now\n");
        try{

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            switch (Integer.parseInt(s)){
                case 1:
                    SignUp.main();
                    break;
                case 2:
                    SignIn.main();
                    break;
                case 3:
                    HomepageUser.main();
                    break;
                default:
                    System.out.println("Error! Please select the correct number");


            }
            System.out.println(s);
        }
        catch(IOException | BeanException e)
        {
            e.printStackTrace();
        }



    }
}
