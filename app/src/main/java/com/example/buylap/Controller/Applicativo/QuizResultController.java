package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanAnswer;

public class QuizResultController {

    public BeanAnswer getBeanAnswer(String answer1, String answer2, String answer3){
        BeanAnswer beanAnswer = new BeanAnswer();
        beanAnswer.setOp1(answer1);
        beanAnswer.setOp2(answer2);
        beanAnswer.setOp3(answer3);
        return beanAnswer;

    }
}
