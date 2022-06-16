package com.example.buylap.controller.graphic;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.example.buylap.R;
import com.example.buylap.bean.BeanCashback;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.controller.applicative.TakeQuizController;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanComponentFromEbay;
import com.example.buylap.model.Category;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.QuizResultActivity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizResultGraphicController extends SessionGraphicController {
    private List<Category> build;
    private TakeQuizController takeQuizController;
    private GetCashbackController getCashbackController;
    private QuizResultActivity quizResultActivity;
    private BeanAnswer beanAnswer;
    private List<BeanComponentFromEbay> beanComponentFromEbay;
    private BeanUser credentials;

    public QuizResultGraphicController(QuizResultActivity quizResultActivity){
         super(quizResultActivity.getApplicationContext());
         this.build =  new ArrayList<>();
         this.takeQuizController = new TakeQuizController();
         this.quizResultActivity = quizResultActivity;
         this.beanAnswer = new BeanAnswer();
         this.beanComponentFromEbay = new ArrayList<>();
         this.credentials = getBeanSession();
    }

    public List<Category> setBuild(String a, String price){

        beanAnswer.setAnswer3(a);
        beanAnswer.setPriceSelected(price);

        beanComponentFromEbay = takeQuizController.createBuild(beanAnswer);
        if (beanComponentFromEbay.isEmpty()){
            openErrorDialog();
        }else {
            build.add(new Category(beanComponentFromEbay.get(0).getTitle(), "motherboard96", beanComponentFromEbay.get(0).getSubtitles(), beanComponentFromEbay.get(0).getPrice()));
            build.add(new Category(beanComponentFromEbay.get(1).getTitle(), "ssd", beanComponentFromEbay.get(1).getSubtitles(), beanComponentFromEbay.get(1).getPrice()));
            build.add(new Category(beanComponentFromEbay.get(2).getTitle(), "cpu", beanComponentFromEbay.get(2).getSubtitles(), beanComponentFromEbay.get(2).getPrice()));
            build.add(new Category(beanComponentFromEbay.get(3).getTitle(), "ram", beanComponentFromEbay.get(3).getSubtitles(), beanComponentFromEbay.get(3).getPrice()));
            build.add(new Category(beanComponentFromEbay.get(4).getTitle(), "videocard", beanComponentFromEbay.get(4).getSubtitles(), beanComponentFromEbay.get(4).getPrice()));
            build.add(new Category(beanComponentFromEbay.get(5).getTitle(), "powersupply", beanComponentFromEbay.get(5).getSubtitles(), beanComponentFromEbay.get(5).getPrice()));
        }
         return build;
     }

    private void openErrorDialog() {
        Dialog dialog = new Dialog(quizResultActivity);
        dialog.setContentView(R.layout.error_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button goToHome = dialog.findViewById(R.id.gotoHome);
        goToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(quizResultActivity, NavigationActivity.class);
                quizResultActivity.startActivity(intent);
            }
        });
        dialog.show();

    }

    public Intent linkToEbay(int position){
         final Intent intent;
             switch (position){
                 case 0:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanComponentFromEbay.get(0).getUrlEbay()));
                     break;

                 case 1:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanComponentFromEbay.get(1).getUrlEbay()));
                     break;
                 case 2:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanComponentFromEbay.get(2).getUrlEbay()));
                     break;
                 case 3:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanComponentFromEbay.get(3).getUrlEbay()));
                     break;
                 case 4:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanComponentFromEbay.get(4).getUrlEbay()));
                     break;

                 default:
                     intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanComponentFromEbay.get(5).getUrlEbay()));
                     break;
             }
         return intent;
     }


    public void updateBalance(View v) {
        Intent intent = new Intent(quizResultActivity, NavigationActivity.class);
        intent.putExtra("gotoCashback", true);
        if(credentials.getType().equals("GUEST")){
            quizResultActivity.setMessageGuest(v);
        }
        quizResultActivity.startActivity(intent);
    }

    public void madePurchase(int position) {
        float price;
        switch (position){
            case 0:
                price = beanComponentFromEbay.get(0).getPrice();
                break;
            case 1:
                price =  beanComponentFromEbay.get(1).getPrice();
                break;
            case 2:
                price =  beanComponentFromEbay.get(2).getPrice();
                break;
            case 3:
                price =  beanComponentFromEbay.get(3).getPrice();
                break;
            case 4:
                price =  beanComponentFromEbay.get(4).getPrice();
                break;
            default:
                price =  beanComponentFromEbay.get(5).getPrice();
                break;
        }
        BeanCashback beanCashback = new BeanCashback();
        beanCashback.setAmount(price);
        try {
           getCashbackController.purchasedFromEbay(beanCashback, credentials);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
