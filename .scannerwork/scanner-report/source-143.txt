package com.example.buylap.controller.applicative;

import android.util.Log;

import com.example.buylap.bean.BeanCashback;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.boundary.BoundaryEbay;
import com.example.buylap.database.dao.DAOpoints;
import com.example.buylap.model.ModelCashback;
import com.example.buylap.model.ModelRequestBuild;
import com.example.buylap.utils.ConstantNameTable;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.model.ModelBuild;
import com.example.buylap.utils.NameBuild;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TakeQuizController {


    public List<BeanBuild> createBuild(BeanAnswer beanAnswer){
        String[] component = new String[6];
        ModelRequestBuild modelRequestBuild = new ModelRequestBuild(beanAnswer,
                beanAnswer.getPriceSelected());
        String nameTable = "";
        component[0] = ConstantNameTable.MOTHERBOARD;
        component[1] = ConstantNameTable.SSD;
        component[2] = ConstantNameTable.CPU;
        component[3] = ConstantNameTable.RAM;
        component[4] = ConstantNameTable.VIDEO_CARD;
        component[5] = ConstantNameTable.POWER_SUPPLY;

        if(beanAnswer.getAnswer3().equals("Gaming")){
            nameTable = ConstantNameTable.GAMING;
        }else if(beanAnswer.getAnswer3().equals("Office use")){
            nameTable = ConstantNameTable.OFFICE_USE;
        }else if(beanAnswer.getAnswer3().equals("Home use")){
            nameTable = ConstantNameTable.HOME_USE;
        }

        int index;
        List<BeanBuild> beanBuildList = new ArrayList<>();
        List<ModelBuild> modelBuild = new ArrayList<>();

        for(index = 0; index < 6; index++){
            try {

                if(DAObuild.selectBuild(component[index], nameTable, modelRequestBuild) == null){
                    return beanBuildList;
                }else {
                    modelBuild.add(DAObuild.selectBuild(component[index], nameTable, modelRequestBuild));
                }

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        index=0;
        for(NameBuild e : NameBuild.values()) {
            BeanBuild beanBuild = new BeanBuild();
            beanBuild.setType(e.name());
            beanBuild.setTitle(modelBuild.get(index).getTitle());
            beanBuild.setSubtitles(modelBuild.get(index).getSubtitles());
            beanBuild.setUrlEbay(modelBuild.get(index).getUrlEbay());
            beanBuild.setPrice(modelBuild.get(index).getPrice());
            beanBuildList.add(beanBuild);
            index++;
        }

        return beanBuildList;

    }
    public void selectPrice(BeanCashback beanCashback, BeanSession beanSession) throws SQLException {
        BoundaryEbay boundaryEbay = new BoundaryEbay();
        String username = beanSession.getUsername();
        BeanCashback beanPoints= boundaryEbay.madePurchase(beanCashback);

        ModelCashback modelCashbackNew = new ModelCashback(beanPoints.getPoints());
        ModelCashback modelCashbackOld = new ModelCashback();

        modelCashbackOld = DAOpoints.uploadPoints(modelCashbackOld, username);

        if( modelCashbackOld.getPoints() != 0) {
            modelCashbackNew.setPoints(modelCashbackNew.getPoints()+ modelCashbackOld.getPoints());
            DAOpoints.updatePoints(modelCashbackNew, username);
        }else{
            try {
                DAOpoints.addPoints(modelCashbackNew, username);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
