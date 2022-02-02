package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Database.DAO.DAObuild;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.ModelBuild;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizResultController {

    public BeanAnswer getBeanAnswer(String answer1, String answer2, String answer3){
        BeanAnswer beanAnswer = new BeanAnswer();
        beanAnswer.setOp1(answer1);
        beanAnswer.setOp2(answer2);
        beanAnswer.setOp3(answer3);
        return beanAnswer;

    }
    public List<BeanBuild> createBuild(String keyword) throws DAOException {
        String[] table = new String[6];

        table[0] = "motherboard";
        table[1] = "ssd";
        table[2] = "cpu";
        table[3] = "ram";
        table[4] = "videocard";
        table[5] = "powersupply";

        int index;
        List<BeanBuild> beanBuild = new ArrayList<>();
        List<ModelBuild> modelBuild = new ArrayList<ModelBuild>();
        for(index = 0; index < 6; index++){

            try {
                modelBuild.add( DAObuild.selectBuild(table[index], keyword));
                BeanBuild beanBuildinstance = new BeanBuild();
                beanBuildinstance.setName(modelBuild.get(index).getName());
                beanBuildinstance.setSubtitles(modelBuild.get(index).getSubtitles());
                beanBuildinstance.setUrl(modelBuild.get(index).getUrl());
                beanBuild.add(beanBuildinstance);
            } catch (SQLException e) {
                throw new DAOException("error with select"+ table+ " from controller with keyword" + keyword);
            }
        }
        return beanBuild;

    }
}
