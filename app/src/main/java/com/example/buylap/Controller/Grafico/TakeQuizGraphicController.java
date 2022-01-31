package com.example.buylap.Controller.Grafico;


import static com.example.buylap.View.HomeFragment.listQuest;

import android.se.omapi.Session;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Controller.Applicativo.QuizResultController;
import com.example.buylap.Controller.Applicativo.TakeQuizController;

import com.example.buylap.Model.Answer;
import com.example.buylap.Model.QuizList;
import com.example.buylap.View.QuizResultActivity;
import com.example.buylap.View.TakeQuizActivity;

import java.util.List;

public class TakeQuizGraphicController {

    private TakeQuizActivity takeQuizActivity;      //<--- VIEW
    private QuizResultActivity quizResultActivity;
    private TakeQuizController takeQuizController;  //<-- APPLICATIVE
    private QuizResultController quizResultController; // <-- APP
    private List<QuizList> allQuestion;
    private QuizList quizList;
    public Answer answers;
    private int index;

    public TakeQuizGraphicController( TakeQuizActivity takeQuizActivity) {

        this.takeQuizActivity = takeQuizActivity;
        this.index = 0;
        answers = new Answer("", "", "");
        allQuestion = listQuest;
        quizList = listQuest.get(index);
    }

    public void setQuiz() {

        takeQuizActivity.setQuestion(quizList.getQuestion());
        takeQuizActivity.setOp1(quizList.getOp1());
        takeQuizActivity.setOp2(quizList.getOp2());
        takeQuizActivity.setOp3(quizList.getOp3());
    }
    public void goNext(){
        index++;
        if (index >= listQuest.size() ) {


            takeQuizActivity.finished();

        } else {
            quizList = listQuest.get(index);
            takeQuizActivity.resetColor();
            setQuiz();
        }
    }
    public void getAnswer1(){
        answers.setOp1(quizList.getOp1());

    }
    public void getAnswer2(){
        answers.setOp1(quizList.getOp2());

    }
    public void getAnswer3(){
        answers.setOp1(quizList.getOp2());

    }
    public BeanAnswer sendAnswer (){

        BeanAnswer beanAnswer = new BeanAnswer();
        beanAnswer.setOp1(this.answers.getOp1());
        beanAnswer.setOp2(this.answers.getOp2());
        beanAnswer.setOp3(this.answers.getOp3());
        return beanAnswer;
    }
}

