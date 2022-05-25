package com.example.buylap.CLI.main.view;

import com.example.buylap.controller.graphic.HomeGraphicController;
import com.example.buylap.exceptions.BeanException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomepageUser {
    public static void main() throws BeanException, IOException {

        System.out.println("---------------- HOMEPAGE ----------------");
        String number= "";
        HomeGraphicController homeGraphicController = new HomeGraphicController();
        String name =homeGraphicController.initializeSessionCLI();
        System.out.println("\nHi "+name +",\nWelcome back!\n");
        System.out.println(
                        "1️⃣ Take Quiz\n" +
                        "2️Go to cashback\n" +
                        "3️Exit\n");

        System.out.println("\nEnter number ->");
        BufferedReader numberBuffer = new BufferedReader(new InputStreamReader(System.in));
        number = numberBuffer.readLine();



    }
}
