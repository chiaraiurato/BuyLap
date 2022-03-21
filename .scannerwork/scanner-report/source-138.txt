package com.example.buylap.utils;

import android.os.Build;

import com.example.buylap.Category;
import com.example.buylap.MostViewed;
import com.example.buylap.model.ModelBuild;
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
            mostViewed.add(new MostViewed("AMD", "Ryzen 7 3700X", "cpu"));
            mostViewed.add(new MostViewed("NVIDIA", "GTX 1800ti", "videocard"));
            mostViewed.add(new MostViewed("CORSAIR", "DDR4 32GB", "ram"));
            mostViewed.add(new MostViewed("MSI B550-A PRO", "ATX DDR4 LAN USB 3.2 Gen2 Front Type-C HDMI DisplayPort", "motherboard96"));
            return mostViewed;
        }

}
