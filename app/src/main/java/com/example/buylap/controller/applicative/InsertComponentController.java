package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanComponentFromEbay;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.ModelBuild;
import com.example.buylap.model.users.ModelSeller;

import java.io.FileNotFoundException;

public class InsertComponentController {
    public Boolean saveComponent(BeanComponentFromEbay beanComponentFromEbay, BeanSeller beanSeller) throws DAOException {
        ModelSeller modelSeller = new ModelSeller("SELLER",beanSeller.getUsername(), beanSeller.getEmail(), beanSeller.getPassword(),
                beanSeller.getIva());
        ModelBuild modelBuild = new ModelBuild(beanComponentFromEbay.getType(), beanComponentFromEbay.getTitle(), beanComponentFromEbay.getSubtitles(),
                beanComponentFromEbay.getUrlEbay(), beanComponentFromEbay.getPrice());
        try {
            DAObuild.insertComponent(modelSeller, modelBuild);
            return true;

        } catch(FileNotFoundException e){
            e.printStackTrace();
            throw new DAOException("error saving component");
        }
    }
}
