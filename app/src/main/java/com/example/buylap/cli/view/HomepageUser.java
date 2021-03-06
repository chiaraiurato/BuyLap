package com.example.buylap.cli.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.HomepageGraphicController;
import com.example.buylap.exceptions.BeanException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomepageUser {
    public static final String IO_EXCEPTION = "IOException";
    public static final String BEAN_EXCEPTION="BeanSession is null";
    private HomepageUser(){
        //View HomepageUser
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main() {

        System.out.println("------------------------ HOMEPAGE USER -----------------------");
        String input= "";
        HomepageGraphicController homepageGraphicController = null;
        try {
            homepageGraphicController = new HomepageGraphicController();
        } catch (BeanException e) {
            e.printStackTrace();
        }
        assert homepageGraphicController != null;
        System.out.println("\nHi "+homepageGraphicController.initializeSessionCLI()+",\nWelcome back!\n");

        BufferedReader numberBuffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = numberBuffer.readLine();
        } catch (IOException e) {
            System.out.println(IO_EXCEPTION);
        }
        try {
            homepageGraphicController.executeCommand(input);
        } catch (IOException e) {
            System.out.println(IO_EXCEPTION);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void run() throws IOException{
        String input= "";
        HomepageGraphicController homepageGraphicController = null;
        try {
            homepageGraphicController = new HomepageGraphicController();
        } catch (BeanException e) {
            System.out.println(BEAN_EXCEPTION);
        }
        BufferedReader numberBuffer = new BufferedReader(new InputStreamReader(System.in));
        input = numberBuffer.readLine();
        assert homepageGraphicController != null;
        homepageGraphicController.executeCommand(input);
    }
}
