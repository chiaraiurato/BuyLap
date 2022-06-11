package com.example.buylap.cli.graphic_controller;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.bean.BeanSession;
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
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.zip.DataFormatException;

public class HomepageGraphicController {
    private static final String ERROR_MSG = "Command error! Digit 'show' for usage";
    private static final String SHOW = "show";
    private static final String TAKE_QUIZ = "take_quiz";
    private static final String EXIT = "exit";
    private Map<String, String> user;
    private static BeanSession beanSession = new BeanSession();

    public HomepageGraphicController() throws BeanException {

        this.user = SessionManagerCLI.getUserDetails();
        if(user.get("user") != null) {
            beanSession.setUsername(user.get("user"));
        }
    }
    public String initializeSessionCLI() {
            return user.get("user");

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void executeCommand(String input) throws IOException, DAOException, BeanException, SQLException,LengthBeanCardException, ExpiredDateCardException, ParseException {

        if(Objects.equals(user.get("type"), "USER")) {

            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();
            switch (command) {
                case SHOW:
                    showCommands();
                    HomepageUser.run();
                    break;
                case TAKE_QUIZ:
                    TakeQuiz.main();
                    break;
                case "show_cashback":
                    Cashback.main();
                    HomepageUser.run();
                    break;
                    /*
                case "cash_out":
                    Cashback.cashOut();
                    HomepageUser.run();
                    break;

                     */
                case "add_card":
                    CreditCard.save(input);
                    HomepageUser.run();
                    break;
                case "delete_card":
                    CreditCard.delete();
                    HomepageUser.run();
                    break;
                case EXIT:
                    Exit.main();
                    break;
                default:
                    System.out.println(ERROR_MSG);
                    HomepageUser.run();
            }
        }else if(Objects.equals(user.get("type"), "SELLER")){
            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();
            switch (command) {
                case SHOW:
                    HomepageSeller.show();
                    HomepageSeller.run();
                    break;
                case TAKE_QUIZ:
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
                    /*
                    Cashback.cashOut();
                    HomepageSeller.run();

                     */
                    break;
                case "add_card":
                    CreditCard.save(input);
                    HomepageSeller.run();
                    break;
                case "delete_card":
                    CreditCard.delete();
                    HomepageSeller.run();
                    break;
                case EXIT:
                    Exit.main();
                    break;
                default:
                    System.out.println(ERROR_MSG);
                    HomepageSeller.run();

            }
        }else if(Objects.equals(user.get("type"), "GUEST")){
            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();
            switch (command) {
                case SHOW:
                    showCommands();
                    HomepageUser.run();
                    break;
                case TAKE_QUIZ:
                    TakeQuiz.main();
                    break;
                case EXIT:
                    Exit.main();
                    break;
                default:
                    System.out.println(ERROR_MSG);
                    HomepageUser.run();
        }
    }
}
    public static void showCommands(){
        if(beanSession.getUsername().equals("guest")) {
            System.out.println(
                            "⚫ take_quiz \n" +
                            "⚫ exit\n");
        }else{
            System.out.println(
                                "⚫ take_quiz \n" +
                                "⚫ show_cashback\n" +
                                "⚫ cash_out \n" +
                                "⚫ add_cart  -h [cardholder name] -n [number card] -d [expire date]\n"+
                                "⚫ delete_card\n");
            }
        }
}
