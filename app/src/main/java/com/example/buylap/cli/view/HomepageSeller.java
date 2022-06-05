package com.example.buylap.cli.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.HomepageGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class HomepageSeller {
    private HomepageSeller(){
        //View HomepageSeller
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main() throws IOException, DAOException, BeanException, SQLException {
        System.console().printf("------------------------ HOMEPAGE SELLER -----------------------");
        String input= "";
        HomepageGraphicController homepageGraphicController = new HomepageGraphicController();
        String name =homepageGraphicController.initializeSessionCLI();

        System.console().printf("\nHi "+name +",\nWelcome back!\n");
        System.console().printf(
                "⚫ take_quiz \n" +
                "⚫ add_component -c [category] -t [titles] -s [subtitles] -p [price] -l [link]\n"+
                "⚫ show_cashback\n" +
                "⚫ cash_out \n" +
                "⚫ add_card  -h [cardholder name] -n [number card] -d [expire date]\n"+
                "⚫ delete_card\n");


        BufferedReader numberBuffer = new BufferedReader(new InputStreamReader(System.in));
        input = numberBuffer.readLine();
        homepageGraphicController.executeCommand(input);

    }
    public static void show(){
        System.console().printf(
                "⚫ take_quiz \n" +
                "⚫ add_component -c [category] -t [titles] -s [subtitles] -p [price] -l [link] \n" +
                "⚫ show_cashback\n" +
                "⚫ cash_out \n" +
                "⚫ add_card  -h [cardholder name] -n [number card] -d [expire date]\n"+
                "⚫ delete_card\n");
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void run() throws IOException, DAOException, BeanException, SQLException {
        String input= "";
        HomepageGraphicController homepageGraphicController = new HomepageGraphicController();
        BufferedReader numberBuffer = new BufferedReader(new InputStreamReader(System.in));
        input = numberBuffer.readLine();
        homepageGraphicController.executeCommand(input);
    }
}
