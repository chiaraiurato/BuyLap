package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Bean.BeanCpu;
import com.example.buylap.Database.DAO.DAOcpu;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.Answer;
import com.example.buylap.Model.ModelCpu;

import java.sql.SQLException;

public class BuildController {
    //risolvere con le BEAN
    public BeanCpu createBuild(String bean, String keyword) throws DAOException {
        BeanCpu beanCpu = new BeanCpu();
        ModelCpu modelCpu;
        try {
            modelCpu = DAOcpu.selectCpu(bean, keyword);
            beanCpu.setName(modelCpu.getName());
            beanCpu.setSubtitles(modelCpu.getSubtitles());
            beanCpu.setUrl(modelCpu.getUrl());
        } catch (SQLException e) {
            throw new DAOException("error with select cpu from controller");
        }
        return beanCpu;
    }

}
