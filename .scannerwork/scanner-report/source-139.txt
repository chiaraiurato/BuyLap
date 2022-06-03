package com.example.buylap.controller.applicative;

import com.example.buylap.utils.ConstantNameTable;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.ModelBuild;
import com.example.buylap.utils.NameBuild;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TakeQuizController {

    public BeanAnswer getBeanAnswer(String answer){
        BeanAnswer beanAnswer = new BeanAnswer();
        beanAnswer.setAnswer3(answer);
        return beanAnswer;

    }
    public List<BeanBuild> createBuild(String keyword, float price){
        String[] component = new String[6];
        String nameTable = "";
        component[0] = ConstantNameTable.MOTHERBOARD;
        component[1] = ConstantNameTable.SSD;
        component[2] = ConstantNameTable.CPU;
        component[3] = ConstantNameTable.RAM;
        component[4] = ConstantNameTable.VIDEO_CARD;
        component[5] = ConstantNameTable.POWER_SUPPLY;

        if(keyword.equals("Gaming")){
            nameTable = ConstantNameTable.GAMING;
        }else if(keyword.equals("Office use")){
            nameTable = ConstantNameTable.OFFICE_USE;
        }else if(keyword.equals("Home use")){
            nameTable = ConstantNameTable.HOME_USE;
        }

        int index;
        List<BeanBuild> beanBuildList = new ArrayList<>();
        List<ModelBuild> modelBuild = new ArrayList<>();

        for(index = 0; index < 6; index++){

            try {

                if(DAObuild.selectBuild(component[index], nameTable, price) == null){
                    return beanBuildList;
                }else {
                    modelBuild.add(DAObuild.selectBuild(component[index], nameTable, price));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        index=0;
        for(NameBuild e : NameBuild.values()) {
            BeanBuild beanBuild = new BeanBuild();
            beanBuild.setType(e.name());
            beanBuild.setTitle(modelBuild.get(index).getName());
            beanBuild.setSubtitles(modelBuild.get(index).getSubtitles());
            beanBuild.setUrlEbay(modelBuild.get(index).getUrl());
            beanBuild.setPrice(modelBuild.get(index).getPrice());
            beanBuildList.add(beanBuild);
            index++;
        }

        return beanBuildList;

    }




}
