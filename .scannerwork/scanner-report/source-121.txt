package com.example.buylap.controller.applicative;

import android.util.Log;
import android.widget.Toast;

import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.ModelBuild;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TakeQuizController {

    public BeanAnswer getBeanAnswer(String answer1, String answer2, String answer3){
        BeanAnswer beanAnswer = new BeanAnswer();
        beanAnswer.setAnswer1(answer1);
        beanAnswer.setAnswer2(answer2);
        beanAnswer.setAnswer3(answer3);
        return beanAnswer;

    }
    public List<BeanBuild> createBuild(String keyword, double price) throws DAOException {
        String[] component = new String[6];

        component[0] = "motherboard";
        component[1] = "ssd";
        component[2] = "cpu";
        component[3] = "ram";
        component[4] = "videocard";
        component[5] = "powersupply";

        int index;
        List<BeanBuild> beanBuildList = new ArrayList<>();
        List<ModelBuild> modelBuild = new ArrayList<>();
        double counter = 0.0;
        for(index = 0; index < 6; index++){

            try {
                modelBuild.add( DAObuild.selectBuild(component[index], keyword));

                counter =counter + modelBuild.get(index).getPrice();
                if(index == 5 && counter > price){
                    Log.d("TAKE QUIZ", "counter > price (counter ->"+ counter);
                }

            } catch (SQLException e) {
                throw new DAOException("error with select"+ component+ " from controller with keyword" + keyword);
            }
        }
        for (index =0; index <6; index++){
            BeanBuild beanBuild = new BeanBuild();
            beanBuild.setTitle(modelBuild.get(index).getName());
            beanBuild.setSubtitles(modelBuild.get(index).getSubtitles());
            beanBuild.setUrlEbay(modelBuild.get(index).getUrl());
            beanBuild.setPrice(modelBuild.get(index).getPrice());
            beanBuildList.add(beanBuild);
        }
        return beanBuildList;

    }



}
