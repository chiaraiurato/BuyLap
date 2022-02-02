package com.example.buylap.Controller.Grafico;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Bean.BeanCpu;
import com.example.buylap.Bean.BeanMotherboard;
import com.example.buylap.Bean.BeanPower;
import com.example.buylap.Bean.BeanRam;
import com.example.buylap.Bean.BeanSsd;
import com.example.buylap.Bean.BeanVideoCard;
import com.example.buylap.Category;
import com.example.buylap.Controller.Applicativo.BuildController;
import com.example.buylap.Controller.Applicativo.QuizResultController;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.View.QuizResultActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizResultGraphicController {
    private ArrayList<Category> build;
    private BuildController buildController;
    private QuizResultController quizResultController;
    private QuizResultActivity quizResultActivity;

    private BeanAnswer beanAnswer;
    private List<BeanBuild> beanBuild;

     public QuizResultGraphicController(QuizResultActivity quizResultActivity){
         this.quizResultActivity = quizResultActivity;
         this.build =  new ArrayList<>();
         this.buildController = new BuildController();
         this.quizResultController = new QuizResultController();
         this.beanAnswer = new BeanAnswer();
         this. beanBuild = new ArrayList<>();
     }
     /*
     public BeanAnswer setBuildComponent(BeanAnswer beanAnswer){
         beanAnswer=quizResultController.getBeanAnswer(beanAnswer1, beanAnswer2, beanAnswer3);
         try {
             beanBuild = buildController.createBuild(beanAnswer.getOp3());
         } catch (DAOException e) {
             e.printStackTrace();
         }

     }


      */
}
