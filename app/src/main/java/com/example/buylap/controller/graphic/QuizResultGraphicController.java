package com.example.buylap.controller.graphic;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.buylap.R;
import com.example.buylap.bean.BeanRequestBuild;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.TakeQuizController;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.model.Category;
import com.example.buylap.view.NavigationActivity;
import com.example.buylap.view.QuizResultActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizResultGraphicController extends SessionGraphicController {
    private List<Category> build;
    private TakeQuizController takeQuizController;
    private QuizResultActivity quizResultActivity;
    private BeanAnswer beanAnswer;
    private List<BeanBuild> beanBuild;
    private BeanRequestBuild beanRequestBuild;
    private BeanSession beanSession;

    public QuizResultGraphicController(QuizResultActivity quizResultActivity){
         super(quizResultActivity.getApplicationContext());
         this.build =  new ArrayList<>();
         this.takeQuizController = new TakeQuizController();
         this.quizResultActivity = quizResultActivity;
         this.beanAnswer = new BeanAnswer();
         this.beanBuild = new ArrayList<>();
         this.beanSession = getBeanSession();
         this.beanRequestBuild = new BeanRequestBuild();
    }

    public List<Category> setBuild(String a, String price){

        beanAnswer= takeQuizController.getBeanAnswer(a);
        beanRequestBuild.setKeyword(beanAnswer);
        beanRequestBuild.setPrice(price);
        beanBuild = takeQuizController.createBuild(beanRequestBuild);
        if (beanBuild.isEmpty()){
            openErrorDialog();
        }else {
            build.add(new Category(beanBuild.get(0).getTitle(), "motherboard96", beanBuild.get(0).getSubtitles(), beanBuild.get(0).getPrice()));
            build.add(new Category(beanBuild.get(1).getTitle(), "ssd", beanBuild.get(1).getSubtitles(), beanBuild.get(1).getPrice()));
            build.add(new Category(beanBuild.get(2).getTitle(), "cpu", beanBuild.get(2).getSubtitles(), beanBuild.get(2).getPrice()));
            build.add(new Category(beanBuild.get(3).getTitle(), "ram", beanBuild.get(3).getSubtitles(), beanBuild.get(3).getPrice()));
            build.add(new Category(beanBuild.get(4).getTitle(), "videocard", beanBuild.get(4).getSubtitles(), beanBuild.get(4).getPrice()));
            build.add(new Category(beanBuild.get(5).getTitle(), "powersupply", beanBuild.get(5).getSubtitles(), beanBuild.get(5).getPrice()));
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


    public void updateBalance(View v) {
        Intent intent = new Intent(quizResultActivity, NavigationActivity.class);
        intent.putExtra("gotoCashback", true);
        if(beanSession.getType().equals("GUEST")){
            quizResultActivity.setMessageGuest(v);
        }
        quizResultActivity.startActivity(intent);
    }
}
