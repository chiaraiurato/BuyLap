package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOseller;
import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.users.ModelSeller;
import com.example.buylap.model.users.ModelUser;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class LoginController {


    public BeanUser searchUser(BeanUser beanUser) throws DAOException {
        ModelUser modelUser;

        try {
            modelUser = DAOuser.searchUser(beanUser);
            beanUser.setEmail(modelUser.getEmail());
            return beanUser;

        } catch (SQLException | FileNotFoundException e) {
            throw new DAOException("error on signin for user");
        }
    }

    public BeanSeller searchSeller(BeanSeller beanSeller) throws DAOException {
        ModelSeller modelSeller;

        try {
            modelSeller = DAOseller.searchSeller(beanSeller);
            beanSeller.setEmail(modelSeller.getEmail());
            return beanSeller;

        } catch (SQLException | FileNotFoundException e) {
            throw new DAOException("error on signin for seller");
        }
    }
}

