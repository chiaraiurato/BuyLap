package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanComponentFromEbay;
import com.example.buylap.model.ModelRequestBuild;
import com.example.buylap.utils.ConstantNameTable;
import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.model.ModelBuild;
import com.example.buylap.utils.NameBuild;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TakeQuizController {


    public List<BeanComponentFromEbay> createBuild(BeanAnswer beanAnswer){
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
        List<BeanComponentFromEbay> beanComponentFromEbayList = new ArrayList<>();
        List<ModelBuild> modelBuild = new ArrayList<>();

        for(index = 0; index < 6; index++){
            try {

                if(DAObuild.selectBuild(component[index], nameTable, modelRequestBuild) == null){
                    return beanComponentFromEbayList;
                }else {
                    modelBuild.add(DAObuild.selectBuild(component[index], nameTable, modelRequestBuild));
                }

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        index=0;
        for(NameBuild e : NameBuild.values()) {
            BeanComponentFromEbay beanComponentFromEbay = new BeanComponentFromEbay();
            beanComponentFromEbay.setType(e.name());
            beanComponentFromEbay.setTitle(modelBuild.get(index).getTitle());
            beanComponentFromEbay.setSubtitles(modelBuild.get(index).getSubtitles());
            beanComponentFromEbay.setUrlEbay(modelBuild.get(index).getUrlEbay());
            beanComponentFromEbay.setPrice(modelBuild.get(index).getPrice());
            beanComponentFromEbayList.add(beanComponentFromEbay);
            index++;
        }

        return beanComponentFromEbayList;

    }
}
