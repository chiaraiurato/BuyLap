package com.example.buylap.cli;
import static com.example.buylap.cli.view.HomepageUser.IO_EXCEPTION;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.EmailVerifyException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import org.openqa.selenium.devtools.v85.io.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main (String[] args){

        System.out.println("------------------------     BUYLAP   -----------------------\n" +
                    "............................................................\n" +
                    ".............................. .............................\n" +
                    "..........................          ........................\n" +
                    "...................                       ..................\n" +
                    "................                              ..............\n" +
                    ".............                                    ...........\n" +
                    "...........                                        .........\n" +
                    "..........               ============               ........\n" +
                    ".........                &&  |  | &&                 .......\n" +
                    "........                 &&  |  | &&                  ......\n" +
                    ".......                  ============                 ......\n" +
                    ".......                                                .....\n" +
                    ".......             &&&&&&&&&&&&&&&&&&&&&&             .....\n" +
                    ".......             &&&&&&&&&&&&&&&&&&&&&&            ......\n" +
                    "........            &&&&&&&&&&&&&&&&&&&&&&            ......\n" +
                    ".........           &&&&&&&&&&&&&&&&&&&&&&           .......\n" +
                    "..........             ||           ||             .........\n" +
                    "............           ||           ||            ..........\n" +
                    "................                              ..............\n" +
                    "...................                       ..................\n" +
                    "..........................          ........................\n" +
                    ".............................. .............................\n" +
                    "............................................................\n" +
                    "\nAll commands :\n" +
                    "⚫ show (Display in output available commands)\n" +
                    "⚫ sign_up -t user -u [username] -m [mail] -p [password] (Register new account as user)\n" +
                    "⚫ sign_up -t seller -u [username] -m [mail] -v [vat number] -p [password] (Register new account as seller)\n" +
                    "⚫ sign_in -t [type] -u [username] -p [password] (Log-in account)\n" +
                    "⚫ skip (skip registration)\n" +
                    "⚫ take_quiz \n" +
                    "⚫ add_component -c [category] -t [titles] -s [subtitles] -p [price] -l [link] \n" +
                    "⚫ show_cashback\n" +
                    "⚫ cash_out \n" +
                    "⚫ add_card  -h [cardholder name] -n [number card] -d [expire date]   (Ex. -h Mario_Rossi -n 1234-1234-1234-1234 -d 22-09)\n" +
                    "⚫ delete_card\n" +
                    "⚫ exit (exit the program) \n");

        MainGraphicController mainGraphicController = new MainGraphicController();


            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = bufferRead.readLine();
        } catch (IOException e) {
            System.out.println("IOException");
        }
        mainGraphicController.parseInput(s);



    }
    public static void show(){
        System.out.println("\n⚫ sign_up -t user -u [username] -m [mail] -p [password] (Register new account as user)\n" +
        "⚫ sign_up -t seller -u [username] -m [mail] -v [vat number] -p [password] (Register new account as seller)\n" +
                "⚫ sign_in -t [type] -u [username] -p [password] (Log-in account)\n" +
                "⚫ skip (skip registration)\n");
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void runMain(){
        MainGraphicController mainGraphicController = new MainGraphicController();
        try{

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            mainGraphicController.parseInput(s);
        }
        catch(IOException e)
        {
            System.out.println(IO_EXCEPTION);
        }

    }


}
