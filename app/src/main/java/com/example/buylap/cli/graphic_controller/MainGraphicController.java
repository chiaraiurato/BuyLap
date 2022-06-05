package com.example.buylap.cli.graphic_controller;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.Main;
import com.example.buylap.cli.view.Exit;
import com.example.buylap.cli.view.SignIn;
import com.example.buylap.cli.view.SignUp;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class MainGraphicController {

    public static final boolean CLI =true;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void parseInput(String s) throws IOException, DAOException, BeanException, SQLException {
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
            case "exit":
                Exit.main();
                break;
            default:
                System.out.println("\nCommand Error! Press --help for command usage\n");
        }

    }
}
