package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Database.DAO.DAObuild;
import com.example.buylap.Database.DAO.DAOuser;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.ModelBuild;
import com.example.buylap.Model.Users.ModelUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {

    public BeanUser createUser(String username, String mail, String password) throws DAOException {
        BeanUser beanUser = null;
        ModelUser modelUsers = null;


            try {
                modelUsers = DAOuser.insertUser(username, mail, password);
                beanUser = new BeanUser();

                beanUser.setUsername(modelUsers.getUsername());
                beanUser.setEmail(modelUsers.getEmail());
                beanUser.setPassword(modelUsers.getPassword());

            } catch (SQLException e) {
                throw new DAOException("error with insert user from controller with keyword");
            }

        return beanUser;

    }
}
