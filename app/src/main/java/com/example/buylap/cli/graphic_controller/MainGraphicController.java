package com.example.buylap.cli.graphic_controller;

import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.Main;
import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.cli.view.Exit;
import com.example.buylap.cli.view.HomepageUser;
import com.example.buylap.cli.view.SignIn;
import com.example.buylap.cli.view.SignUp;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.EmailVerifyException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.view.NavigationActivity;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.StringTokenizer;

public class MainGraphicController {

    public static final boolean CLI = false;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void parseInput(String s) throws IOException, DAOException, BeanException, SQLException, LengthBeanCardException, ExpiredDateCardException, ParseException, EmailVerifyException {
        StringTokenizer st = new StringTokenizer(s);
        String command = st.nextToken();

        switch (command){
            case "show":
                Main.show();
                Main.runMain();
                break;
            case "sign_up":
                SignUp.main(s);
                break;
            case "sign_in":
                SignIn.main(s);
                break;
            case "skip":
                setGuestAccount();
                break;
            case "exit":
                Exit.main();
                break;
            default:
                System.out.println("\nCommand Error! Press --help for command usage\n");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setGuestAccount() throws DAOException, SQLException, BeanException, IOException, LengthBeanCardException, ExpiredDateCardException, ParseException {
        SessionManagerCLI.createLoginSession("guest","guest", "GUEST");
        HomepageUser.main();
    }
}
