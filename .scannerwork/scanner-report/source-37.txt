package com.example.buylap.controller.graphic;


import static com.example.buylap.view.HomeFragment.listQuest;

import com.example.buylap.bean.BeanAnswer;

import com.example.buylap.model.QuizList;
import com.example.buylap.view.TakeQuizActivity;

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
                beanAnswer.setAnswer1(answer);
                break;
            case 1:
                beanAnswer.setAnswer2(answer);
                break;
            case 2:
                beanAnswer.setAnswer3(answer);
                break;
            default:
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

