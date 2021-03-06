package com.example.buylap.utils;

import com.example.buylap.model.Analytics;
import com.example.buylap.model.MostViewed;
import com.example.buylap.model.QuizList;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public List<QuizList> sendQuestion() {
        ArrayList<QuizList> listQuest;
        listQuest = new ArrayList<>();
        listQuest.add(new QuizList("Who are you?", "Beginner", "Nerd", "Don't know"));
        listQuest.add(new QuizList("What is your profession ?", "Student", "Worker", "Business man"));
        listQuest.add(new QuizList("Click your category", "Gaming", "Office use", "Home use"));
        return listQuest;
        }
    public List<MostViewed> sendMostView(){
        List<MostViewed> mostViewed;
        mostViewed = new ArrayList<>();
        mostViewed.add(new MostViewed("AMD", "Ryzen 9 5900X", "cpu"));
        mostViewed.add(new MostViewed("NVIDIA", "RTX 3060", "videocard"));
        mostViewed.add(new MostViewed("CORSAIR", "DDR4 32GB", "ram"));
        mostViewed.add(new MostViewed("MSI B550-A PRO", "ATX DDR4 LAN USB 3.2 Gen2 Front Type-C HDMI DisplayPort", "motherboard96"));
        return mostViewed;
    }
    public List<Analytics> sendAnalytics(){
        List<Analytics> analytics = new ArrayList<>();
        analytics.add(new Analytics("statistics"));
        analytics.add(new Analytics("chart"));
        analytics.add(new Analytics("booklet"));
        analytics.add(new Analytics("paidsearch"));
        return analytics;
    }

}
