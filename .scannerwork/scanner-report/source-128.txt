package com.example.buylap.cli.graphic_controller;

import static com.example.buylap.cli.view.HomepageUser.IO_EXCEPTION;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.bean.BeanRequestBuild;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.cli.view.HomepageSeller;
import com.example.buylap.cli.view.HomepageUser;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.controller.applicative.TakeQuizController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.cli.utils.CommandLineTable;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.DataFormatException;

public class QuizGraphicController {

    private TakeQuizController takeQuizController;
    private final BeanAnswer beanAnswer;
    private BeanSession beanSession;
    public QuizGraphicController() throws BeanException {
        beanAnswer = new BeanAnswer();
        takeQuizController = new TakeQuizController();
        this.beanSession = SessionManagerCLI.getUserDetails();
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
        BeanRequestBuild beanRequestBuild = new BeanRequestBuild();
        beanRequestBuild.setKeyword(beanAnswer);
        beanRequestBuild.setPrice(price);
        List<BeanBuild> beanBuild = takeQuizController.createBuild(beanRequestBuild);
        if (beanBuild.isEmpty()) {
            System.out.println("No build found! Try with another price\n"+ beanRequestBuild.getPrice());
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
        }
        runHomepage();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void runHomepage() {
        if(beanSession.getType().equals("user") || beanSession.getType().equals("guest") ) {
            try {
                HomepageUser.run();
            } catch (IOException e) {
                System.out.println(IO_EXCEPTION);
            }

        }else if(beanSession.getType().equals("seller")){
            HomepageSeller.run();
        }
    }
}
