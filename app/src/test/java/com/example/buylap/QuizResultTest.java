package com.example.buylap;

import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.model.ModelBuild;
import com.example.buylap.model.ModelRequestBuild;
import com.example.buylap.utils.ConstantNameTable;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizResultTest {
    @Test
    public void testQuizResult(){
        int index;
        boolean error= true;
        String[] component = new String[6];

        component[0] = ConstantNameTable.MOTHERBOARD;
        component[1] = ConstantNameTable.SSD;
        component[2] = ConstantNameTable.CPU;
        component[3] = ConstantNameTable.RAM;
        component[4] = ConstantNameTable.VIDEO_CARD;
        component[5] = ConstantNameTable.POWER_SUPPLY;
        BeanAnswer beanAnswer = new BeanAnswer();
        beanAnswer.setAnswer3("Gaming");

        String nameTable = ConstantNameTable.GAMING;

        ModelRequestBuild modelRequestBuild = new ModelRequestBuild(beanAnswer, 1100);

        List<ModelBuild> modelBuild = new ArrayList<>();
        for(index = 0; index < 6; index++){

            try {

                if(DAObuild.selectBuild(component[index], nameTable, modelRequestBuild ) == null){

                    error = false;
                }else {

                    modelBuild.add(DAObuild.selectBuild(component[index], nameTable,modelRequestBuild ));
                }

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        assertTrue("no build find with price 1100 $", error);
        assertEquals("MSI AMD B550-A PRO", modelBuild.get(0).getTitle());
        assertEquals("CRUCIAL SSD", modelBuild.get(1).getTitle());
        assertEquals("RYZEN 5", modelBuild.get(2).getTitle());
        assertEquals("Corsair VENGEANCELPX", modelBuild.get(3).getTitle());
        assertEquals("GIGABYTE GTX 1080", modelBuild.get(4).getTitle());
        assertEquals("COOLER MASTER", modelBuild.get(5).getTitle());

    }


}
