package com.example.buylap.Controller.Grafico;


import static com.example.buylap.View.HomeFragment.listQuest;

import android.util.Log;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Controller.Applicativo.QuizResultController;
import com.example.buylap.Controller.Applicativo.TakeQuizController;

import com.example.buylap.Model.QuizList;
import com.example.buylap.View.QuizResultActivity;
import com.example.buylap.View.TakeQuizActivity;

import java.util.List;

public class TakeQuizGraphicController {

    private TakeQuizActivity takeQuizActivity;      //<--- VIEW
    private List<QuizList> allQuestion;
    private QuizList quizList;

    private BeanAnswer beanAnswer;
    private int index;

    public TakeQuizGraphicController( TakeQuizActivity takeQuizActivity) {

        this.takeQuizActivity = takeQuizActivity;
        this.index = 0;

        beanAnswer = new BeanAnswer();
        allQuestion = listQuest;
        quizList = listQuest.get(index);
    }

    public void setQuiz() {

        takeQuizActivity.setQuestion(quizList.getQuestion());
        takeQuizActivity.setOp1(quizList.getOp1());
        takeQuizActivity.setOp2(quizList.getOp2());
        takeQuizActivity.setOp3(quizList.getOp3());
    }
    public void goNext(String answer){
        switch (index) {
            case 0:
                beanAnswer.setOp1(answer);
                break;
            case 1:
                beanAnswer.setOp2(answer);
                break;
            case 2:
                beanAnswer.setOp3(answer);
                break;
        }
        index++;
        if (index >= listQuest.size() ) {

            takeQuizActivity.finished(beanAnswer);

        } else {
                quizList = listQuest.get(index);

                takeQuizActivity.resetColor();
                setQuiz();
            }
        }

    public String getAnswer1(){
       return quizList.getOp1();
    }
    public String getAnswer2(){
        return quizList.getOp2();
    }

    public String getAnswer3(){
        return quizList.getOp3();
    }


}

