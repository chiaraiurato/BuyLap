package com.example.buylap.cli.graphic_controller;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.cli.view.HomepageSeller;
import com.example.buylap.cli.view.HomepageUser;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.controller.applicative.TakeQuizController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.cli.utils.CommandLineTable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class QuizGraphicController {

    private TakeQuizController takeQuizController;
    private final BeanAnswer beanAnswer;
    private Map<String, String> user;

    public QuizGraphicController(){
        beanAnswer = new BeanAnswer();
        takeQuizController = new TakeQuizController();
        this.user = SessionManagerCLI.getUserDetails();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void startQuiz(String a, String b, String c, String price ) throws IOException, DAOException, BeanException, SQLException {
        if (c.equals("1")) {
            beanAnswer.setAnswer3("Gaming");
        } else if (c.equals("2")) {
            beanAnswer.setAnswer3("Office use");
        } else if (c.equals("3")) {
            beanAnswer.setAnswer3("Home use");
        }
        int index;
        float floatPrice = Float.parseFloat(price);

        List<BeanBuild> beanBuild = takeQuizController.createBuild(beanAnswer.getAnswer3(), floatPrice);
        if (beanBuild.isEmpty()) {
            System.out.println("No build found! Try with another price\n");
        } else {

            CommandLineTable st = new CommandLineTable();
            st.setShowVerticalLines(true);
            st.setHeaders("Type", "Title", "Subtitles", "Price", "Link");
            for (index = 0; index < 6; index++) {
                st.addRow(beanBuild.get(index).getType() , beanBuild.get(index).getTitle() ,
                        beanBuild.get(index).getSubtitles(), (beanBuild.get(index).getPrice()) + "$",
                        beanBuild.get(index).getUrlEbay());
            }
            st.print();
            runHomepage();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void runHomepage() throws IOException, DAOException, BeanException, SQLException {
        if(Objects.equals(user.get("type"), "USER")) {
            HomepageUser.run();

        }else if(Objects.equals(user.get("type"), "SELLER")){
            HomepageSeller.run();
        }
    }
}
