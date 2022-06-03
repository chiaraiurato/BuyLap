package com.example.buylap.cli.graphic_controller;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.cli.view.AddComponent;
import com.example.buylap.cli.view.CreditCard;
import com.example.buylap.cli.view.Cashback;
import com.example.buylap.cli.view.Exit;
import com.example.buylap.cli.view.HomepageSeller;
import com.example.buylap.cli.view.HomepageUser;
import com.example.buylap.cli.view.TakeQuiz;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class HomepageGraphicController {

    private Map<String, String> user;

    public HomepageGraphicController(){

        this.user = SessionManagerCLI.getUserDetails();
    }
    public String initializeSessionCLI() {

        if(Objects.equals(user.get("type"), "USER") || Objects.equals(user.get("type"), "SELLER")) {
            return user.get("user");

        }else{
            return "guest";
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void executeCommand(String input) throws IOException, DAOException, BeanException, SQLException {

        if(Objects.equals(user.get("type"), "USER")) {

            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();
            switch (command) {
                case "show":
                    HomepageUser.show();
                    HomepageUser.run();
                    break;
                case "take_quiz":
                    TakeQuiz.main();
                    break;
                case "show_cashback":
                    Cashback.main();
                    HomepageUser.run();
                    break;
                case "cash_out":
                    Cashback.cashOut();
                    HomepageUser.run();
                    break;
                case "add_card":
                    CreditCard.save(input);
                    HomepageUser.run();
                    break;
                case "delete_card":
                    CreditCard.delete();
                    HomepageUser.run();
                    break;
                case "exit":
                    Exit.main();
                    break;
                default:
                    System.out.println("Command error");
                    HomepageUser.run();
            }
        }else if(Objects.equals(user.get("type"), "SELLER")){
            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();
            switch (command) {
                case "show":
                    HomepageSeller.show();
                    break;
                case "take_quiz":
                    TakeQuiz.main();
                    break;
                case "add_component":
                    AddComponent.main(input);
                    HomepageSeller.run();
                    break;
                case "show_cashback":
                    Cashback.main();
                    HomepageSeller.run();
                    break;
                case "cash_out":
                    Cashback.cashOut();
                    HomepageUser.run();
                    break;
                case "add_card":
                    CreditCard.save(input);
                    HomepageSeller.run();
                    break;
                case "delete_card":
                    CreditCard.delete();
                    HomepageSeller.run();
                    break;
                case "exit":
                    Exit.main();
                    break;
                default:
                    System.out.println("Command error");
                    HomepageSeller.run();
            }
        }
    }
}
