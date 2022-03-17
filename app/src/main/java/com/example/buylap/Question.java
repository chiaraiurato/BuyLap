package com.example.buylap;

import com.example.buylap.model.QuizList;

import java.util.ArrayList;

public class Question {
    private ArrayList<QuizList> listQuest;

    public ArrayList<QuizList> sendQuestion() {
        listQuest = new ArrayList<>();
        listQuest.add(new QuizList("Who are you?", "Beginner", "Nerd", "Don't know"));
        listQuest.add(new QuizList("What is your profession ?", "Student", "Worker", "Business man"));
        listQuest.add(new QuizList("Click your category", "Gaming", "Office use", "Home use"));
        return listQuest;
        }
}
