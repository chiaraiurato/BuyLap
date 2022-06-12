package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanBuild;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.ModelBuild;
import com.example.buylap.model.users.ModelSeller;

import java.io.FileNotFoundException;

public class InsertComponentController {
    public Boolean saveComponent(BeanBuild beanBuild, BeanSeller beanSeller) throws DAOException {
        ModelSeller modelSeller = new ModelSeller(beanSeller.getUsername(), beanSeller.getEmail(), beanSeller.getPassword(),
                beanSeller.getIva());
        ModelBuild modelBuild = new ModelBuild(beanBuild.getType(), beanBuild.getTitle(), beanBuild.getSubtitles(),
                beanBuild.getUrlEbay(), beanBuild.getPrice());
        try {
            DAObuild.insertComponent(modelSeller, modelBuild);
            return true;

        } catch(FileNotFoundException e){
            e.printStackTrace();
            throw new DAOException("error saving component");
        }
    }
}
