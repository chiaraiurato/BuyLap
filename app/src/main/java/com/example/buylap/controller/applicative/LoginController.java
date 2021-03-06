package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanUser;

import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.DAOException;

import com.example.buylap.model.users.ModelUser;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {


    public ModelUser searchUser(BeanUser beanUser) throws DAOException{

        try {
            ModelUser modelUser = new ModelUser(beanUser.getType(), beanUser.getUsername(), beanUser.getEmail(), beanUser.getPassword());
            modelUser = DAOuser.searchUser(modelUser);
            return modelUser;

        } catch (SQLException | IOException e) {
            throw new DAOException("error on signIn for user");
        }
    }
}

