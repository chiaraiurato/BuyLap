package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanBuild;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.database.dao.DAObuild;
import com.example.buylap.exceptions.DAOException;

import java.io.FileNotFoundException;

public class InsertComponentController {
    public Boolean saveComponent(BeanBuild beanBuild, BeanSession beanSession) throws DAOException {
        try {
            DAObuild.insertComponent(beanBuild, beanSession);
            return true;

        } catch(FileNotFoundException e){
            e.printStackTrace();
            throw new DAOException("error saving component");
        }
    }
}
