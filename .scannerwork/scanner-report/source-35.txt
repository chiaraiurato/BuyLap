package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.net.Uri;

import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.Category;
import com.example.buylap.controller.applicative.QuizResultController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.view.QuizResultActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizResultGraphicController {
    private ArrayList<Category> build;

    private QuizResultController quizResultController;

    private BeanAnswer beanAnswer;
    private List<BeanBuild> beanBuild;

     public QuizResultGraphicController(){
         this.build =  new ArrayList<>();
         this.quizResultController = new QuizResultController();
         this.beanAnswer = new BeanAnswer();
         this.beanBuild = new ArrayList<>();
     }

     public ArrayList<Category> setBuild(String a, String b, String c){
         beanAnswer=quizResultController.getBeanAnswer(a, b, c);
         try {
             beanBuild = quizResultController.createBuild(beanAnswer.getAnswer3());
         } catch (DAOException e) {
             e.printStackTrace();
         }
         build.add(new Category(beanBuild.get(0).getName(), "motherboard96", beanBuild.get(0).getSubtitles()));
         build.add(new Category(beanBuild.get(1).getName(), "ssd", beanBuild.get(1).getSubtitles()));
         build.add(new Category(beanBuild.get(2).getName(), "cpu", beanBuild.get(2).getSubtitles()));
         build.add(new Category(beanBuild.get(3).getName(), "ram", beanBuild.get(3).getSubtitles()));
         build.add(new Category(beanBuild.get(4).getName(), "videocard", beanBuild.get(4).getSubtitles()));
         build.add(new Category(beanBuild.get(5).getName(), "powersupply", beanBuild.get(5).getSubtitles()));

         return build;
     }
     public Intent linkToEbay(int position){
         final Intent intent;
             switch (position){
                 case 0:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(0).getUrl()));
                     break;

                 case 1:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(1).getUrl()));
                     break;
                 case 2:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(2).getUrl()));
                     break;
                 case 3:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(3).getUrl()));
                     break;
                 case 4:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(4).getUrl()));
                     break;

                 default:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(5).getUrl()));
                     break;
             }
         return intent;
     }




}
