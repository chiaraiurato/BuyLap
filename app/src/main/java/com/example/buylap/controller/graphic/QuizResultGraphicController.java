package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.example.buylap.controller.applicative.TakeQuizController;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.Category;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.BudgetActivity;
import com.example.buylap.view.QuizResultActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizResultGraphicController {
    private List<Category> build;

    private TakeQuizController takeQuizController;
    private QuizResultActivity quizResultActivity;
    private BeanAnswer beanAnswer;
    private List<BeanBuild> beanBuild;
    private BudgetActivity budgetActivity;
    private SessionManager sessionManager;
    private float price;

     public QuizResultGraphicController(QuizResultActivity quizResultActivity){
         this.build =  new ArrayList<>();
         this.takeQuizController = new TakeQuizController();
         this.quizResultActivity = quizResultActivity;
         this.beanAnswer = new BeanAnswer();
         this.beanBuild = new ArrayList<>();
         this.sessionManager = new SessionManager(quizResultActivity.getApplicationContext());
     }

    public QuizResultGraphicController(BudgetActivity budgetActivity) {
        this.budgetActivity = budgetActivity;
    }

    public List<Category> setBuild(String a, String b, String c){
         beanAnswer= takeQuizController.getBeanAnswer(a, b, c);

         try {
             beanBuild = takeQuizController.createBuild(beanAnswer.getAnswer3(), price);
         } catch (DAOException e) {
             e.printStackTrace();
         }
         build.add(new Category(beanBuild.get(0).getTitle(), "motherboard96", beanBuild.get(0).getSubtitles(), beanBuild.get(0).getPrice()));
         build.add(new Category(beanBuild.get(1).getTitle(), "ssd", beanBuild.get(1).getSubtitles(), beanBuild.get(1).getPrice()));
         build.add(new Category(beanBuild.get(2).getTitle(), "cpu", beanBuild.get(2).getSubtitles(), beanBuild.get(2).getPrice()));
         build.add(new Category(beanBuild.get(3).getTitle(), "ram", beanBuild.get(3).getSubtitles(), beanBuild.get(3).getPrice()));
         build.add(new Category(beanBuild.get(4).getTitle(), "videocard", beanBuild.get(4).getSubtitles(), beanBuild.get(4).getPrice()));
         build.add(new Category(beanBuild.get(5).getTitle(), "powersupply", beanBuild.get(5).getSubtitles(), beanBuild.get(5).getPrice()));

         return build;
     }
     public Intent linkToEbay(int position){
         final Intent intent;
             switch (position){
                 case 0:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(0).getUrlEbay()));
                     break;

                 case 1:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(1).getUrlEbay()));
                     break;
                 case 2:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(2).getUrlEbay()));
                     break;
                 case 3:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(3).getUrlEbay()));
                     break;
                 case 4:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(4).getUrlEbay()));
                     break;

                 default:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(5).getUrlEbay()));
                     break;
             }
         return intent;
     }


    public void initializeSession(View view) {

        Map<String, String> user = sessionManager.getUserDetails();
        if(user.get("type").equals("GUEST")){
            quizResultActivity.setMessageGuest(view);
        }
    }

    public void setPrice() {
        String bg = budgetActivity.sendPrice();
        float priceTotal = Float.parseFloat(bg.substring(0, bg.length() -2 ));
        this.price = priceTotal;

    }
}
