package com.example.buylap;

public class QuizList {
    String question;
    String op1;
    String op2;

    public QuizList(String question, String op1, String op2) {
        this.question = question;
        this.op1 = op1;
        this.op2 = op2;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }


}
