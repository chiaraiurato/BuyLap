package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.Users.ModelUser;

import java.sql.SQLException;

public class LoginController {


    public BeanUser searchUser(BeanUser beanUser) throws DAOException {
        ModelUser modelUser;

        try {
            modelUser = DAOuser.searchUser(beanUser);
            beanUser.setEmail(modelUser.getEmail());
            return beanUser;

        } catch (SQLException e) {
            throw new DAOException("error on signin");
        }
    }
}
