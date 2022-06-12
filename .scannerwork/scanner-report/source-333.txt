package com.example.buylap;

import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.bean.BeanRequestBuild;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.model.ModelRequestBuild;
import com.example.buylap.utils.ConstantNameTable;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class QuizResultTest {
    @Test
    public void testQuizResult(){
        int index = 0;
        String[] component = new String[6];
        String nameTable = "";
        component[0] = ConstantNameTable.MOTHERBOARD;
        component[1] = ConstantNameTable.SSD;
        component[2] = ConstantNameTable.CPU;
        component[3] = ConstantNameTable.RAM;
        component[4] = ConstantNameTable.VIDEO_CARD;
        component[5] = ConstantNameTable.POWER_SUPPLY;
        BeanAnswer beanAnswer = new BeanAnswer();
        /*
        ModelRequestBuild modelRequestBuild = new ModelRequestBuild(, 1200);

        for(index = 0; index < 6; index++){

            try {

                if(DAObuild.selectBuild(component[index], nameTable,  ) == null){
                    return beanBuildList;
                }else {
                    modelBuild.add(DAObuild.selectBuild(component[index], nameTable,modelRequestBuild ));
                }

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }

         */
    }


}
