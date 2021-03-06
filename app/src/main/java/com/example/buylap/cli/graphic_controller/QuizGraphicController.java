package com.example.buylap.cli.graphic_controller;

import static com.example.buylap.cli.view.HomepageUser.IO_EXCEPTION;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.bean.BeanUser;
import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.cli.view.HomepageSeller;
import com.example.buylap.cli.view.HomepageUser;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanComponentFromEbay;
import com.example.buylap.controller.applicative.TakeQuizController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.cli.utils.CommandLineTable;

import java.io.IOException;
import java.util.List;

public class QuizGraphicController {

    private TakeQuizController takeQuizController;
    private final BeanAnswer beanAnswer;
    private BeanUser beanUser;
    public QuizGraphicController() throws BeanException {
        beanAnswer = new BeanAnswer();
        takeQuizController = new TakeQuizController();
        this.beanUser = SessionManagerCLI.getUserDetails();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void startQuiz(String a, String b, String c, String price ){
        if (c.equals("1")) {
            beanAnswer.setAnswer3("Gaming");
        } else if (c.equals("2")) {
            beanAnswer.setAnswer3("Office use");
        } else if (c.equals("3")) {
            beanAnswer.setAnswer3("Home use");
        }
        int index;
        beanAnswer.setPriceSelected(price);
        List<BeanComponentFromEbay> beanComponentFromEbay = takeQuizController.createBuild(beanAnswer);
        if (beanComponentFromEbay.isEmpty()) {
            System.out.println("No build found! Try with another price\n");
        } else {
            CommandLineTable st = new CommandLineTable();
            st.setShowVerticalLines(true);
            st.setHeaders("Type", "Title", "Subtitles", "Price", "Link");
            for (index = 0; index < 6; index++) {
                st.addRow(beanComponentFromEbay.get(index).getType() , beanComponentFromEbay.get(index).getTitle() ,
                        beanComponentFromEbay.get(index).getSubtitles(), (beanComponentFromEbay.get(index).getPrice()) + "$",
                        beanComponentFromEbay.get(index).getUrlEbay());
            }
            st.print();
        }
        runHomepage();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void runHomepage() {
        if(beanUser.getType().equals("user") || beanUser.getType().equals("guest") ) {
            try {
                HomepageUser.run();
            } catch (IOException e) {
                System.out.println(IO_EXCEPTION);
            }

        }else if(beanUser.getType().equals("seller")){
            HomepageSeller.run();
        }
    }
}
