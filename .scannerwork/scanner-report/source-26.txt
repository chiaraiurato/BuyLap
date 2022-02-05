package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Database.DAO.DAObuild;
import com.example.buylap.Database.DAO.DAOseller;
import com.example.buylap.Database.DAO.DAOuser;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.Users.ModelUser;

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
