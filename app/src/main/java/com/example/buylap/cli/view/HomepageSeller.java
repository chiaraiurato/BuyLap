package com.example.buylap.cli.view;

import static com.example.buylap.cli.view.HomepageUser.BEAN_EXCEPTION;
import static com.example.buylap.cli.view.HomepageUser.IO_EXCEPTION;

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

public class HomepageSeller {
    private HomepageSeller(){
        //View HomepageSeller
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(){
        System.out.println("------------------------ HOMEPAGE SELLER -----------------------");
        String input= "";
        HomepageGraphicController homepageGraphicController = null;
        try {
            homepageGraphicController = new HomepageGraphicController();
        } catch (BeanException e) {
            System.out.println(BEAN_EXCEPTION);
        }
        assert homepageGraphicController != null;
        String name =homepageGraphicController.initializeSessionCLI();

        System.out.println("\nHi "+name +",\nWelcome back!\n");
        System.out.println(
                "⚫ take_quiz \n" +
                "⚫ add_component -c [category] -t [titles] -s [subtitles] -p [price] -l [link]\n"+
                "⚫ show_cashback\n" +
                "⚫ cash_out \n" +
                "⚫ add_card  -h [cardholder name] -n [number card] -d [expire date]\n"+
                "⚫ delete_card\n");


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
    public static void show(){
        System.out.println(
                "⚫ take_quiz \n" +
                "⚫ add_component -c [category] -t [titles] -s [subtitles] -p [price] -l [link] \n" +
                "⚫ show_cashback\n" +
                "⚫ cash_out \n" +
                "⚫ add_card  -h [cardholder name] -n [number card] -d [expire date]\n"+
                "⚫ delete_card\n");
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void run(){
        String input= "";
        HomepageGraphicController homepageGraphicController = null;
        try {
            homepageGraphicController = new HomepageGraphicController();
        } catch (BeanException e) {
            System.out.println(BEAN_EXCEPTION);
        }
        BufferedReader numberBuffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = numberBuffer.readLine();
        } catch (IOException e) {
            System.out.println(IO_EXCEPTION);
        }
        try {
            assert homepageGraphicController != null;
            homepageGraphicController.executeCommand(input);
        } catch (IOException e) {
            System.out.println(IO_EXCEPTION);
        }
    }
}
