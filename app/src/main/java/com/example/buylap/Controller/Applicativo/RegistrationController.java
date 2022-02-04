package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Bean.BeanSeller;
import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Database.DAO.DAObuild;
import com.example.buylap.Database.DAO.DAOseller;
import com.example.buylap.Database.DAO.DAOuser;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.ModelBuild;
import com.example.buylap.Model.Users.ModelUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {

    public Boolean createUser(BeanUser beanUser) throws DAOException {

            try {
                DAOuser.insertUser(beanUser);
                return true;

            } catch (SQLException e) {
                throw new DAOException("error on signup for user");
            }

    }
    public Boolean createSeller(BeanSeller beanSeller) throws DAOException {

        try {
            DAOseller.insertSeller(beanSeller);
            return true;

        } catch (SQLException e) {
            throw new DAOException("error on signup for seller");
        }

    }


}
