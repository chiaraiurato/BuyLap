package com.example.buylap.cli.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.HomepageGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.zip.DataFormatException;

public class HomepageUser {
    private HomepageUser(){
        //View HomepageUser
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main() throws BeanException, IOException, DAOException, SQLException, LengthBeanCardException, ExpiredDateCardException, ParseException {

        System.out.println("------------------------ HOMEPAGE USER -----------------------");
        String input= "";
        HomepageGraphicController homepageGraphicController = new HomepageGraphicController();
        String name =homepageGraphicController.initializeSessionCLI();
        System.out.println("\nHi "+name +",\nWelcome back!\n");
        BufferedReader numberBuffer = new BufferedReader(new InputStreamReader(System.in));
        input = numberBuffer.readLine();
        homepageGraphicController.executeCommand(input);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void run() throws IOException, DAOException, BeanException, SQLException, LengthBeanCardException, ExpiredDateCardException, ParseException {
        String input= "";
        HomepageGraphicController homepageGraphicController = new HomepageGraphicController();
        BufferedReader numberBuffer = new BufferedReader(new InputStreamReader(System.in));
        input = numberBuffer.readLine();
        homepageGraphicController.executeCommand(input);
    }
}
